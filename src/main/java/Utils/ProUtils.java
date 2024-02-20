/**
 * @Author 江洁
 * @Date 2024 01 29 14 29
 **/
package Utils;

import java.io.*;
import java.util.Properties;

public class ProUtils {
    public Properties pro;
    public ProUtils(String FilePath){
        pro = ReadProperties(FilePath);
    }

    private Properties ReadProperties(String FilePath){
        Properties properties =new Properties();
        try {
            // 设置"UTF-8" 可解决读取properties文件中文乱码的情况
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FilePath), "UTF-8"));
            properties.load(br);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public String GetPro(String Key){
        String vaule;
        if(pro.containsKey(Key)){
            vaule = pro.getProperty(Key);
        }else {
            vaule ="";
        }
        return vaule;
    }


}
