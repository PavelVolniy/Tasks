package exeption;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportNotesFromFileToList {
    //считывает строки из файла, формирует список заметок
    public static List<String> readNotesToList(String fileName) {
        fileName = fileName.trim();
        List<String> notes = new ArrayList();
        Scanner scanner = null;
        try {
            Path path = null;
            if (!fileName.isEmpty()) path = Paths.get(fileName);
            scanner = new Scanner(path);
            scanner.useDelimiter("\n");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.trim(); // Обрезаем лишние пробелы и табуляции
                if (!line.isEmpty()) notes.add(line); // если не пустая строка, добавляем в список заметок
            }
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            System.out.print("File not found- ");
            System.out.println(e.getLocalizedMessage());
        } finally {
            if (scanner != null) scanner.close();
            System.out.println("Process finished");
        }
        return notes;
    }

    //добавляет в файл заметки
    public static void writeCommentToNotes(String nodes) {
        if (nodes != null) nodes = nodes.trim(); //проверка пути на null
        else nodes = " ";
        Scanner scanner = null;
        FileWriter writer = null;
        try {
            writer = new FileWriter(nodes, true);
            scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.trim();
                if (!line.isEmpty()) {
                    writer.append("#<");
                    writer.write(line);
                    writer.append(">");
                    writer.append("\n");
                    writer.flush();
                }
            }
            writer.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
//            System.out.println("Not found file");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (scanner != null) scanner.close(); //закрываем сканнер
        }

    }
}
