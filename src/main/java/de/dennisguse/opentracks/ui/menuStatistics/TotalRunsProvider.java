package de.dennisguse.opentracks.ui.menuStatistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// This class provides total runs for different time periods.
public class TotalRunsProvider {

    // These are the private static fields for the TotalRunsProvider.
    private static int runIdCtr = 0;
    private static final Random random = new Random();

    // This method returns a list of RunViewModel objects representing the number of runs per hour.
    public static List<RunViewModel> getRunsPerHour() {
        ArrayList<RunViewModel> runs = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            runs.add(new RunViewModel(runIdCtr++, 10 + random.nextInt(25), 0, 0, 0));
        }
        return runs;
    }

    // This method returns a list of RunViewModel objects representing the number of runs per weekday.
    public static List<RunViewModel> getRunsPerWeekday() {
        ArrayList<RunViewModel> runs = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            runs.add(new RunViewModel(runIdCtr++, 0, 10 + random.nextInt(50), 0, 0));
        }
        return runs;
    }

    // This method returns a list of RunViewModel objects representing the number of runs per month.
    public static List<RunViewModel> getRunsPerMonth() {
        ArrayList<RunViewModel> runs = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            runs.add(new RunViewModel(runIdCtr++, 0, 0, 10 + random.nextInt(75), 0));
        }
        return runs;
    }

    // This method returns a list of RunViewModel objects representing the number of runs per season.
    public static List<RunViewModel> getRunsPerSeason() {
        ArrayList<RunViewModel> runs = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            runs.add(new RunViewModel(runIdCtr++, 0, 0, 0, 10 + random.nextInt(100)));
        }
        return runs;
    }
}