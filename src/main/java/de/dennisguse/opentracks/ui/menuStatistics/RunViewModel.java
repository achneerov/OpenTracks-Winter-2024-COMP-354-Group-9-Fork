package de.dennisguse.opentracks.ui.menuStatistics;

// This class is a ViewModel for a Run.
public class RunViewModel {
    // These are the private fields for the RunViewModel.
    private int id;
    private final int dayRuns;
    private final int weekRuns;
    private final int monthRuns;
    private final int seasonRuns;

    // This is the constructor for the RunViewModel.
    public RunViewModel(int id, int dayRuns, int weekRuns, int monthRuns, int seasonRuns) {
        this.id = id;
        this.dayRuns = dayRuns;
        this.weekRuns = weekRuns;
        this.monthRuns = monthRuns;
        this.seasonRuns = seasonRuns;
    }

    // This method returns the id of the RunViewModel.
    public int getId() {
        return id;
    }

    // This method sets the id of the RunViewModel.
    public void setId(int id) {
        this.id = id;
    }

    // This method returns the number of runs per day.
    public int getDayRuns() {
        return dayRuns;
    }

    // This method returns the number of runs per week.
    public int getWeekRuns() {
        return weekRuns;
    }

    // This method returns the number of runs per month.
    public int getMonthRuns() {
        return monthRuns;
    }

    // This method returns the number of runs per season.
    public int getSeasonRuns() {
        return seasonRuns;
    }
}