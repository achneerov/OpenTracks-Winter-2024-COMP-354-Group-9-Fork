package de.dennisguse.opentracks.ui.dropDownMenuStatistics;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.github.mikephil.charting.charts.LineChart;
import de.dennisguse.opentracks.R;
import de.dennisguse.opentracks.AbstractActivity;
import de.dennisguse.opentracks.databinding.DailyStatsBinding;
import de.dennisguse.opentracks.ui.aggregatedStatistics.dailyStats.DailyPlottingModule;
import de.dennisguse.opentracks.ui.aggregatedStatistics.dailyStats.Frequency;
import de.dennisguse.opentracks.ui.aggregatedStatistics.dailyStats.Metric;

/**
 * <menu>
 * <item
 *     android:id="@+id/day_filter"
 *     android:title="@string/day"
 *     android:icon="@drawable/baseline_today_24"
 *     android:orderInCategory="1"
 *     app:showAsAction="ifRoom" />
 * <item
 *     android:id="@+id/week_filter"
 *     android:title="@string/week"
 *     android:icon="@drawable/baseline_calendar_view_week_24"
 *     android:orderInCategory="2"
 *     app:showAsAction="ifRoom" />
 * <item
 *     android:id="@+id/month_filter"
 *     android:title="@string/month"
 *     android:icon="@drawable/baseline_calendar_month_24"
 *     android:orderInCategory="3"
 *     app:showAsAction="ifRoom" />
 * <item
 *     android:id="@+id/season_filter"
 *     android:title="@string/season"
 *     android:icon="@drawable/baseline_season_24"
 *     android:orderInCategory="4"
 *     app:showAsAction="ifRoom" />
 * </menu>
 */

public class MenuStatisticsActivity extends AbstractActivity implements AdapterView.OnItemSelectedListener {
    private DailyStatsBinding viewBinding;
    private Metric selectedGraph = null;
    private Frequency selectedFrequency = null;
    private final DailyPlottingModule dailyPlottingModule = new DailyPlottingModule();
    private LineChart line_chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Spinner graph_selector = (Spinner)findViewById(R.id.graph_selector);
        ArrayAdapter<Metric> array_metrics = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Metric.values());
        graph_selector.setAdapter(array_metrics);

        line_chart = (LineChart) findViewById(R.id.barChart);
        graph_selector.setOnItemSelectedListener(this);

        setSupportActionBar(viewBinding.bottomAppBarLayout.bottomAppBar);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.graph_selector) {
            selectedGraph = Metric.values()[position];
            Log.d("STATISTICS", "Selection: \"" + selectedGraph + "\" selected.");
        }

        if (selectedGraph != null) {
            dailyPlottingModule.plotGraph(line_chart, selectedGraph, selectedFrequency);
            Log.d("STATISTICS_PLOTTED", "Selection: " + selectedGraph);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        if (parent.getId() == R.id.graph_selector) {
            selectedGraph = null;
        }
        line_chart.clear();
    }

    @Override
    protected View getRootView() {
        viewBinding = DailyStatsBinding.inflate(getLayoutInflater());
        return viewBinding.getRoot();
    }
}