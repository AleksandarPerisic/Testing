package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;

public class accountcreation {

    public WebDriver driver;

    @FindBy (id = "email_create") WebElement emailCreate;
    @FindBy (id = "SubmitCreate") WebElement submitCreate;
    @FindBy (className = "page-heading") WebElement createAnAccountPage;
    @FindBy (id = "id_gender1") WebElement mrCheckBox;
    @FindBy (id = "id_gender2") WebElement mrsCheckBox;
    @FindBy (id = "customer_firstname") WebElement firstname;
    @FindBy (id = "customer_lastname") WebElement lastname;
    @FindBy (id = "email") WebElement email;
    @FindBy (id = "passwd") WebElement password;
    @FindBy (id = "firstname") WebElement firstnameAddress;
    @FindBy (id = "lastname") WebElement lastnameAddress;
    @FindBy (id = "address1") WebElement address;
    @FindBy (id = "city") WebElement city;
    @FindBy (id = "id_state") WebElement state;
    @FindBy (id = "postcode") WebElement postcode;
    @FindBy (id = "id_country") WebElement country;
    @FindBy (id = "phone_mobile") WebElement mobile;
    @FindBy (id = "alias") WebElement secAddress;
    @FindBy (id = "submitAccount") WebElement submitAccount;
    @FindBy (id = "my-account") WebElement myAccount;

    public accountcreation(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void genarateMail (String mail){
        this.emailCreate.sendKeys(mail);
    }

    public boolean isCreateAnAccountPageDisplayed(){
        return createAnAccountPage.isDisplayed();
    }

    public boolean isMyAccountPageDisplayed(){
        return myAccount.isDisplayed();
    }

    public static void selectByValue(WebElement element, String value) {
        Select selectElement = new Select(element);
        selectElement.selectByValue(value);
    }

    public void enterAccountInformation(){
        this.mrCheckBox.click();
        this.firstname.sendKeys("Alex");
        this.lastname.sendKeys("Alex");
        this.password.sendKeys("12345678");
        this.address.sendKeys("test1234");
        this.city.sendKeys("New York");
        selectByValue(this.state,"1");
        this.postcode.sendKeys("12345");
        this.mobile.sendKeys("06123456789");
        this.secAddress.sendKeys("test1234567");
    }

    public void submitAccount(){
        submitAccount.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void goToCreateAccountPage(){
        submitCreate.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


}
