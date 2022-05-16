package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage{

    @FindBy(css = "form[class='form-section registration']")
    private WebElement signupForm;

    @FindBy(id = "Title")
    private WebElement signupTitle;

    @FindBy(id = "InputFirstName")
    private WebElement firstNameInput;

    @FindBy(id = "InputLastName")
    private WebElement lastNameInput;

    @FindBy(id = "InputEmail")
    private WebElement emailInput;

    @FindBy(id = "password-new")
    private WebElement passwordInput;

    @FindBy(id = "close")
    private WebElement closeFormButton;

    /**
     * Constructor
     *
     * @param driver WebDriver
     */
    public SignupPage(WebDriver driver) {
        super(driver);
    }
}
