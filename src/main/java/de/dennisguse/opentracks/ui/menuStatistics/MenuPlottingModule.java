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

public class MenuPlottingModule {

    List<BarEntry> dataEntries;
    BarDataSet dataSet = null;
    String[] xAxisLabels = null;

    public void plotGraph(BarChart barChart, GraphChoice choice) {

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

        BarData data = new BarData(dataSet);
        data.setValueFormatter(new IntegerValueFormatter());
        barChart.setData(data);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisLabels));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setDrawGridLines(false);

        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setDrawLabels(false);
        leftAxis.setDrawGridLines(false);

        YAxis rightAxis = barChart.getAxisRight();
        rightAxis.setDrawLabels(false);
        rightAxis.setDrawGridLines(false);

        Legend legend = barChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);

        barChart.getDescription().setEnabled(false);
        barChart.invalidate();
    }

    private List<BarEntry> getRunsPerHourEntries(List<RunViewModel> runs)
    {
        ArrayList<BarEntry> toReturn = new ArrayList<>();

        for (int i = 0; i < runs.size(); i++)
        {
            RunViewModel run = runs.get(i);
            int dayRuns = run.getDayRuns();
            toReturn.add(new BarEntry(i + 1, dayRuns));
        }

        return toReturn;
    }

    private List<BarEntry> getRunsPerWeekdayEntries(List<RunViewModel> runs)
    {
        ArrayList<BarEntry> toReturn = new ArrayList<>();

        for (int i = 0; i < runs.size(); i++)
        {
            RunViewModel run = runs.get(i);
            int weekRuns = run.getWeekRuns();
            toReturn.add(new BarEntry(i + 1, weekRuns));
        }

        return toReturn;
    }

    private List<BarEntry> getRunsPerMonthEntries(List<RunViewModel> runs)
    {
        ArrayList<BarEntry> toReturn = new ArrayList<>();

        for (int i = 0; i < runs.size(); i++)
        {
            RunViewModel run = runs.get(i);
            int monthRuns = run.getMonthRuns();
            toReturn.add(new BarEntry(i + 1, monthRuns));
        }
        return toReturn;
    }

    private List<BarEntry> getRunsPerSeasonEntries(List<RunViewModel> runs)
    {
        ArrayList<BarEntry> toReturn = new ArrayList<>();

        for (int i = 0; i < runs.size(); i++)
        {
            RunViewModel run = runs.get(i);
            int seasonRuns = run.getSeasonRuns();
            toReturn.add(new BarEntry(i + 1, seasonRuns));
        }
        return toReturn;
    }
}