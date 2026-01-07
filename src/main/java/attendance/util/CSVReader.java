package attendance.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
    public static List<List<String>> readCSV() {

        File file = new File("src/main/resources/attendances.csv");
        String absolutePath = file.getAbsolutePath();

        List<List<String>> csvList = new ArrayList<>();
        File csv = new File(absolutePath);
        BufferedReader br = null;
        String line = "'";

        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {
                List<String> aLine;
                String[] lineArr = line.split(",");
                aLine = Arrays.asList(lineArr);
                csvList.add(aLine);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
            }
        }
        return csvList;
    }
}
