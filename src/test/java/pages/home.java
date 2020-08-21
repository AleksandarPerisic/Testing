package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class home {

    public WebDriver driver;

    public static String BaseURL="http://automationpractice.com/index.php";

    @FindBy (className = "login") WebElement login;

    public home(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String CurrentURL(){
        return driver.getCurrentUrl();
    }

    public boolean isHomeLoginButtonDisplayed(){
        return login.isDisplayed();
    }

    public void goToSingInPage(){
        this.login.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
