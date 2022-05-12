package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy(linkText = "Link back to home page")
    private WebElement logoLink;

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
