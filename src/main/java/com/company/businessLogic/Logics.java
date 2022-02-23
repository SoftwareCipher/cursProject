package com.company.businessLogic;

import com.company.dataBase.SelectDB;
import com.company.readFile.Logger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Logics extends TimerTask {
    SelectDB selectDB = new SelectDB();

    private boolean randBoolean() {
        Random rand = new Random();
        boolean val = rand.nextInt(5) == 0;
        Logger.writeInfo(val + "\n");
        Logger.writeInfo(String.valueOf(LocalTime.now()) + "\n");
        System.out.println(val);
        return val;
    }

    @Override
    public void run() {
        int numberCol = selectDB.columNumberPack();
        for (int i = 1; i <= numberCol; i++) {
            if (!selectDB.statusNotification(i).equals("Получена")) {
                LocalTime timeGoods = LocalTime.from(selectDB.columTime(i));
                LocalTime t = LocalTime.now();
                LocalTime newTime = timeGoods.plusHours(2).plusSeconds(5);
                comparisonTime(t,newTime,i);
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
            if (randBoolean()) {
                selectDB.updateNotification(item, "Получена");
                selectDB.updateTimeChange(item, LocalDateTime.now());
            } else {
                selectDB.updateNotification(item, "Просрочена");
                selectDB.updateTimeChange(item, LocalDateTime.now());
            }
        } else {
            selectDB.updateNotification(item, "Просрочена");
            selectDB.updateTimeChange(item, LocalDateTime.now());
        }
        selectDB.updatePackStatus(item);
    }
}
