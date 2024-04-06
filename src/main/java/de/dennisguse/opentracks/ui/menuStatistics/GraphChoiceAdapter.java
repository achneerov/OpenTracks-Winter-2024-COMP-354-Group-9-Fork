package de.dennisguse.opentracks.ui.menuStatistics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

// This class is an ArrayAdapter for GraphChoice objects.
public class GraphChoiceAdapter extends ArrayAdapter<GraphChoice> {

    // Constructor for the GraphChoiceAdapter class.
    public GraphChoiceAdapter(Context context, GraphChoice[] choices) {
        super(context, 0, choices);
    }

    // This method is used to provide a view for the dropdown menu.
    @Override
    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        return createViewFromResource(position, convertView, parent);
    }

    // This method is used to provide a view for the adapter.
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        return createViewFromResource(position, convertView, parent);
    }

    // This method is used to create a view from the given resource.
    private View createViewFromResource(int position, View convertView, ViewGroup parent) {
        View view;
        // If convertView is null, inflate a new view.
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_item, parent, false);
        } else {
            // Otherwise, reuse the convertView.
            view = convertView;
        }

        // Get the GraphChoice item for the current position.
        GraphChoice choice = getItem(position);
        // Find the TextView in the view.
        TextView textView = view.findViewById(android.R.id.text1);
        // Set the text of the TextView to the string representation of the GraphChoice item.
        assert choice != null;
        textView.setText(choice.toString());
        // Set the drawable for the TextView.
        textView.setCompoundDrawablesWithIntrinsicBounds(choice.getDrawableRes(), 0, 0, 0);
        // Set the padding for the drawable.
        int padding = (int) (10 * getContext().getResources().getDisplayMetrics().density);
        textView.setCompoundDrawablePadding(padding);

        // Return the view.
        return view;
    }
}