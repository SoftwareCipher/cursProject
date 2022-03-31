import com.company.dataBase.DBConnect;
import com.company.readFile.ReadFile;

import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Path;

public class testWriteInformationDB {
    Path path = Path.of("product.txt");
    ReadFile readFile = new ReadFile(path);
    static DBConnect dbConnect = new DBConnect();

    @BeforeClass
    public static void createTestPool() {
        System.out.println("create pool");
        dbConnect.createPool();
    }

    @Test
    public void testWritePersonDB() {
        System.out.println("Save info Person");
        String[] arr = new String[4];
        arr[0] = "USER";
        arr[1] = "Berlizov_Ivan_Ivanovich";
        arr[2] = "ivan1234567@gmail.com";
        arr[3] = "0688552221";
        readFile.readPerson(arr, 0);
    }

    @Test
    public void testWriteDepartmentDB() {
        System.out.println("Save info Department");
        String[] arr = new String[3];
        arr[0] = "DEPARTMENT ";
        arr[1] = "1";
        arr[2] = "Department№1";
        readFile.readDepartment(arr, 0);
    }

    @Test
    public void testWritePackageDB() {
        System.out.println("Save info Department");
        String[] arr = new String[7];
        arr[0] = "PACKAGE";
        arr[1] = "Berlizov_Ivan_Ivanovich";
        arr[2] = "Department№1";
        arr[3] = "Department№3";
        arr[4] = "0999553331";
        arr[5] = "Dudnikova_Natalia_Ivanovna";
        arr[6] = "New";
        readFile.readDepartment(arr, 0);
    }

    @Test
    public void testreadFile(){
        Path path = Path.of("product.txt");
        ReadFile readFile = new ReadFile(path);
        readFile.readFile();
    }
}