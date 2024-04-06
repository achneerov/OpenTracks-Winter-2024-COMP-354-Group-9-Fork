package de.dennisguse.opentracks.ui.menuStatistics;

import java.util.ArrayList;
import java.util.List;

/**
 * A mock service to provide dummy data to test the bar chart menu statistics feature.
 */
public class TotalRunsProvider {
    private static int runIdCtr = 0;
    private static List<RunViewModel> getTotalRunsSample1()
    {
        ArrayList<RunViewModel> runs = new ArrayList<>();

        RunViewModel dummyRun1 = new RunViewModel(runIdCtr, 34, 67, 89, 17);
        runIdCtr++;
        RunViewModel dummyRun2 = new RunViewModel(runIdCtr, 45, 22, 7, 10);
        runIdCtr++;

        runs.add(dummyRun1);
        runs.add(dummyRun2);
        return runs;
    }
    private static List<RunViewModel> getTotalRunsSample2()
    {
        ArrayList<RunViewModel> runs = new ArrayList<>();

        RunViewModel dummyRun1 = new RunViewModel(runIdCtr, 22, 12, 66, 330);
        runIdCtr++;
        RunViewModel dummyRun2 = new RunViewModel(runIdCtr, 23, 32, 16, 290);
        runIdCtr++;
        RunViewModel dummyRun3 = new RunViewModel(runIdCtr, 11, 34, 23, 110);
        runIdCtr++;
        RunViewModel dummyRun4 = new RunViewModel(runIdCtr, 25, 21, 37, 160);
        runIdCtr++;
        RunViewModel dummyRun5 = new RunViewModel(runIdCtr, 13, 23, 31, 195);
        runIdCtr++;

        runs.add(dummyRun1);
        runs.add(dummyRun2);
        runs.add(dummyRun3);
        runs.add(dummyRun4);
        runs.add(dummyRun5);
        return runs;
    }
    private static List<RunViewModel> getTotalRunsSample3()
    {
        ArrayList<RunViewModel> runs = new ArrayList<>();

        RunViewModel dummyRun1 = new RunViewModel(runIdCtr, 44, 53, 21, 600);
        runIdCtr++;
        RunViewModel dummyRun2 = new RunViewModel(runIdCtr, 35, 67, 23, 355);
        runIdCtr++;
        RunViewModel dummyRun3 = new RunViewModel(runIdCtr, 44, 34, 55, 175);
        runIdCtr++;
        RunViewModel dummyRun4 = new RunViewModel(runIdCtr, 23, 31, 25, 600);
        runIdCtr++;
        RunViewModel dummyRun5 = new RunViewModel(runIdCtr, 3, 49, 55, 750);
        runIdCtr++;
        RunViewModel dummyRun6 = new RunViewModel(runIdCtr, 15, 42, 41, 300);
        runIdCtr++;
        RunViewModel dummyRun7 = new RunViewModel(runIdCtr, 24, 23, 25, 900);
        runIdCtr++;
        RunViewModel dummyRun8 = new RunViewModel(runIdCtr, 21, 93, 67, 600);
        runIdCtr++;

        runs.add(dummyRun1);
        runs.add(dummyRun2);
        runs.add(dummyRun3);
        runs.add(dummyRun4);
        runs.add(dummyRun5);
        runs.add(dummyRun6);
        runs.add(dummyRun7);
        runs.add(dummyRun8);
        return runs;
    }
    private static List<RunViewModel> getTotalRunsSample4()
    {
        ArrayList<RunViewModel> runs = new ArrayList<>();

        RunViewModel dummyRun1 = new RunViewModel(runIdCtr, 23, 21, 36, 714);
        runIdCtr++;
        RunViewModel dummyRun2 = new RunViewModel(runIdCtr, 3, 33, 45, 497);
        runIdCtr++;
        RunViewModel dummyRun3 = new RunViewModel(runIdCtr, 29, 24, 56, 500);
        runIdCtr++;
        RunViewModel dummyRun4 = new RunViewModel(runIdCtr, 14, 32, 56, 655);
        runIdCtr++;
        RunViewModel dummyRun5 = new RunViewModel(runIdCtr, 13, 39, 73, 230);
        runIdCtr++;
        RunViewModel dummyRun6 = new RunViewModel(runIdCtr, 19, 35, 52, 682);
        runIdCtr++;
        RunViewModel dummyRun7 = new RunViewModel(runIdCtr, 7, 29, 28, 410);
        runIdCtr++;
        RunViewModel dummyRun8 = new RunViewModel(runIdCtr, 2, 41, 39, 321);
        runIdCtr++;
        RunViewModel dummyRun9 = new RunViewModel(runIdCtr, 17, 28, 45, 457);
        runIdCtr++;
        RunViewModel dummyRun10 = new RunViewModel(runIdCtr, 20, 36, 58, 333);
        runIdCtr++;

        runs.add(dummyRun1);
        runs.add(dummyRun2);
        runs.add(dummyRun3);
        runs.add(dummyRun4);
        runs.add(dummyRun5);
        runs.add(dummyRun6);
        runs.add(dummyRun7);
        runs.add(dummyRun8);
        runs.add(dummyRun9);
        runs.add(dummyRun10);
        return runs;
    }
    private static List<RunViewModel> getTotalRunsSample5()
    {
        ArrayList<RunViewModel> runs = new ArrayList<>();

        RunViewModel dummyRun1 = new RunViewModel(runIdCtr, 12, 35, 65, 90);
        runIdCtr++;
        RunViewModel dummyRun2 = new RunViewModel(runIdCtr, 14, 26, 67, 412);
        runIdCtr++;
        RunViewModel dummyRun3 = new RunViewModel(runIdCtr, 11, 23, 55, 385);
        runIdCtr++;
        RunViewModel dummyRun4 = new RunViewModel(runIdCtr, 13, 39, 38, 100);
        runIdCtr++;
        RunViewModel dummyRun5 = new RunViewModel(runIdCtr, 13, 43, 51, 387);
        runIdCtr++;
        RunViewModel dummyRun6 = new RunViewModel(runIdCtr, 12, 12, 48, 243);
        runIdCtr++;
        RunViewModel dummyRun7 = new RunViewModel(runIdCtr, 7, 32, 61, 321);
        runIdCtr++;
        RunViewModel dummyRun8 = new RunViewModel(runIdCtr, 6, 46, 56, 241);
        runIdCtr++;
        RunViewModel dummyRun9 = new RunViewModel(runIdCtr, 9, 77, 43, 362);
        runIdCtr++;
        RunViewModel dummyRun10 = new RunViewModel(runIdCtr, 3, 55, 23, 430);
        runIdCtr++;
        RunViewModel dummyRun11 = new RunViewModel(runIdCtr, 15, 18, 53, 264);
        runIdCtr++;
        RunViewModel dummyRun12 = new RunViewModel(runIdCtr, 16, 29, 78, 353);
        runIdCtr++;
        RunViewModel dummyRun13 = new RunViewModel(runIdCtr, 20, 37, 98, 222);
        runIdCtr++;
        RunViewModel dummyRun14 = new RunViewModel(runIdCtr, 18, 91, 52, 103);
        runIdCtr++;

        runs.add(dummyRun1);
        runs.add(dummyRun2);
        runs.add(dummyRun3);
        runs.add(dummyRun4);
        runs.add(dummyRun5);
        runs.add(dummyRun6);
        runs.add(dummyRun7);
        runs.add(dummyRun8);
        runs.add(dummyRun9);
        runs.add(dummyRun10);
        runs.add(dummyRun11);
        runs.add(dummyRun12);
        runs.add(dummyRun13);
        runs.add(dummyRun14);
        return runs;
    }

    public static List<RunViewModel> getAllTotalRuns()
    {
        int randomNum = (int) (Math.random()*10)+1;

        if(randomNum == 1 || randomNum == 2)
        {
            return getTotalRunsSample1();
        }
        else if(randomNum == 3 || randomNum == 4)
        {
            return getTotalRunsSample2();
        }
        else if(randomNum == 5 || randomNum == 6)
        {
            return getTotalRunsSample3();
        }
        else if(randomNum == 7 || randomNum == 8)
        {
            return getTotalRunsSample4();
        }
        else
        {
            return getTotalRunsSample5();
        }
    }
}
