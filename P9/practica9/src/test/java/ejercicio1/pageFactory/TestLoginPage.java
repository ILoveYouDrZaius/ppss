package ejercicio1.pageFactory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class TestLoginPage {
    WebDriver driver;
    LoginPage poLogin;
    ManagerPage poManagerPage;
    
    @Before
    public void setup(){
        driver = new FirefoxDriver();
        poLogin = PageFactory.initElements(driver, LoginPage.class);
        
    }
    
    @Test
    public void test_Login_Correct(){
        String loginPageTitle = poLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
        poLogin.login("mngr34733", "AbEvydU");
        poManagerPage = PageFactory.initElements(driver, ManagerPage.class);
        driver.close();
        Assert.assertTrue(poManagerPage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr34733"));
    }
    
    @Test
    public void test_Login_Incorrect(){
        String loginPageTitle = poLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
        poLogin.login("juan", "juan");
        
        Alert alert = driver.switchTo().alert();
        String mensaje = alert.getText();
        driver.close();

        Assert.assertEquals(mensaje, "User or Password is not valid");

        alert.accept();
    }

}
