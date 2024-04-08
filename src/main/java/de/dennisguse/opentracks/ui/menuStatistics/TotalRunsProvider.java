package de.dennisguse.opentracks.ui.menuStatistics;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import de.dennisguse.opentracks.data.ContentProviderUtils;
import de.dennisguse.opentracks.data.models.Track;


public class TotalRunsProvider {

    private static int runIdCtr = 0;
    private final Context context;

    public TotalRunsProvider(Context context) {
        this.context = context;
    }

    //Returns the number of tracks between the given start and end time.
    private int getTrackCount(Instant startTime, Instant endTime) {
        List<Track> tracks = new ContentProviderUtils(context).getTracks(startTime, endTime);
        return tracks.size();
    }

    // This method returns a list of RunViewModel objects representing the number of runs per hour.
    public List<RunViewModel> getRunsPerHour() {
        ArrayList<RunViewModel> runs = new ArrayList<>();
        int trackCount;
        for (int i = 0; i < 24; i++) {
            Instant startTime = Instant.now().truncatedTo(ChronoUnit.DAYS).plus(i, ChronoUnit.HOURS);
            Instant endTime = startTime.plus(1, ChronoUnit.HOURS);
            trackCount = getTrackCount(startTime, endTime);
            runs.add(new RunViewModel(runIdCtr++, trackCount, 0, 0, 0));
        }
        return runs;
    }

    // This method returns a list of RunViewModel objects representing the number of runs per weekday.
    public List<RunViewModel> getRunsPerWeekday() {
        ArrayList<RunViewModel> runs = new ArrayList<>();
        int trackCount;
        for (int i = 0; i < 7; i++) {
            Instant startTime = Instant.now().truncatedTo(ChronoUnit.DAYS).plus(i, ChronoUnit.DAYS);
            Instant endTime = startTime.plus(1, ChronoUnit.DAYS);
            trackCount = getTrackCount(startTime, endTime);
            runs.add(new RunViewModel(runIdCtr++, 0, trackCount, 0, 0));
        }
        return runs;
    }

    // This method returns a list of RunViewModel objects representing the number of runs per month.
    public List<RunViewModel> getRunsPerMonth() {
        ArrayList<RunViewModel> runs = new ArrayList<>();
        int trackCount;
        for (int i = 0; i < 12; i++) {
            ZonedDateTime startTime = ZonedDateTime.now().truncatedTo(ChronoUnit.DAYS).withDayOfMonth(1).withMonth(i+1);
            ZonedDateTime endTime = startTime.plus(1, ChronoUnit.MONTHS);
            trackCount = getTrackCount(startTime.toInstant(), endTime.toInstant());
            runs.add(new RunViewModel(runIdCtr++, 0, 0, trackCount, 0));
        }
        return runs;
    }

    // This method returns a list of RunViewModel objects representing the number of runs per season.
    public List<RunViewModel> getRunsPerSeason() {
        ArrayList<RunViewModel> runs = new ArrayList<>();
        int trackCount;
        for (int i = 2021; i <= 2024; i++) {
            ZonedDateTime startTime = ZonedDateTime.of(i, 1, 1, 0, 0, 0, 0, ZoneId.systemDefault());
            ZonedDateTime endTime = startTime.plus(1, ChronoUnit.YEARS);
            trackCount = getTrackCount(startTime.toInstant(), endTime.toInstant());
            runs.add(new RunViewModel(runIdCtr++, 0, 0, 0, trackCount));
        }
        return runs;
    }
}