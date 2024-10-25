import java.util.List;

public class QuickSort<T extends Comparable<T>> implements SortAlgorithm<T> {
    @Override
    public void sort(List<T> list) {
        sort(list, 0, list.size() - 1);
    }

    private void sort(List<T> list, int low, int high) {
        if (low < high) {
            int pi = differentiation(list, low, high);
            sort(list, low, pi - 1);
            sort(list, pi + 1, high);
        }
    }

    private int differentiation(List<T> list, int low, int high) {
        int middle = low + (high - low) / 2;
        T pillar = list.get(middle);

        T temp = list.get(middle);
        list.set(middle, list.get(high));
        list.set(high, temp);

        int i = low - 1;
        for (int j = low; j < high; ++j) {
            if (list.get(j).compareTo(pillar) < 0) {
                i++;

                temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }
}
