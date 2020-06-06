package vue;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

public class Graphique extends JFrame {

    private static final long serialVersionUID = 1L;

    public Graphique(String applicationTitle, String chartTitle) {
	super(applicationTitle);

	// based on the dataset we create the chart
	JFreeChart chart = ChartFactory.createGanttChart(chartTitle, " ", " ", createDataset(),
		 true, true, true);

	// Adding chart into a chart panel
	ChartPanel chartPanel = new ChartPanel(chart);

	// settind default size
	chartPanel.setPreferredSize(new java.awt.Dimension(1000, 540));

	// add to contentPane
	setContentPane(chartPanel);
    }

    private IntervalCategoryDataset createDataset() {

	TaskSeriesCollection dataset = new TaskSeriesCollection();
	TaskSeries expected = new TaskSeries("Traitement du Signal 2");
	expected.add(new Task("08h30", Date.from(LocalDate.of(2020, 6, 8).atStartOfDay().toInstant(ZoneOffset.UTC)),
		Date.from(LocalDate.of(2020, 6, 9).atStartOfDay().toInstant(ZoneOffset.UTC))));

	expected.add(new Task("10h15", Date.from(LocalDate.of(2020, 6, 8).atStartOfDay().toInstant(ZoneOffset.UTC)),
		Date.from(LocalDate.of(2020, 6, 9).atStartOfDay().toInstant(ZoneOffset.UTC))));

	expected.add(new Task("12h00", Date.from(LocalDate.of(2020, 6, 9).atStartOfDay().toInstant(ZoneOffset.UTC)),
			Date.from(LocalDate.of(2020, 6, 9).atStartOfDay().toInstant(ZoneOffset.UTC))));

	expected.add(new Task("13h45", Date.from(LocalDate.of(2020, 6, 10).atStartOfDay().toInstant(ZoneOffset.UTC)),
		Date.from(LocalDate.of(2020, 6, 10).atStartOfDay().toInstant(ZoneOffset.UTC))));
	
	expected.add(new Task("15h30", Date.from(LocalDate.of(2020, 6, 10).atStartOfDay().toInstant(ZoneOffset.UTC)),
		Date.from(LocalDate.of(2020, 6, 10).atStartOfDay().toInstant(ZoneOffset.UTC))));

	expected.add(new Task("17h15", Date.from(LocalDate.of(2020, 6, 10).atStartOfDay().toInstant(ZoneOffset.UTC)),
		Date.from(LocalDate.of(2020, 6, 10).atStartOfDay().toInstant(ZoneOffset.UTC))));

	expected.add(new Task("19h00", Date.from(LocalDate.of(2020, 6, 10).atStartOfDay().toInstant(ZoneOffset.UTC)),
		Date.from(LocalDate.of(2020, 6, 10).atStartOfDay().toInstant(ZoneOffset.UTC))));

	dataset.add(expected);
	
	
	TaskSeries actual = new TaskSeries("Maths");
	actual.add(
		new Task("08h30", Date.from(LocalDate.of(2020, 6, 9).atStartOfDay().toInstant(ZoneOffset.UTC)),
			Date.from(LocalDate.of(2020, 6, 10).atStartOfDay().toInstant(ZoneOffset.UTC))));

	actual.add(new Task("10h15", Date.from(LocalDate.of(2020, 6, 8).atStartOfDay().toInstant(ZoneOffset.UTC)),
		Date.from(LocalDate.of(2020, 6, 8).atStartOfDay().toInstant(ZoneOffset.UTC))));

	actual.add(new Task("12h00", Date.from(LocalDate.of(2020, 6, 9).atStartOfDay().toInstant(ZoneOffset.UTC)),
		Date.from(LocalDate.of(2020, 6, 9).atStartOfDay().toInstant(ZoneOffset.UTC))));

	actual.add(new Task("13h45", Date.from(LocalDate.of(2020, 6, 8).atStartOfDay().toInstant(ZoneOffset.UTC)),
		Date.from(LocalDate.of(2020, 6, 8).atStartOfDay().toInstant(ZoneOffset.UTC))));
		
	actual.add(new Task("15h30", Date.from(LocalDate.of(2020, 6, 8).atStartOfDay().toInstant(ZoneOffset.UTC)),
		Date.from(LocalDate.of(2020, 6, 8).atStartOfDay().toInstant(ZoneOffset.UTC))));

	actual.add(new Task("17h15", Date.from(LocalDate.of(2020, 6, 10).atStartOfDay().toInstant(ZoneOffset.UTC)),
		Date.from(LocalDate.of(2020, 6, 11).atStartOfDay().toInstant(ZoneOffset.UTC))));

	actual.add(new Task("19h00", Date.from(LocalDate.of(2020, 6, 11).atStartOfDay().toInstant(ZoneOffset.UTC)),
		Date.from(LocalDate.of(2020, 6, 12).atStartOfDay().toInstant(ZoneOffset.UTC))));
    
	dataset.add(actual);
	
	TaskSeries actual1 = new TaskSeries("Anthropologie");
	actual1.add(new Task("08h30", Date.from(LocalDate.of(2020, 6, 8).atStartOfDay().toInstant(ZoneOffset.UTC)),
			Date.from(LocalDate.of(2020, 6, 8).atStartOfDay().toInstant(ZoneOffset.UTC))));

	actual1.add(new Task("10h15", Date.from(LocalDate.of(2020, 6, 8).atStartOfDay().toInstant(ZoneOffset.UTC)),
		Date.from(LocalDate.of(2020, 6, 8).atStartOfDay().toInstant(ZoneOffset.UTC))));

	actual1.add(new Task("12h00", Date.from(LocalDate.of(2020, 6, 9).atStartOfDay().toInstant(ZoneOffset.UTC)),
		Date.from(LocalDate.of(2020, 6, 9).atStartOfDay().toInstant(ZoneOffset.UTC))));

	actual1.add(new Task("13h45", Date.from(LocalDate.of(2020, 6, 10).atStartOfDay().toInstant(ZoneOffset.UTC)),
		Date.from(LocalDate.of(2020, 6, 10).atStartOfDay().toInstant(ZoneOffset.UTC))));
		
	actual1.add(new Task("15h30", Date.from(LocalDate.of(2020, 6, 10).atStartOfDay().toInstant(ZoneOffset.UTC)),
		Date.from(LocalDate.of(2020, 6, 10).atStartOfDay().toInstant(ZoneOffset.UTC))));

	actual1.add(new Task("17h15", Date.from(LocalDate.of(2020, 6, 10).atStartOfDay().toInstant(ZoneOffset.UTC)),
		Date.from(LocalDate.of(2020, 6, 11).atStartOfDay().toInstant(ZoneOffset.UTC))));

	actual1.add(new Task("19h00", Date.from(LocalDate.of(2020, 6, 10).atStartOfDay().toInstant(ZoneOffset.UTC)),
		Date.from(LocalDate.of(2020, 6, 10).atStartOfDay().toInstant(ZoneOffset.UTC))));
    
	dataset.add(actual1);
	
	

	return dataset;

    }

    public static void main(String[] args) {
	Graphique chart = new Graphique("Emploi du temps ECE Paris 2019/2020",
		"Emploi du temps ECE Paris 2019/2020");
	chart.pack();
	chart.setVisible(true);
    }
}