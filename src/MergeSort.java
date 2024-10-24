import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> implements SortAlgorithm<T> {
    @Override
    public void sort(List<T> list) {
        sort(list, 0, list.size());
    }

    private void sort(List<T> list, int left, int right) {
        if (left + 1 >= right) {
            return;
        }
        int middle = (left + right) / 2;
        sort(list, left, middle);
        sort(list, middle, right);
        merge(list, left, middle, right);
    }

    private void merge(List<T> list, int left, int middle, int right) {
        int iter1 = 0;
        int iter2 = 0;
        List<T> result = new ArrayList<>(right - left);
        for (int i = 0; i < right - left; ++i) {
            result.add(null);
        }

        while (left + iter1 < middle && middle + iter2 < right) {
            if (list.get(left + iter1).compareTo(list.get(middle + iter2)) < 0) {
                result.set(iter1 + iter2, list.get(left + iter1));
                iter1 += 1;
            } else {
                result.set(iter1 + iter2, list.get(middle + iter2));
                iter2 += 1;
            }
        }
        while (left + iter1 < middle) {
            result.set(iter1 + iter2, list.get(left + iter1));
            iter1 += 1;
        }

        while (middle + iter2 < right) {
            result.set(iter1 + iter2, list.get(middle + iter2));
            iter2 += 1;
        }

        for (int i = 0; i < iter1 + iter2; ++i) {
            list.set(left + i, result.get(i));
        }
    }
}
