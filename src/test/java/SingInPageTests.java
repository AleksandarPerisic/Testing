import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.home;
import pages.singin;

import java.util.concurrent.TimeUnit;

public class SingInPageTests extends BaseWebDriverTest{

    home homepage;
    singin singInPage;

    @Before
    public void init(){
        homepage = new home(driver);
        singInPage = new singin(driver);
        driver.get(homepage.BaseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homepage.goToSingInPage();
    }

    @Test
    public void verifyLogInFunctionally(){
        isElementDisplayed(By.id("authentication"));
        isElementDisplayed(By.id("login_form"));
        singInPage.enterEmailAndPassword();
        singInPage.submit();
        isElementDisplayed(By.id("my-account"));
    }
}

