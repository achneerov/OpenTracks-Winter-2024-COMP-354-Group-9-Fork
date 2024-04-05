package de.dennisguse.opentracks.ui.dropDownMenuStatistics;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import de.dennisguse.opentracks.AbstractActivity;
import de.dennisguse.opentracks.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.util.ArrayList;
import java.util.List;

public class MenuStatisticsActivity extends AbstractActivity implements AdapterView.OnItemSelectedListener {

    private LineChart dayChart;
    private LineChart weekChart;
    private LineChart monthChart;
    private LineChart seasonChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dropdown_menu_statistics);
        dayChart = (LineChart) findViewById(R.id.dayChart);
        weekChart = (LineChart) findViewById(R.id.weekChart);
        monthChart = (LineChart) findViewById(R.id.monthChart);
        seasonChart = (LineChart) findViewById(R.id.seasonChart);
    }

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

    @Override
    public Context getApplicationContext() {
        return null;
    }


    protected void displayDayGraph() {
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

    protected void displayWeekGraph() {
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

    protected void displayMonthGraph() {
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

    protected void displaySeasonGraph() {
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

