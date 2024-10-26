import java.util.List;

public class HeapSort<T extends Comparable<T>> implements SortAlgorithm<T> {
    @Override
    public void sort(List<T> list) {
        int length = list.size();
        for (int i = length / 2 - 1; i >= 0; --i) {
            differentiation(list, length, i);
        }

        for (int i = length - 1; i >= 0; --i) {
            T temp = list.getFirst();
            list.set(0, list.get(i));
            list.set(i, temp);
            differentiation(list, i, 0);
        }
    }

    private void differentiation(List<T> list, int length, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < length && list.get(left).compareTo(list.get(largest)) > 0) {
            largest = left;
        }

        if (right < length && list.get(right).compareTo(list.get(largest)) > 0) {
            largest = right;
        }

        if (largest != root) {
            T temp = list.get(root);
            list.set(root, list.get(largest));
            list.set(largest, temp);

            differentiation(list, length, largest);
        }
    }
}
