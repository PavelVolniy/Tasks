import exeption.ImportNotesFromFileToList;
import linkedlist.Installer;
import linkedlist.Subsystem;
import middleearth.battle.Battle;
import streams.StreamWorkComparison;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

//        Battle battle = new Battle();

//        Installer F = new Installer("F", 0, new Subsystem[]{});
//        Installer D = new Installer("D", 0, new Subsystem[]{});
//        Installer C = new Installer("C", 0, new Subsystem[]{D});
//        Installer C1 = new Installer("C", 1, new Subsystem[]{D});
//        Installer B = new Installer("B", 0, new Subsystem[]{C});
//        Installer E = new Installer("E", 0, new Subsystem[]{B, F});
//        Installer A = new Installer("A", 0, new Subsystem[]{B, C, D, E, C1});

//        Installer F =new Installer("F", 0, new Subsystem[]{});
//        Installer E1 =new Installer("E", 1, new Subsystem[]{});
//        Installer E2 =new Installer("E", 2, new Subsystem[]{});
//        Installer E3 =new Installer("E", 3, new Subsystem[]{E2});
//        Installer D =new Installer("D", 0, new Subsystem[]{E1});
//        Installer C =new Installer("C", 0, new Subsystem[]{E3});
//        Installer B =new Installer("B", 0, new Subsystem[]{E2, F});
//        Installer A =new Installer("A", 0, new Subsystem[]{B, C, D});

//        Queue<Subsystem> queue = A.setUpPlan();
//        System.out.println("=============================");
//        Installer.setUp(queue);

        String path  = "C:\\Users\\user\\Desktop\\str.txt";

//        System.out.println("=============================");
//        List<String> list = ImportNotesFromFileToList.readNotesToList(path);
//        for (String item: list) System.out.println(item);
//        ImportNotesFromFileToList.writeCommentToNotes(path);
//        System.out.println("=============================");
//        List<String> list = ImportNotesFromFileToList.readNotesToList(path);
//        for (String item: list) System.out.println(item);
//        System.out.println(StreamWorkComparison.checkBufferedReaderWork(path));
//        System.out.println(StreamWorkComparison.checkFileReaderWork(path));
//        System.out.println(StreamWorkComparison.checkScannerWork(path));
        System.out.println(StreamWorkComparison.compareReading(path));
    }
}