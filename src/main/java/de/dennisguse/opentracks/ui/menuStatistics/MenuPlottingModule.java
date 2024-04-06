package de.dennisguse.opentracks.ui.menuStatistics;

import android.graphics.Color;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * A module to build statistical bar charts according to each menu selection.
 */
public class MenuPlottingModule {

    public void plotGraph(BarChart barChart, GraphChoice choice) {
        List<BarEntry> dataEntries;
        BarDataSet dataSet = null;

        switch (choice) {
            case DAY -> {
                dataEntries = getRunsPerHourEntries(TotalRunsProvider.getAllTotalRuns());

                dataSet = new BarDataSet(dataEntries, "Number of runs per hour");
                dataSet.setColor(Color.parseColor("#2774AE"));
            }
            case WEEK -> {
                dataEntries = getRunsPerWeekdayEntries(TotalRunsProvider.getAllTotalRuns());

                dataSet = new BarDataSet(dataEntries, "Number of runs per weekday");
                dataSet.setColor(Color.parseColor("#ED9121"));
            }
            case MONTH -> {
                dataEntries = getRunsPerMonthEntries(TotalRunsProvider.getAllTotalRuns());

                dataSet = new BarDataSet(dataEntries, "Number of runs per month");
                dataSet.setColor(Color.parseColor("#F8DE7E"));
            }
            case SEASON -> {
                dataEntries = getRunsPerSeasonEntries(TotalRunsProvider.getAllTotalRuns());

                dataSet = new BarDataSet(dataEntries, "Number of runs per season");
                dataSet.setColor(Color.parseColor("#8DB600"));
            }
        }

        BarData data = new BarData(dataSet);
        barChart.setData(data);
        barChart.invalidate();
    }

    private List<BarEntry> getRunsPerHourEntries(List<RunViewModel> runs)
    {
        ArrayList<BarEntry> toReturn = new ArrayList<>();

        if(runs == null || runs.isEmpty())
        {
            return toReturn;
        }

        for(int i=0; i<runs.size();i++)
        {
            int runEntryNumber = i + 1;
            toReturn.add(new BarEntry(runEntryNumber,runs.get(i).getDayRuns()));
        }

        return toReturn;
    }

    private List<BarEntry> getRunsPerWeekdayEntries(List<RunViewModel> runs)
    {
        ArrayList<BarEntry> toReturn = new ArrayList<>();

        if(runs == null || runs.isEmpty())
        {
            return toReturn;
        }

        for(int i=0; i<runs.size();i++)
        {
            int runEntryNumber = i + 1;
            toReturn.add(new BarEntry(runEntryNumber,runs.get(i).getWeekRuns()));
        }

        return toReturn;
    }

    private List<BarEntry> getRunsPerMonthEntries(List<RunViewModel> runs){
        ArrayList<BarEntry> toReturn = new ArrayList<>();

        for (int i = 0; i < runs.size(); i++){
            RunViewModel run = runs.get(i);
            int monthRuns = run.getMonthRuns();
            toReturn.add(new BarEntry(i+1, monthRuns));
        }
        return toReturn;
    }

    private List<BarEntry> getRunsPerSeasonEntries(List<RunViewModel> runs){
        ArrayList<BarEntry> toReturn = new ArrayList<>();

        for (int i = 0; i < runs.size(); i++){
            RunViewModel run = runs.get(i);
            int seasonRuns = run.getSeasonRuns();
            toReturn.add(new BarEntry(i+1, seasonRuns));
        }
        return toReturn;
    }
}