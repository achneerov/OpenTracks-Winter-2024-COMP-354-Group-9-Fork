package de.dennisguse.opentracks.ui.menuStatistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TotalRunsProvider {

    private static int runIdCtr = 0;
    private static final Random random = new Random();

    public static List<RunViewModel> getRunsPerHour() {
        ArrayList<RunViewModel> runs = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            runs.add(new RunViewModel(runIdCtr++, 10 + random.nextInt(25), 0, 0, 0));
        }
        return runs;
    }

    public static List<RunViewModel> getRunsPerWeekday() {
        ArrayList<RunViewModel> runs = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            runs.add(new RunViewModel(runIdCtr++, 0, 10 + random.nextInt(50), 0, 0));
        }
        return runs;
    }

    public static List<RunViewModel> getRunsPerMonth() {
        ArrayList<RunViewModel> runs = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            runs.add(new RunViewModel(runIdCtr++, 0, 0, 10 + random.nextInt(75), 0));
        }
        return runs;
    }

    public static List<RunViewModel> getRunsPerSeason() {
        ArrayList<RunViewModel> runs = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            runs.add(new RunViewModel(runIdCtr++, 0, 0, 0, 10 + random.nextInt(100)));
        }
        return runs;
    }
}