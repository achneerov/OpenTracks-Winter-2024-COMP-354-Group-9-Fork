package de.dennisguse.opentracks.ui.menuStatistics;

import android.graphics.Color;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

// This class is responsible for plotting graphs based on the GraphChoice.
public class MenuPlottingModule {

    // These are the data entries for the bar chart.
    List<BarEntry> dataEntries;
    // This is the data set for the bar chart.
    BarDataSet dataSet = null;
    // These are the labels for the x-axis.
    String[] xAxisLabels = null;

    // This method plots a graph on the given BarChart based on the GraphChoice.
    public void plotGraph(BarChart barChart, GraphChoice choice) {

        // The choice determines the type of data entries and the color of the data set.
        switch (choice) {
            case DAY -> {
                dataEntries = getRunsPerHourEntries(TotalRunsProvider.getRunsPerHour());
                dataSet = new BarDataSet(dataEntries, "Number of Runs per Hour");
                dataSet.setColor(Color.parseColor("#2774AE"));
            }
            case WEEK -> {
                dataEntries = getRunsPerWeekdayEntries(TotalRunsProvider.getRunsPerWeekday());
                dataSet = new BarDataSet(dataEntries, "Number of Runs per Weekday");
                dataSet.setColor(Color.parseColor("#ED9121"));
            }
            case MONTH -> {
                dataEntries = getRunsPerMonthEntries(TotalRunsProvider.getRunsPerMonth());
                dataSet = new BarDataSet(dataEntries, "Number of Runs per Month");
                dataSet.setColor(Color.parseColor("#F8DE7E"));
            }
            case SEASON -> {
                dataEntries = getRunsPerSeasonEntries(TotalRunsProvider.getRunsPerSeason());
                dataSet = new BarDataSet(dataEntries, "Number of Runs per Season");
                dataSet.setColor(Color.parseColor("#8DB600"));
            }
        }

        // The data set is added to the BarData.
        BarData data = new BarData(dataSet);
        // The values in the BarData are formatted as integers.
        data.setValueFormatter(new IntegerValueFormatter());
        // The BarData is set to the BarChart.
        barChart.setData(data);

        // The x-axis is configured.
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisLabels));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setDrawGridLines(false);

        // The left y-axis is configured.
        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setDrawLabels(false);
        leftAxis.setDrawGridLines(false);

        // The right y-axis is configured.
        YAxis rightAxis = barChart.getAxisRight();
        rightAxis.setDrawLabels(false);
        rightAxis.setDrawGridLines(false);

        // The legend is configured.
        Legend legend = barChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);

        // The description of the BarChart is disabled.
        barChart.getDescription().setEnabled(false);
        // The BarChart is invalidated to cause a redraw.
        barChart.invalidate();
    }

    // This method returns a list of BarEntry objects representing the number of runs per hour.
    private List<BarEntry> getRunsPerHourEntries(List<RunViewModel> runs) {
        // An ArrayList of BarEntry objects is created.
        ArrayList<BarEntry> toReturn = new ArrayList<>();

        // For each run in the list of runs,
        for (int i = 0; i < runs.size(); i++) {
            // the run is retrieved,
            RunViewModel run = runs.get(i);
            // the number of runs per hour is retrieved,
            int dayRuns = run.getDayRuns();
            // a new BarEntry object is created with the number of runs and added to the list.
            toReturn.add(new BarEntry(i + 1, dayRuns));
        }

        // The list of BarEntry objects is returned.
        return toReturn;
    }

    // This method returns a list of BarEntry objects representing the number of runs per weekday.
    private List<BarEntry> getRunsPerWeekdayEntries(List<RunViewModel> runs) {
        // An ArrayList of BarEntry objects is created.
        ArrayList<BarEntry> toReturn = new ArrayList<>();

        // For each run in the list of runs,
        for (int i = 0; i < runs.size(); i++) {
            // the run is retrieved,
            RunViewModel run = runs.get(i);
            // the number of runs per weekday is retrieved,
            int weekRuns = run.getWeekRuns();
            // a new BarEntry object is created with the number of runs and added to the list.
            toReturn.add(new BarEntry(i + 1, weekRuns));
        }

        // The list of BarEntry objects is returned.
        return toReturn;
    }

    // This method returns a list of BarEntry objects representing the number of runs per month.
    private List<BarEntry> getRunsPerMonthEntries(List<RunViewModel> runs) {
        // An ArrayList of BarEntry objects is created.
        ArrayList<BarEntry> toReturn = new ArrayList<>();

        // For each run in the list of runs,
        for (int i = 0; i < runs.size(); i++) {
            // the run is retrieved,
            RunViewModel run = runs.get(i);
            // the number of runs per month is retrieved,
            int monthRuns = run.getMonthRuns();
            // a new BarEntry object is created with the number of runs and added to the list.
            toReturn.add(new BarEntry(i + 1, monthRuns));
        }
        // The list of BarEntry objects is returned.
        return toReturn;
    }

    // This method returns a list of BarEntry objects representing the number of runs per season.
    private List<BarEntry> getRunsPerSeasonEntries(List<RunViewModel> runs) {
        // An ArrayList of BarEntry objects is created.
        ArrayList<BarEntry> toReturn = new ArrayList<>();

        // For each run in the list of runs,
        for (int i = 0; i < runs.size(); i++) {
            // the run is retrieved,
            RunViewModel run = runs.get(i);
            // the number of runs per season is retrieved,
            int seasonRuns = run.getSeasonRuns();
            // a new BarEntry object is created with the number of runs and added to the list.
            toReturn.add(new BarEntry(i + 1, seasonRuns));
        }
        // The list of BarEntry objects is returned.
        return toReturn;
    }
}