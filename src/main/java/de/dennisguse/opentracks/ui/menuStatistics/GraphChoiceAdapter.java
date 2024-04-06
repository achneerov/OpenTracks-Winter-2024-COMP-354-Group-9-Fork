package de.dennisguse.opentracks.ui.menuStatistics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class GraphChoiceAdapter extends ArrayAdapter<GraphChoice> {
    public GraphChoiceAdapter(Context context, GraphChoice[] choices) {
        super(context, 0, choices);
    }

    @Override
    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        return createViewFromResource(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        return createViewFromResource(position, convertView, parent);
    }

    private View createViewFromResource(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_item, parent, false);
        } else {
            view = convertView;
        }

        GraphChoice choice = getItem(position);
        TextView textView = view.findViewById(android.R.id.text1);
        assert choice != null;
        textView.setText(choice.toString());
        textView.setCompoundDrawablesWithIntrinsicBounds(choice.getDrawableRes(), 0, 0, 0);
        int padding = (int) (16 * getContext().getResources().getDisplayMetrics().density);
        textView.setCompoundDrawablePadding(padding);
        return view;
    }
}
