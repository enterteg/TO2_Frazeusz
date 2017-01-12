package ploter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ploter extends JFrame {

    JPanel tablePanel = new JPanel();
    ResultTable resultTable = new ResultTable();

    JPanel chartPanel = new JPanel();
    Chart chart;

    JPanel monitorPanel = new JPanel();
    JLabel monitorTitle = new JLabel("Statystyki");

    JTabbedPane tabbedPane = new JTabbedPane();

    JButton addRowButton = new JButton("Dodaj +");

    public Ploter() {
        this.setTitle("Frazeusz");

        this.chart = new Chart(new String[]{"Fraza 1", "Fraza 2", "Fraza 3"});
        chartPanel.add(chart.getChart());

        monitorPanel.add(monitorTitle);

        this.addResult(new Result("http://www.ifp.pl/", "Fraza 1", "Zdanie w którym znaleziono fraze"));
        this.addResult(new Result("https://www.example.com/", "Fraza 2", "Zdanie w którym znaleziono fraze"));

        tablePanel.add(resultTable.createResultTable());

        addRowButton.addActionListener(new AddRowHandler());

        tablePanel.add(addRowButton);

        tabbedPane.add("Tabela wyników", tablePanel);
        tabbedPane.add("Wykresy z danymi", chartPanel);
        tabbedPane.add("Statystyki", monitorPanel);

        add(tabbedPane);
    }

    public void addResult(Result result) {
        resultTable.addRow(result);
        chartPanel.removeAll();
        chartPanel.add(chart.refresh(result));
        chartPanel.revalidate();
    }

    public static void main(String[] args) {
        Ploter ploter = new Ploter();
        ploter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ploter.setSize(800, 520);
        ploter.setVisible(true);
    }

    private class AddRowHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Result result = new Result("https://www.example.com/", "Fraza 3", "Zdanie w którym znaleziono fraze");
            addResult(result);
        }
    }
}
