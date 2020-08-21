package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class singin {

    public WebDriver driver;

    @FindBy (id = "email") WebElement emailField;
    @FindBy (id = "passwd") WebElement passwordField;
    @FindBy (id = "SubmitLogin") WebElement submit;

    public singin(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void enterEmailAndPassword(){
        this.emailField.sendKeys("randomstring@mailinator.co");
        this.passwordField.sendKeys("12345678");
    }

    public void submit(){
        submit.click();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    }
}
