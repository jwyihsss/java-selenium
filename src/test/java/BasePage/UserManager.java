package BasePage;

/**
 * @Author 江洁
 * @Date 2024 01 29 16 46
 **/

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


public class UserManager {
    private static WebDriver driver;

    @BeforeAll
    static void setUP() throws InterruptedException {
        // 设置chromeDriver
        System.setProperty("webdriver.chrome.driver","C:/Program Files/Java/jdk1.8.0_351/bin/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        // 最大化窗口
        options.addArguments("--start-maximized");
        // 打开浏览器的开发者模式
        options.addArguments("--auto-open-devtools-for-tabs");
        //解决报 403 问题
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        Thread.sleep(1000);
        // 隐式调用
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //登录
        // 打开网址
        driver.get("http://dev-bms.k7.cn");
        //在首页中点击tab的"账号密码登录",跳转到登陆页面
        driver.findElement(By.id("tab-normal")).click();
        //在登陆页面,输入账号
        driver.findElement(By.name("username")).sendKeys("jie");
        //输入密码
        driver.findElement(By.name("password")).sendKeys("123456");
        //点击登录按钮
        driver.findElement(By.xpath("//*[@id=\"pane-normal\"]/button")).click();
        Thread.sleep(5000);
    }


    @AfterAll
    static void tearDown() {
        //关闭浏览器
        driver.quit();
    }

    @Test
    public void Test() throws InterruptedException {
        driver.findElement(By.className("options")).click();
        //driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[1]/li/ul/div[1]/a/li/div/div/span")).click();
        //driver.findElement(By.className("el-input__inner")).sendKeys("1115611");
        //driver.findElement(By.className("el-button el-button--primary el-button--mini")).click();


    }}


