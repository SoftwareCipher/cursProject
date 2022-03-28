package com.company.readFile;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static void writeInfo(String text) {
        try (FileWriter writer = new FileWriter("inform.txt", true)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println("No such file - inform.txt");
        }
    }

    public static void writeInfoTable(String text) {
        try (FileWriter writer = new FileWriter("infoFromTables.txt", true)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println("No such file - infoFromTables.txt");
        }
    }
}
