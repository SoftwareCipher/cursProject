package com.company.readFile;

import com.company.dataBase.SaveDate;
import com.company.entities.Department;
import com.company.entities.Notification;
import com.company.entities.Package;
import com.company.entities.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

public class ReadFile {
    private Path path;
    private SaveDate saveDate = new SaveDate();

    public ReadFile(Path path) {
        this.path = path;
    }

    public List<String> readFile() {
        List<String> list;
        while (true) {
            try {
                list = Files.readAllLines(path);
                String[] arr;
                for (String l : list) {
                    arr = l.split(" ");
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i].equals("USER")) {
                            readPerson(arr, i);
                        } else if (arr[i].equals("DEPARTMENT")) {
                            readDepartment(arr, i);
                        } else if (arr[i].equals("PACKAGE")) {
                            readPackage(arr, i);
                        }
                    }
                }
                break;
            } catch (IOException e) {
                WriteFile.writeInfo("File missing !\n");
            }
        }
        return list;
    }

    private void readPerson(String[] arr, int i){
        if(arr.length == 4){
            Person person = new Person(
                    arr[i + 1],
                    arr[i + 2],
                    Integer.parseInt(arr[i + 3]));
            saveDate.savePerson(person);
        }
    }

    private void readDepartment(String[] arr, int i){
        if(arr.length == 3){
            Department department = new Department(
                    Integer.parseInt(arr[i + 1]), arr[i + 2]);
            saveDate.saveDepartment(department);
        }
    }

    private void readPackage(String[] arr, int i){
        if(arr.length == 7){
            Package packege = new Package(
                    arr[i + 1],
                    arr[i + 2],
                    arr[i + 3],
                    Integer.parseInt(arr[i + 4]),
                    arr[i + 5],
                    arr[i + 6],
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
            saveDate.savePackage(packege);
            Notification notification = new Notification("Expect", "new");
            saveDate.saveNotification(notification);
        }
    }
}






