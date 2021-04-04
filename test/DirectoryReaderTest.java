

import org.junit.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DirectoryReaderTest {

    @Test
    public void testFilesCorrect() {
        DirectoryReader reader = new DirectoryReader("./directory2/outFile.txt", "./directory");
        String result = "File1.txt\n" + "File2.txt\n";
        Assert.assertEquals(result, reader.list());

        try (BufferedReader br = new BufferedReader(new FileReader("./directory2/outFile.txt"))) {
            String line;
            String res = new String();
            while ((line = br.readLine()) != null) {
                res += line;
            }
        } catch (IOException e) {
            System.out.println("File read error.\n" + e.getMessage());
        }
    }

    @Test(expected = RuntimeException.class)
    public void testNonExistentDirectory() {
        String wrongPath = "./nonExistent";
        new DirectoryReader("writeFile", wrongPath);
    }
    /*
    @Test//(expected = RuntimeException.class)
    public void testDirectoryIsEmpty() {
        String wrongPath = "./emptyDirectory";
        DirectoryReader reader = new DirectoryReader("./directory2/outFile.txt", wrongPath);
        reader.list();
        try (BufferedReader br = new BufferedReader(new FileReader("./directory2/outFile.txt"))) {
            String line;
            String res = new String();
            while ((line = br.readLine()) != null) {
                res += line;
            }
        } catch (IOException e) {
            System.out.println("File read error.\n" + e.getMessage());
        }
        //System.out.println(reader.list());
    }



    @Test(expected = RuntimeException.class)
    public void testNonExistentWriteFile() {
        String dirPath = "./emptydirectory";
        new DirectoryReader("nonExistentFile", dirPath);
    }
*/
}