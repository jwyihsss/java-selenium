

/**
 * @Author 江洁
 * @Date 2024 01 29 14 37
 **/

import BasePage.BaseCase;
import Utils.ReadProUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;


public class FristSprict1 extends BaseCase {


    @Test
    public void Case() throws InterruptedException {
        logger = LoggerFactory.getLogger(FristSprict1.class);

        logger.info("================== 打开首页 ==================");
        driver.get(ReadProUtils.readBasicInformation("mainURL"));
        Thread.sleep(5000);

        logger.info("================== 点击首页tab栏中的账号登录 ==================");
        WebElement tabMyElement = GetElement("tabMyElement");
        tabMyElement.click();
        Thread.sleep(5000);

//        logger.info("================== 点击登陆页面的账号登陆 ==================");
//        WebElement loginAccountElement = GetElement("loginAccountElement");
//        if (loginAccountElement.getText().equals("账号登录")) {
//            loginAccountElement.click();
//        }
//        Thread.sleep(5000);

        logger.info("================== 输入账号 ==================");
        WebElement Element = GetElement("webElement");
        Element.click();
        Element.sendKeys(ReadProUtils.readBasicInformation("admin_name"));

        logger.info("================== 输入登陆密码 ==================");
        WebElement passWordElement =GetElement("passWordElement");
        passWordElement.click();
        passWordElement.sendKeys(ReadProUtils.readBasicInformation("Password"));
        Thread.sleep(5000);

//        logger.info("================== 点击同意协议 ==================");
//        WebElement agreementConsentElement = GetElement("agreementConsentElement");
//        agreementConsentElement.click();
//        Thread.sleep(5000);

        logger.info("================== 点击登陆按钮 ==================");
        WebElement loginButtonElement = GetElement("loginButtonElement");
        loginButtonElement.click();
        //TakeScreenShot();
        Thread.sleep(5000);

        //关闭浏览器
        baseTearDown();
    }

}
