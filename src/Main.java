import java.util.ArrayList;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 0));
        new SelectionSort<Integer>().sort(list1);
        List<Integer> list2 = new ArrayList<>(List.of(0, 1, 2, 4, 3, 5, 6, 7, 8, 9));
        new SelectionSort<Integer>().sort(list2);

        List<Integer> list3 = new ArrayList<>();
        for (int i = 1000; i > 0; --i){
            list3.add(i);
        }
        new InsertionSort<Integer>().sort(list3);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
    }
}