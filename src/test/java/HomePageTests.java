import org.openqa.selenium.By;
import pages.home;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class HomePageTests extends BaseWebDriverTest{

    home homepage;

    @Before
    public void init(){
        homepage = new home(driver);
        driver.get(homepage.BaseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyHomePage() {
        assertTrue(homepage.BaseURL.matches(homepage.CurrentURL()));
        assertThat(driver.getTitle(),containsString("Store"));
        isElementDisplayed(By.id("page"));
        isElementDisplayed(By.id("homepage-slider"));
        assertTrue(homepage.isHomeLoginButtonDisplayed());
    }

}
