package de.dennisguse.opentracks.ui.menuStatistics;

import com.github.mikephil.charting.formatter.ValueFormatter;
import java.util.Locale;

public class IntegerValueFormatter extends ValueFormatter {
    @Override
    public String getFormattedValue(float value) {
        return String.format(Locale.getDefault(), "%d", (int) value);
    }
}