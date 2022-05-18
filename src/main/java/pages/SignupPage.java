package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page representing signup form.
 * @author js.lozano
 */
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

    @FindBy(id = "BtnSubmit")
    private WebElement signupButton;

    /**
     * Constructor
     *
     * @param driver WebDriver
     */
    public SignupPage(WebDriver driver) {
        super(driver);
    }

    /**
     * True if all inputs boxes are displayed. False otherwise
     * @return Boolean
     */
    public boolean areInputsDisplayed(){
        if (isElementAvailable(signupForm)){
            return isElementAvailable(firstNameInput) && isElementAvailable(lastNameInput)
                    && isElementAvailable(emailInput) && isElementAvailable(passwordInput);
        }
        else return false;
    }

    /**
     * True if signup form title is displayed. False otherwise
     * @return Boolean
     */
    public boolean isTitleDisplayed(){
        return isElementAvailable(signupTitle);
    }

    /**
     * True if close button form is displayed
     * @return Boolean
     */
    public boolean isCloseFormButtonDisplayed(){
        return isElementAvailable(closeFormButton);
    }

    /**
     * True if signup button is clickable. False otherwise
     * @return Boolean
     */
    public boolean isSignupButtonDisplayed(){
        return isElementAvailable(signupButton);
    }

    /**
     * Complete form with lastname, firstname, email and password
     * @param firstName String firstname
     * @param lastName String lastname
     * @param email String email
     * @param password String password
     */
    public void completeFormInputs(String firstName, String lastName, String email, String password){
        log.info("Completing form inputs");
        sendKeys(firstNameInput, firstName);
        sendKeys(lastNameInput, lastName);
        sendKeys(emailInput, email);
        sendKeys(passwordInput, password);
    }

    /**
     * Click on signup button to create an account
     * @return MainPage {@link MainPage}
     */
    public MainPage createAccount(){
        scrollDownUntilElementVisibility(signupButton);
        click(signupButton);

        return new MainPage(getDriver());
    }
}
