import java.util.List;

public class InsertionSort<T extends Comparable<T>> implements SortAlgorithm<T> {
    @Override
    public void sort(List<T> list) {
        for (int i = 1; i < list.size(); ++i) {
            T current = list.get(i);
            int j = i;
            while (j > 0 && list.get(j - 1).compareTo(current) > 0) {
                list.set(j, list.get(j - 1));
                --j;
            }
            list.set(j, current);
        }
    }
}
