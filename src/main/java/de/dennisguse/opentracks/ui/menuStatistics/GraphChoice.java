package de.dennisguse.opentracks.ui.menuStatistics;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

import de.dennisguse.opentracks.R;

/**
 * An enum of all graph choices in the dropdown menu statistics feature.
 */
public enum GraphChoice {
    DAY("Day", R.drawable.baseline_today_24),
    WEEK("Week", R.drawable.baseline_calendar_view_week_24),
    MONTH("Month", R.drawable.baseline_calendar_month_24),
    SEASON("Season", R.drawable.baseline_season_24);

    private final String displayName;
    @DrawableRes
    private final int drawableRes;

    GraphChoice(String displayName, @DrawableRes int drawableRes) {
        this.displayName = displayName;
        this.drawableRes = drawableRes;
    }

    @NonNull
    @Override
    public String toString() {
        return displayName;
    }

    @DrawableRes
    public int getDrawableRes() {
        return drawableRes;
    }
}
