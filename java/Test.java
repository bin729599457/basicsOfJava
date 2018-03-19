import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        List<String> strings=readTxtFileIntoStringArrList("/Users/binbin/test.txt");

        for(String str:strings){
            System.out.println(str);
        }
    }


    public void judgeMethod(List<Map> list){

    }

    public static List<String> readTxtFileIntoStringArrList(String filePath){


        List<String> list=new ArrayList<>();
        try {
        String encoding="GBK";
        File file=new File(filePath);

        if(file.isFile()&&file.exists()){
            InputStreamReader reader=new InputStreamReader(new FileInputStream(file),encoding);
            //读取文件内容
            BufferedReader bufferedReader=new BufferedReader(reader);
            String lineText=null;

            while ((lineText=bufferedReader.readLine())!=null){
                list.add(lineText);
            }
            bufferedReader.close();
            reader.close();
        }else {
            System.out.println("the file is no found");
        }

        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
