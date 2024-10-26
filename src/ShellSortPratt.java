import java.util.ArrayList;
import java.util.List;

public class ShellSortPratt<T extends Comparable<T>> implements SortAlgorithm<T> {

    @Override
    public void sort(List<T> list) {
        int n = list.size();
        List<Integer> gaps = generatePrattSequence(n);

        for (int gap : gaps) {
            for (int i = gap; i < n; i++) {
                T temp = list.get(i);
                int j;
                for (j = i; j >= gap && list.get(j - gap).compareTo(temp) > 0; j -= gap) {
                    list.set(j, list.get(j - gap));
                }
                list.set(j, temp);
            }
        }
    }

    private List<Integer> generatePrattSequence(int limit) {
        List<Integer> gaps = new ArrayList<>();
        int p = 0, q = 0;

        while (true) {
            int gap = (int) (Math.pow(2, p) * Math.pow(3, q));
            if (gap > limit) break;
            gaps.add(gap);
            if (q == 0 || (p > 0 && gaps.get(gaps.size() - 1 - 1) == (int) (Math.pow(2, p - 1) * Math.pow(3, q)))) {
                q++;
            } else {
                p++;
            }
        }

        gaps.sort((a, b) -> Integer.compare(b, a));
        return gaps;
    }
}
