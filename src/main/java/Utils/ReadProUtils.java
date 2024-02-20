
/**
 * @Author 江洁
 * @Date 2024 01 29 14 28
 **/
package Utils;

public class ReadProUtils {
    //配置信息路径
    static String configELementPath="src/test/resources/Config/Element.properties";

    static String configBasicInformationPath="src/test/resources/Config/BasicInformation.properties";
    /**
     * 读取元素信息(静态)
     * **/
    public static String readElement(String key){
        ProUtils pro =new ProUtils(configELementPath);
        String Locator = pro.GetPro(key);
        return Locator;
    }

    /**
     * 读取基本信息(静态)
     * **/
    public static String readBasicInformation(String key){
        ProUtils pro =new ProUtils(configBasicInformationPath);
        String Locator = pro.GetPro(key);
        return Locator;
    }
}

