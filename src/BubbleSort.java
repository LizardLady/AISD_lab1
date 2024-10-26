import java.util.List;

public class BubbleSort<T extends Comparable<T>> implements SortAlgorithm<T> {
    @Override
    public void sort(List<T> list) {
        for (int i = 0; i < list.size() - 1; ++i) {
            int flag = 0;
            for (int j = 0; j < list.size() - i - 1; ++j) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    flag += 1;
                }
            }
            if (flag == 0) {
                break;
            }
        }
    }
}
