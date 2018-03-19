import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Test {
    public static final String FILE_PATH="/Users/binbin/test.txt";

    public static void main(String[] args) {

        List<String> strings=readTxtFileIntoStringArrList(FILE_PATH);
        Test t=new Test();
        t.handleArray(FILE_PATH,2);
    }


    public void handleArray(String filePath,int index){

        List<String> list=readTxtFileIntoStringArrList(filePath);
        List<HashMap<String,Object>> planes=new ArrayList<>();
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
                plane.put("offsetX","0");
                plane.put("offsetY","0");
                plane.put("offsetZ","0");
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

        List<HashMap<String, Object>> planeMap=judgeMethod(planes);

        if(index>planes.size()){
            System.out.println("Cannot find 100");

        }else {
            Boolean isFalse= (Boolean) planes.get(index).get("isFalse");
            if(isFalse){
                System.out.println("Error:"+index);
            }else {
                System.out.println(planeMap.get(index+1).get("planeId").toString()+index+planeMap.get(index+1).get("curX")+planeMap.get(index+1).get("curY")+planeMap.get(index+1).get("curZ"));
            }
        }

    }

    public List<HashMap<String, Object>> judgeMethod(List<HashMap<String,Object>> planes){

        for(int i=0;i<planes.size();i++){
            //第一行没有offset
            if(i==0){
                planes.get(i).put("curX",planes.get(i).get("X"));
                planes.get(i).put("curY",planes.get(i).get("Y"));
                planes.get(i).put("curZ",planes.get(i).get("Z"));
                planes.get(i).put("isFalse",false);
            }else {
                Boolean isFalse= (Boolean) planes.get(i-1).get("isFalse");
                if(isFalse){
                    break;
                }
                //X Y Z与前一条坐标相等
                if(planes.get(i-1).get("curX").toString().equals(planes.get(i).get("X"))&&
                        planes.get(i-1).get("curY").toString().equals(planes.get(i).get("Y"))&&
                        planes.get(i-1).get("curZ").toString().equals(planes.get(i).get("Z"))){
                    int numX=Integer.parseInt(planes.get(i).get("X").toString())+Integer.parseInt(planes.get(i).get("offsetX").toString());
                    int numY=Integer.parseInt(planes.get(i).get("Y").toString())+Integer.parseInt(planes.get(i).get("offsetY").toString());
                    int numZ=Integer.parseInt(planes.get(i).get("Z").toString())+Integer.parseInt(planes.get(i).get("offsetZ").toString());
                    planes.get(i).put("curX",numX+"");
                    planes.get(i).put("curY",numY+"");
                    planes.get(i).put("curZ",numZ+"");
                    planes.get(i).put("isFalse",false);
                }

            }
        }
        return planes;
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
