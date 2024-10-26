import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ChartMaker extends JFrame {
    private XYSeriesCollection dataset;
    private String title;

    public ChartMaker(String title) {
        super(title);

        this.dataset = new XYSeriesCollection();
        this.title = title;

    }

    public ChartMaker(String title, List<Integer> listSizes, List<Integer> durations) {
        super(title);


        // Создаем набор данных
        this.dataset = createDataset(listSizes, durations);
        this.title = title;

    }

    public void init() {
        JFreeChart chart = ChartFactory.createScatterPlot(title, "Размер массива", "Время, ms", dataset, PlotOrientation.VERTICAL, true, false, false);

        // Создаем панель для отображения диаграммы
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(800, 600));
        setContentPane(panel);
    }

    public void addSeries(String title, List<Integer> x, List<Integer> y) {
        XYSeries series = new XYSeries(title);
        for (int i = 0; i < x.size(); ++i) {
            series.add(x.get(i), y.get(i));
        }

        addSeries(series);
    }

    public void addSeries(XYSeries series) {
        this.dataset.addSeries(series);
    }

    private XYSeriesCollection createDataset(List<Integer> listSizes, List<Integer> durations) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Серия 1");

        for (int i = 0; i < listSizes.size(); ++i) {
            series1.add(listSizes.get(i), durations.get(i));
        }

        dataset.addSeries(series1);
        return dataset;
    }
}