import java.util.List;

public class ShellSortHibbard<T extends Comparable<T>> implements SortAlgorithm<T> {

    @Override
    public void sort(List<T> list) {
        int n = list.size();
        int h = 1;
        while (h < n / 3) {
            h = 2 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(list.get(j), list.get(j - h)); j -= h) {
                    swap(list, j, j - h);
                }
            }
            h = (h - 1) / 2;
        }
    }

    private boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    private void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
