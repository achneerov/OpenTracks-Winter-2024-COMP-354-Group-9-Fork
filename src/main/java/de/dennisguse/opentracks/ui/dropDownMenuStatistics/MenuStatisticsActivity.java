package de.dennisguse.opentracks.ui.dropDownMenuStatistics;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;

import de.dennisguse.opentracks.AbstractActivity;
import de.dennisguse.opentracks.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.util.ArrayList;
import java.util.List;

public class MenuStatisticsActivity extends AbstractActivity {

    private LineChart dayChart;
    private LineChart weekChart;
    private LineChart monthChart;
    private LineChart seasonChart;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
            if (id == R.id.day_filter)
            {
                displayDayGraph();
                Toast.makeText(this, "Day filter selected", Toast.LENGTH_SHORT).show();
                return true;
            }
            else if (id == R.id.week_filter)
            {
                displayWeekGraph();
                Toast.makeText(this, "Week filter selected", Toast.LENGTH_SHORT).show();
                return true;
            }
            else if (id == R.id.month_filter)
            {
                displayMonthGraph();
                Toast.makeText(this, "Month filter selected", Toast.LENGTH_SHORT).show();
                return true;
            }
            else
            {
                displaySeasonGraph();
                Toast.makeText( this, "Season filter selected", Toast.LENGTH_SHORT).show();
                return true;
            }
        }

    private void displayDayGraph() {
        dayChart.clear();
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            float yValue = (float) Math.random() * 100;
            entries.add(new Entry(i, yValue));
        }
        LineDataSet dataSet = new LineDataSet(entries, "Label");
        LineData lineData = new LineData(dataSet);
        dayChart.setData(lineData);
        dayChart.invalidate();
    }

    private void displayWeekGraph() {
        weekChart.clear();
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            float yValue = (float) Math.random() * 100;
            entries.add(new Entry(i, yValue));
        }
        LineDataSet dataSet = new LineDataSet(entries, "Label");
        LineData lineData = new LineData(dataSet);
        weekChart.setData(lineData);
        weekChart.invalidate();
    }

    private void displayMonthGraph() {
        monthChart.clear();
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            float yValue = (float) Math.random() * 100;
            entries.add(new Entry(i, yValue));
        }
        LineDataSet dataSet = new LineDataSet(entries, "Label");
        LineData lineData = new LineData(dataSet);
        monthChart.setData(lineData);
        monthChart.invalidate();
    }

    private void displaySeasonGraph() {
        seasonChart.clear();
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            float yValue = (float) Math.random() * 100;
            entries.add(new Entry(i, yValue));
        }
        LineDataSet dataSet = new LineDataSet(entries, "Label");
        LineData lineData = new LineData(dataSet);
        seasonChart.setData(lineData);
        seasonChart.invalidate();
    }

    @Override
    protected View getRootView() {
        return null;
    }
}

