package BasePage;

/**
 * @Author 江洁
 * @Date 2024 01 29 14 35
 **/
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FirstCase {
    private static WebDriver driver;
    @BeforeAll
    static void setUP() {
        System.setProperty("webdriver.chrome.driver","C:/Program Files/Java/jdk1.8.0_351/bin/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //浏览器模拟手机模式
        //options.addArguments("--disable-web-security");
        // 最大化窗口
        options.addArguments("--start-maximized");
        // 模拟iPhone的User-Agent
        //options.addArguments("--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 12_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/73.0.3683.68 Mobile/15E148 Safari/604.1");
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone 14 Pro Max");
        // 启动移动设备模拟
        //options.setExperimentalOption("mobileEmulation", mobileEmulation);
        // 打开浏览器的开发者模式
        options.addArguments("--auto-open-devtools-for-tabs");
        //解决报 403 问题
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        // 隐式调用
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    static void tearDown() {
        //关闭浏览器
        driver.quit();
    }

    @Test
    public  void Test() throws InterruptedException {

        driver.get("http://dev-bms.k7.cn/webroot/home");
        driver.findElement(By.id("tab-normal")).click();
        driver.findElement(By.name("username")).sendKeys("jie");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"pane-normal\"]/button")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement checkInput=driver.findElement(By.id("tags-view-container"));
        checkInput.click();




        //chromeDriver.findElement(By.className("options")).click();
    }}

