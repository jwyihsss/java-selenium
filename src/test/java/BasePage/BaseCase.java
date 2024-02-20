
/**
 * @Author 江洁
 * @Date 2024 01 29 14 26
 **/
package BasePage;


import Utils.ReadProUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseCase {
    public WebDriver driver;
    public static Logger logger;
    public BaseCase(WebDriver baseDriver) {
        driver = baseDriver;
    }

    /**
     * 浏览器准备操作
     **/
    public BaseCase() {
        // 设置chromeDriver
        System.setProperty("webdriver.chrome.driver","C:/Program Files/Java/jdk1.8.0_351/bin/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //浏览器模拟手机模式
        //options.addArguments("--disable-web-security");
        // 最大化窗口
        options.addArguments("--start-maximized");
        // 模拟iPhone的User-Agent
        //options.addArguments("--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 12_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/73.0.3683.68 Mobile/15E148 Safari/604.1");
        //Map<String, String> mobileEmulation = new HashMap<>();
        //mobileEmulation.put("deviceName", "iPhone 14 Pro Max");
        // 启动移动设备模拟
        //options.setExperimentalOption("mobileEmulation", mobileEmulation);
        // 打开浏览器的开发者模式
        options.addArguments("--auto-open-devtools-for-tabs");
        //解决报 403 问题
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    /**
     * 浏览器退出
     */
    public void baseTearDown() {
        driver.quit();
    }

    /**
     * 封装定位方法
     *
     * @param key 配置文件的关键词
     **/
    public By GetBytLocal(String key) {
        // 读取配置信息
        String Locator = ReadProUtils.readElement(key);
        // 获取到配置信息的定位方式
        String LocatorBy = Locator.split(">")[0];
        // 获取到配置信息的元素信息
        String LocatorValue = Locator.split(">")[1];

        By by = null;
        if (LocatorBy.equals("id")) {
            by = By.id(LocatorValue);
        }
        if (LocatorBy.equals("name")) {
            by = By.name(LocatorValue);
        }
        if (LocatorBy.equals("className")) {
            by = By.className(LocatorValue);
        }
        if (LocatorBy.equals("tagName")) {
            by = By.tagName(LocatorValue);
        }
        if (LocatorBy.equals("linkText")) {
            by = By.linkText(LocatorValue);
        }
        if (LocatorBy.equals("partialLinkText")) {
            by = By.partialLinkText(LocatorValue);
        }
        if (LocatorBy.equals("cssSelector")) {
            by = By.cssSelector(LocatorValue);
        }
        if (LocatorBy.equals("xpath")) {
            by = By.xpath(LocatorValue);
        }
        return by;
    }

    /**
     * 封装获取单个元素的方法
     *
     * @param key 配置文件的关键词
     */
    public WebElement GetElement(String key) {
        WebElement webElement = driver.findElement(this.GetBytLocal(key));
        //highlightElement(webElement);
        return webElement;
    }

    /**
     * 封装获取多个元素的方法
     *
     * @param key 配置文件的关键词
     */
    public List<WebElement> GetElements(String key) {
        List<WebElement> webElements = driver.findElements(this.GetBytLocal(key));
        return webElements;
    }

    /**
     * 截屏
     * **/
    public void TakeScreenShot() {
        // 图片名字
        String curClassName = this.getClass().getName();
        String imageScreenShot = curClassName + "_" + System.currentTimeMillis() + ".png";
        // 图片存的路径
        // 获取当前文件下所在的目录
        String currentDirectory = System.getProperty("user.dir");
        String imageFilePath = currentDirectory + "/src/test/resources/ScreenShotImage/" + imageScreenShot;
        File ScrFile = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(ScrFile.toPath(), new File(imageFilePath).toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 元素高亮
     * **/
    private void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red !important; background-color: yellow;')", element);
        try {
            Thread.sleep(2000); // 显示时长1s
            //TakeScreenShot();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("arguments[0].removeAttribute('style')", element);

    }


}