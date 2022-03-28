package com.company.businessLogic;

import com.company.dataBase.SelectDB;
import com.company.dataBase.UpdateTables;
import com.company.readFile.WriteFile;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Logics extends TimerTask {
    SelectDB selectDB = new SelectDB();
    UpdateTables updateTables = new UpdateTables();

    @Override
    public void run() {
        int numberCol = selectDB.columNumberPack();
        for (int i = 1; i <= numberCol; i++) {
            if (!selectDB.statusNotification(i).equals("Received")) {
                LocalTime timeGoods = LocalTime.from(selectDB.columTime(i));
                LocalTime newTime = timeGoods.plusHours(3).plusSeconds(5);
                comparisonTime(LocalTime.now(),newTime,i);
            }
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void comparisonTime(LocalTime now, LocalTime newTimePlusFive, int item){
        if (now.isBefore(newTimePlusFive)) {
            if (randValue()) {
                updateTables.updateNotification(item, "Received");
                updateTables.updateTimeChange(item, LocalDateTime.now());
            } else {
                updateTables.updateNotification(item, "Overdue");
                updateTables.updateTimeChange(item, LocalDateTime.now());
            }
        } else {
            updateTables.updateNotification(item, "Overdue");
            updateTables.updateTimeChange(item, LocalDateTime.now());
        }
        updateTables.updatePackStatus(item);
    }

    private boolean randValue(){
        Random random = new Random();
        boolean value = random.nextInt(5) == 0;
        WriteFile.writeInfo(value + "\n");
        WriteFile.writeInfo(LocalTime.now() + "\n");
        return value;
    }
}
