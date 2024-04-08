package de.dennisguse.opentracks.ui.menuStatistics;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.BarChart;
import de.dennisguse.opentracks.AbstractActivity;
import de.dennisguse.opentracks.R;
import de.dennisguse.opentracks.databinding.MenuStatisticsBinding;

// This class extends AbstractActivity and implements AdapterView.OnItemSelectedListener.
public class MenuStatisticsActivity extends AbstractActivity implements AdapterView.OnItemSelectedListener {
    // These are the private fields for the activity.
    private MenuStatisticsBinding viewBinding;
    private GraphChoice selectedGraph = null;
    private final MenuPlottingModule menuPlottingModule = new MenuPlottingModule(this);
    private BarChart barChart;

    // This method is called when the activity is created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // The graph selector spinner is found and a new GraphChoiceAdapter is set to it.
        Spinner graph_selector = findViewById(R.id.graph_selector);
        GraphChoiceAdapter array_metrics = new GraphChoiceAdapter(this, GraphChoice.values());
        graph_selector.setAdapter(array_metrics);
        // The bar chart is found.
        barChart = findViewById(R.id.barChart);
        // The activity is set as the item selected listener for the graph selector spinner.
        graph_selector.setOnItemSelectedListener(this);
        // The bottom app bar is set as the support action bar.
        setSupportActionBar(viewBinding.bottomAppBarLayout.bottomAppBar);
    }

    // This method is called when an item is selected in the AdapterView.
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // If the graph selector spinner is the parent, the selected graph is set.
        if (parent.getId() == R.id.graph_selector) {
            selectedGraph = GraphChoice.values()[position];
        }

        // If a graph is selected, it is plotted on the bar chart.
        if (selectedGraph != null) {
            menuPlottingModule.plotGraph(barChart, selectedGraph);
        }
    }

    // This method is called when nothing is selected in the AdapterView.
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // If the graph selector spinner is the parent, the selected graph is set to null.
        if (parent.getId() == R.id.graph_selector) {
            selectedGraph = null;
        }
        // The bar chart is cleared.
        barChart.clear();
    }

    // This method returns the root view for the activity.
    @Override
    protected View getRootView() {
        // The view binding is inflated.
        viewBinding = MenuStatisticsBinding.inflate(getLayoutInflater());
        // The root view from the view binding is returned.
        return viewBinding.getRoot();
    }
}