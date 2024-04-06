package de.dennisguse.opentracks.ui.menuStatistics;

import com.github.mikephil.charting.formatter.ValueFormatter;
import java.util.Locale;

// This class extends the ValueFormatter class from the MPAndroidChart library.
public class IntegerValueFormatter extends ValueFormatter {

    // This method overrides the getFormattedValue method of the ValueFormatter class.
    @Override
    public String getFormattedValue(float value) {
        // It formats the float value as an integer string using the default locale.
        // The float value is first cast to an integer before formatting.
        return String.format(Locale.getDefault(), "%d", (int) value);
    }
}
