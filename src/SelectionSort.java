import java.util.List;

public class SelectionSort<T extends Comparable<T>> implements SortAlgorithm<T> {
    @Override
    public void sort(List<T> list) {
        for (int i = 0; i < list.size(); ++i) {

            int minIndex = i;
            for (int j = i; j < list.size(); ++j) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = list.get(minIndex);
                list.set(minIndex, list.get(i));
                list.set(i, temp);
            }
        }
    }
}
