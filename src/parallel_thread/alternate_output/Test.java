package parallel_thread.alternate_output;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    static int i=0;
    public static void main(String[] args) {
        File file=new File("C:\\Users\\wenqchen\\Desktop\\TRANSFORM_WH_L\\ecg-poc\\src\\performance_test\\TRANSFORM_WH_L\\sql");
        File[] fileList=file.listFiles();
        for (File subFile:fileList){
            String[] listArray=readFileByLine(subFile);
            for (String str:listArray){
                if (str.contains(";")){
                    i++;
                }
            }
        }
        System.out.println(i);
    }


    public static String[] readFileByLine(File file) {
        List<String> result = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(file);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                result.add(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toArray(new String[result.size()]);
    }
}
