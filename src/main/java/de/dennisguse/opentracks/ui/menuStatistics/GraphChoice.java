package de.dennisguse.opentracks.ui.menuStatistics;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

import de.dennisguse.opentracks.R;

// This is an enum class named GraphChoice.
public enum GraphChoice {
    // These are the enum constants and each has a display name and a drawable resource associated with it.
    DAY("Day", R.drawable.baseline_today_24),
    WEEK("Week", R.drawable.baseline_calendar_view_week_24),
    MONTH("Month", R.drawable.baseline_calendar_month_24),
    SEASON("Season", R.drawable.baseline_season_24);

    // This is a private final field for the display name of the enum constant.
    private final String displayName;
    // This is a private final field for the drawable resource of the enum constant.
    @DrawableRes
    private final int drawableRes;

    // This is the constructor for the enum constants.
    GraphChoice(String displayName, @DrawableRes int drawableRes) {
        this.displayName = displayName;
        this.drawableRes = drawableRes;
    }

    // This method overrides the toString method and returns the display name of the enum constant.
    @NonNull
    @Override
    public String toString() {
        return displayName;
    }

    // This method returns the drawable resource of the enum constant.
    @DrawableRes
    public int getDrawableRes() {
        return drawableRes;
    }
}