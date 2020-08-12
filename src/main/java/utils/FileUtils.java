package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {
    public static String readHTML(String fileName) throws IOException {
        String str="";
        File file=new File("src\\main\\resources\\"+fileName);
        try {
            FileInputStream in=new FileInputStream(file);
            // size 为字串的长度 ，这里一次性读完
            int size=in.available();
            byte[] buffer=new byte[size];
            in.read(buffer);
            in.close();
            str=new String(buffer,"UTF8");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            return null;
        }
        return str;

    }

    public static void writeHTML(String html,String fileName) throws IOException {
        File txt=new File("d:/out/"+fileName);
        if(!txt.exists()){
            txt.createNewFile();
        }
        byte bytes[]=new byte[512];
        bytes=html.getBytes();
        int b=bytes.length;   //是字节的长度，不是字符串的长度
        FileOutputStream fos=new FileOutputStream(txt);
        fos.write(bytes,0,b);
        fos.close();
    }
}
