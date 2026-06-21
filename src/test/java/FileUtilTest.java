import org.junit.jupiter.api.Test;
import student.FileUtil;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileUtilTest {
    @Test
    void testReadFileToList() {
        String path = "resources/readFileUtilTest.csv";
        List<String> list = FileUtil.readFileToList(path);
        assertEquals("A,B,C,D,E", list.get(0));
        assertEquals("1B,2E,3G,4Y,67", list.get(1));
    }

    @Test
    void testWriteFile() {
        String path = "resources/writeFileUtilTest.csv";
        String[] s = {"1,2,3,4,5","AA,BB,CC,DD,EE","1B,2E,3G,4Y,67"};
        List<String> list = new ArrayList<>(List.of(s));
        FileUtil.writeFile(path, list);
        assertEquals("AA,BB,CC,DD,EE", FileUtil.readFileToList(path).get(0));
        assertEquals("1B,2E,3G,4Y,67", FileUtil.readFileToList(path).get(1));

    }
}
