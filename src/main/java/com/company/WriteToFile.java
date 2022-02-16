package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    public void writeInfo(String text) {
        try (FileWriter writer = new FileWriter("inform.txt", true)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void writeInfoTable(String text) {
        try (FileWriter writer = new FileWriter("infoFromTables.txt", true)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
