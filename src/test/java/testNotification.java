import com.company.dataBase.DBConnect;
import com.company.dataBase.SaveDate;
import com.company.dataBase.SelectDB;
import com.company.dataBase.UpdateTables;
import com.company.entities.Notification;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class testNotification {

    static DBConnect dbConnect = new DBConnect();
    UpdateTables updateTables = new UpdateTables();
    SelectDB selectDB = new SelectDB();
    SaveDate saveDate = new SaveDate();
    Notification notification = new Notification("testMessage", "new");

    @BeforeClass
    public static void createTestPool() {
        System.out.println("create pool");
        dbConnect.createPool();
    }

    @Test
    public void updateNotificationDataDatabase(){
        int id = 1;
        saveDate.saveNotification(notification);
        System.out.println("Start update notification");
        updateTables.updateNotification(id, "updateMessage");
        System.out.println("finish update notification");
    }

    @Test
    public void saveNotificationDataDatabase() {
        System.out.println("Start save notification");
        saveDate.saveNotification(notification);
        System.out.println("finish save notification");
        assertNotNull(selectDB.statusNotification(1));
    }

}

