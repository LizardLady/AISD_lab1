import java.util.List;

public class ShellSort<T extends Comparable<T>> implements SortAlgorithm<T> {
    @Override
    public void sort(List<T> list) {
        for (int s = list.size() / 2; s > 0; s /= 2) {
            for (int i = s; i < list.size(); ++i) {
                for (int j = i - s; j >= 0 && list.get(j).compareTo(list.get(j + s)) > 0; j -= s) {
                    T temp = list.get(j);;
                    list.set(j, list.get(j + s));
                    list.set(j + s, temp);
                }
            }
        }
    }

}
