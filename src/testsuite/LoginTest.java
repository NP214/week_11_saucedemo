package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";
    @Before
    public void openBrowser(){
        setUpBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
//Enter “standard_user” username
       WebElement userName = driver.findElement(By.id("user-name"));
       userName.sendKeys("standard_user");
//Enter “secret_sauce” password
      WebElement passWord = driver.findElement(By.id("password"));
      passWord.sendKeys("secret_sauce");
//Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
//Verify the text “PRODUCTS
        String expectedText = "PRODUCTS";
        String actualText = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        System.out.println(actualText);
        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” username
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
//Enter “secret_sauce” password
        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("secret_sauce");
//Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
//Verify that six products are displayed on page and store in List webelement
     List<WebElement> productsList = driver.findElements(By.xpath("//div[@class='inventory_item']"));
     // to check how many products are,use size method
        int actualNumOfProducts = productsList.size();
        System.out.println(actualNumOfProducts);
        int expectedNoOfProducts = 6;
        Assert.assertEquals(expectedNoOfProducts,actualNumOfProducts);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
