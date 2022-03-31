import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class testWriteToFile {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testWriteDataToFile() throws IOException {
        File file = new File("inform.txt");
        assertTrue(file.exists());
        FileWriter writer = new FileWriter(file, true);
        writer.write("Test text!!!!");
        writer.close();
    }

    @Test
    public void testWriteDataBaseToFile() throws IOException {
        File file = new File("infoFromTables.txt");
        assertTrue(file.exists());
        FileWriter writer = new FileWriter(file, true);
        writer.write("Test date!!!!");
        writer.close();
    }
}
