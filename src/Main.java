import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<SortAlgorithm<Integer>> fastSortAlgorithms = List.of(
                new HeapSort<>(),
                new MergeSort<>(),
                new QuickSort<>(),
                new ShellSort<>(),
                new ShellSortHibbard<>(),
                new ShellSortPratt<>()
        );

        List<SortAlgorithm<Integer>> slowSortAlgorithms = List.of(
                new BubbleSort<>(),
                new InsertionSort<>(),
                new SelectionSort<>()
        );
        drawAllAlgorithmsOnPane(fastSortAlgorithms, 100000, 500000, 5000);
        drawAllAlgorithmsOnPane(slowSortAlgorithms, 1000, 10000, 200);


        //drawAllAlgorithms(fastSortAlgorithms, 100000, 500000, 5000);
        //drawAllAlgorithms(slowSortAlgorithms, 1000, 10000, 200);

    }

    private static void drawAllAlgorithms(List<SortAlgorithm<Integer>> sortAlgorithms, int startSize, int maxSize, int step) {
        for (SortAlgorithm<Integer> algorithm : sortAlgorithms) {
            String title = algorithm.getClass().getSimpleName();
            List<Integer> sizes = new ArrayList<>();
            List<Integer> durations = new ArrayList<>();

            for (int currentSize = startSize; currentSize <= maxSize; currentSize += step) {
                sizes.add(currentSize);

                List<Integer> toSortList = new ArrayList<>(currentSize);
                for (int j = 0; j < currentSize; ++j)
                    toSortList.add(currentSize - j);

                Collections.shuffle(toSortList);


                long startTime = System.currentTimeMillis();
                algorithm.sort(toSortList);
                durations.add((int) (System.currentTimeMillis() - startTime));
            }

            drawGraphic(title, sizes, durations);
        }
    }

    private static void drawAllAlgorithmsOnPane(List<SortAlgorithm<Integer>> sortAlgorithms, int startSize, int maxSize, int step) {

        ChartMaker chartMaker = new ChartMaker("Средняя сложность");

        for (SortAlgorithm<Integer> algorithm : sortAlgorithms) {
            String title = algorithm.getClass().getSimpleName();
            List<Integer> sizes = new ArrayList<>();
            List<Integer> durations = new ArrayList<>();

            for (int i = startSize; i <= maxSize; i += step) {
                sizes.add(i);

                List<Integer> toSortList = new ArrayList<>(i);
                for (int j = 0; j < i; ++j)
                    toSortList.add(i - j);

                Collections.shuffle(toSortList);

                long startTime = System.currentTimeMillis();
                algorithm.sort(toSortList);
                durations.add((int) (System.currentTimeMillis() - startTime));
            }

            chartMaker.addSeries(title, sizes, durations);
        }

        SwingUtilities.invokeLater(() -> {
            chartMaker.init();
            chartMaker.setSize(800, 600);
            chartMaker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            chartMaker.setLocationRelativeTo(null);
            chartMaker.setVisible(true);
        });
    }

    private static void drawGraphic(String title, List<Integer> x, List<Integer> y) {
        SwingUtilities.invokeLater(() -> {
            ChartMaker example = new ChartMaker(title, x, y);
            example.init();
            example.setSize(800, 600);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setLocationRelativeTo(null);
            example.setVisible(true);
        });
    }
}
