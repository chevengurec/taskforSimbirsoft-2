package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FormPage extends BasePage {
    public FormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='name-input']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id = 'drink2']")
    private WebElement checkBoxMilk;

    @FindBy(xpath = "//input[@id = 'drink3']")
    private WebElement checkBoxCoffee;
    @FindBy(xpath = "//input[@id='color3']")
    private WebElement radioButtonYellow;

    @FindBy(xpath = "//select[@id='automation']")
    private WebElement dropDownAuto;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(how = How.XPATH, using = "//ul[not(contains(@id, 'menu-main'))]//li")
    private List<WebElement> elementsForCount;

    @FindBy(xpath = "//textarea[@id = 'message']")
    private WebElement inputMessage;

    @FindBy(xpath="//button[@id='submit-btn']")
    private WebElement submitButton;

    public void fillNameInput(String name) {
        Actions actions = new Actions(driver);
        actions.moveToElement(nameInput).perform();
        nameInput.sendKeys(name);
    }

    public void fillPasswordInput (String password) {
        Actions actions = new Actions(driver);
        actions.moveToElement(passwordInput).perform();
        passwordInput.sendKeys(password);
    }

    public void choseMilk () {
        Actions actions = new Actions(driver);
        actions.moveToElement(checkBoxMilk).perform();
        checkBoxMilk.click();
    }

    public void choseCoffee() {
        Actions actions = new Actions(driver);
        actions.moveToElement(checkBoxCoffee).perform();
        checkBoxCoffee.click();
    }

    public void choseYellowColor() {
        Actions actions = new Actions(driver);
        actions.moveToElement(radioButtonYellow).perform();
        radioButtonYellow.click();
    }

    public void selectYes(String answer) {
        Actions actions = new Actions(driver);
        actions.moveToElement(dropDownAuto).perform();
        Select selectYes = new Select(dropDownAuto);
        selectYes.selectByVisibleText(answer);
    }

    public void fillEmailField (String email) {
        Actions actions = new Actions(driver);
        actions.moveToElement(emailField).perform();
        emailField.sendKeys(email);
    }

    public void fillTheMessage () {
         int count = elementsForCount.size();
         String count_str = Integer.toString(count);

        String longest = "";
        for (WebElement s : elementsForCount) {
            if (s.getText().length() > longest.length()) {
                longest = s.getText();
            }
        }

         inputMessage.sendKeys(count_str + " " + longest);

    }

    public void submit() {
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).perform();
        submitButton.click();
    }

    public String allertMessage () {
        return driver.switchTo().alert().getText();

    }




}
