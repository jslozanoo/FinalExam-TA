package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(css = "form[class='form-section login']")
    private WebElement loginForm;

    @FindBy(id = "logo")
    private WebElement espnLogo;

    @FindBy(id = "BtnSubmit")
    private WebElement loginButton;

    @FindBy(id = "BtnCreateAccount")
    private WebElement signupButton;

    /**
     * Constructor
     *
     * @param driver WebDriver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * True if espn logo, login button and signup button are visible. False otherwise
     * @return Boolean
     */
    public boolean areElementsVisible(){
        if (isElementAvailable(loginForm)){
            return isElementAvailable(espnLogo) && isElementAvailable(loginButton)
                    && isElementAvailable(signupButton);
        }
        else {
            return false;
        }
    }

    /**
     * Click on signup page to create an account.
     * @return SignupPage {@link SignupPage}
     */
    public SignupPage goToSignupPage(){
        click(signupButton);

        return new SignupPage(getDriver());
    }
}
