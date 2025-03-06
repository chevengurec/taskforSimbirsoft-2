import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.example.FormPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Тестирование https://practice-automation.com/form-fields/")
public class QATest extends BaseTest {


    @Test
    @Feature("Тестирование")
    public void testSubmission () {
        FormPage formPage = new FormPage(driver);


        formPage.fillNameInput("Ivan");
        formPage.fillPasswordInput("1234lll");
        formPage.choseMilk();
        formPage.choseCoffee();
        formPage.choseYellowColor();
        formPage.selectYes("Yes");
        formPage.fillEmailField("test@test.ru");
        formPage.fillTheMessage();

        formPage.submit();

        assertEquals("Message received!", formPage.allertMessage()) ;


    }

}
