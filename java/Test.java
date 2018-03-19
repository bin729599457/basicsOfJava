import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Test {
    public static final String FILE_PATH="/Users/binbin/test.txt";

    public static void main(String[] args) {

        List<String> strings=readTxtFileIntoStringArrList(FILE_PATH);
        Test t=new Test();
        t.handleArray(FILE_PATH);
        for(String str:strings){
            System.out.println(str);
        }
    }

    public void homeWorkAnswer(String filePath){
        handleArray(filePath);
    }

    public void handleArray(String filePath){

        List<String> list=readTxtFileIntoStringArrList(filePath);
        List<HashMap> planes=new ArrayList<>();
        for(String str:list){
            String [] temp=str.split("\\s+");
            HashMap plane=new HashMap();
            if(temp.length<=4){
                plane.put("planeId",temp[0]);
                plane.put("X",temp[1]);
                plane.put("Y",temp[2]);
                plane.put("Z",temp[3]);
                plane.put("offsetX","");
                plane.put("offsetY","");
                plane.put("offsetZ","");
                plane.put("isFalse",true);
                plane.put("curX","NA");
                plane.put("curY","NA");
                plane.put("curZ","NA");
            }else {
                plane.put("planeId",temp[0]);
                plane.put("X",temp[1]);
                plane.put("Y",temp[2]);
                plane.put("Z",temp[3]);
                plane.put("offsetX",temp[4]);
                plane.put("offsetY",temp[5]);
                plane.put("offsetZ",temp[6]);
                plane.put("isFalse",true);
                plane.put("curX","NA");
                plane.put("curY","NA");
                plane.put("curZ","NA");
            }
                planes.add(plane);
        }

    }

    public void judgeMethod(List<String> list){

        String plane="";
        for(int i=0;i<list.size();i++){
            if(i==0){
                //消息由字母和数字组成
                String pattern="^[A-Za-z0-9]+$";

            }
        }
    }

    public static List<String> readTxtFileIntoStringArrList(String filePath){


        List<String> list=new ArrayList<>();
        try {
        String encoding="UTF-8";
        File file=new File(filePath);

        if(file.isFile()&&file.exists()){
            InputStreamReader reader=new InputStreamReader(new FileInputStream(file),encoding);
            //读取文件内容
            BufferedReader bufferedReader=new BufferedReader(reader);
            String lineText=null;

            while ((lineText=bufferedReader.readLine())!=null){
                String pattern = "plane.+?";
                boolean isMatch = Pattern.matches(pattern, lineText);
                if(isMatch){
                    list.add(lineText.substring(0,lineText.length()-1));
                }
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

    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
