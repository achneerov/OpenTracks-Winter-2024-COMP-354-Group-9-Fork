package de.dennisguse.opentracks.ui.menuStatistics;

/**
 * A view model representing a run for visualizing bar chart menu statistics.
 */
public class RunViewModel {
    private int id;
    private final int dayRuns;
    private final int weekRuns;
    private final int monthRuns;
    private final int seasonRuns;

    public RunViewModel(int id, int dayRuns, int weekRuns, int monthRuns, int seasonRuns) {
        this.id = id;
        this.dayRuns = dayRuns;
        this.weekRuns = weekRuns;
        this.monthRuns = monthRuns;
        this.seasonRuns = seasonRuns;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDayRuns() {
        return dayRuns;
    }

    public int getWeekRuns() {
        return weekRuns;
    }

    public int getMonthRuns() {
        return monthRuns;
    }

    public int getSeasonRuns() {
        return seasonRuns;
    }
}
