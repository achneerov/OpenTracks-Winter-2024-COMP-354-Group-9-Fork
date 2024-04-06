package de.dennisguse.opentracks.ui.menuStatistics;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.github.mikephil.charting.charts.BarChart;
import de.dennisguse.opentracks.AbstractActivity;
import de.dennisguse.opentracks.R;
import de.dennisguse.opentracks.databinding.MenuStatisticsBinding;

public class MenuStatisticsActivity extends AbstractActivity implements AdapterView.OnItemSelectedListener {
    private MenuStatisticsBinding viewBinding;
    private GraphChoice selectedGraph = null;
    private final MenuPlottingModule menuPlottingModule = new MenuPlottingModule();
    private BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Spinner graph_selector = findViewById(R.id.graph_selector);
        ArrayAdapter<GraphChoice> array_metrics = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, GraphChoice.values());
        graph_selector.setAdapter(array_metrics);
        barChart = findViewById(R.id.barChart);
        graph_selector.setOnItemSelectedListener(this);
        setSupportActionBar(viewBinding.bottomAppBarLayout.bottomAppBar);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.graph_selector) {
            selectedGraph = GraphChoice.values()[position];
            Log.d("STATISTICS", "Selection: \"" + selectedGraph + "\" selected.");
        }

        if (selectedGraph != null) {
            menuPlottingModule.plotGraph(barChart, selectedGraph);
            Log.d("STATISTICS_PLOTTED", "Selection: " + selectedGraph);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        if (parent.getId() == R.id.graph_selector) {
            selectedGraph = null;
        }
        barChart.clear();
    }

    @Override
    protected View getRootView() {
        viewBinding = MenuStatisticsBinding.inflate(getLayoutInflater());
        return viewBinding.getRoot();
    }
}