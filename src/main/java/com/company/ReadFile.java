package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

public class ReadFile {
    private Path path;
    WriteToFile writeToFile = new WriteToFile();

    public ReadFile(Path path) {
        this.path = path;
    }

    public List<String> readFile() {
        List<String> list;
        SaveDate saveDate = new SaveDate();
        while (true) {
            try {
                list = Files.readAllLines(path);
                String[] arr;
                for (String l : list) {
                    arr = l.split(" ");
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i].equals("USER")) {
                            if(arr.length == 4){
                                Person person = new Person(arr[i + 1], arr[i + 2], Integer.parseInt(arr[i + 3]));
                                saveDate.savePerson(person);
                            }
                        } else if (arr[i].equals("DEPARTMENT")) {
                            if(arr.length == 3){
                                Department department = new Department(Integer.parseInt(arr[i + 1]), arr[i + 2]);
                                saveDate.saveDepartment(department);
                            }
                        } else if (arr[i].equals("PACKAGE")) {
                            if(arr.length == 8){
                                Package packege = new Package(
                                        Long.parseLong(arr[i + 1]),
                                        arr[i + 2],
                                        arr[i + 3],
                                        arr[i + 4],
                                        Integer.parseInt(arr[i + 5]),
                                        arr[i + 6],
                                        arr[i + 7],
                                        LocalDateTime.now(),
                                        LocalDateTime.now()
                                );
                                saveDate.savePackage(packege);
                            }
                        } else if(arr[i].equals("NOTIFICATION")){
                            if(arr.length == 3){
                                Notification notification = new Notification(arr[i + 1], arr[i + 2]);
                                saveDate.saveNotification(notification);
                            }
                        }
                    }
                }
                break;
            } catch (IOException e) {
                writeToFile.writeInfo("Файл отсутствует!\n");
            }
        }
        return list;
    }
}






