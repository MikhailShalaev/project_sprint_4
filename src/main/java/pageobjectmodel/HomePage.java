package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // "Заказать" в хэдере
    private final static By BUTTON_ORDER_HEADER = By.xpath(".//button[@class='Button_Button__ra12g']");
    // "Заказать" в середине страницы
    private final static By BUTTON_ORDER_ROADMAP = By.cssSelector("div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button");
    // Элементы Accordion
    // Первый вопрос кнопка
    public final static By BUTTON_QUESTION_1 = By.id("accordion__heading-0");
    // Панель c текстом ответа на первый вопрос
    public final static By TEXT_ANSWER_1 = By.id("accordion__panel-0");
    // Второй вопрос кнопка
    public final static By BUTTON_QUESTION_2 = By.id("accordion__heading-1");
    // Панель c текстом ответа на второй вопрос
    public final static By TEXT_ANSWER_2 = By.id("accordion__panel-1");
    // Третий вопрос кнопка
    public final static By BUTTON_QUESTION_3 = By.id("accordion__heading-2");
    // Панель c текстом ответа на третий вопрос
    public final static By TEXT_ANSWER_3 = By.id("accordion__panel-2");
    // Четвертый вопрос кнопка
    public final static By BUTTON_QUESTION_4 = By.id("accordion__heading-3");
    // Панель c текстом ответа на четвертый вопрос
    public final static By TEXT_ANSWER_4 = By.id("accordion__panel-3");
    // Пятый вопрос кнопка
    public final static By BUTTON_QUESTION_5 = By.id("accordion__heading-4");
    // Панель c текстом ответа на пятый вопрос
    public final static By TEXT_ANSWER_5 = By.id("accordion__panel-4");
    // Шестой вопрос кнопка
    public final static By BUTTON_QUESTION_6 = By.id("accordion__heading-5");
    // Панель c текстом ответа на шестой вопрос
    public final static By TEXT_ANSWER_6 = By.id("accordion__panel-5");
    // Седьмой вопрос кнопка
    public final static By BUTTON_QUESTION_7 = By.id("accordion__heading-6");
    // Панель c текстом ответа на седьмой вопрос
    public final static By TEXT_ANSWER_7 = By.id("accordion__panel-6");
    // Восьмой вопрос кнопка
    public final static By BUTTON_QUESTION_8 = By.id("accordion__heading-7");
    // Панель c текстом ответа на восьмой вопрос
    public final static By TEXT_ANSWER_8 = By.id("accordion__panel-7");
    //Кнопка на алерте про куки
    private final By hideCookieAlert = By.id("rcc-confirm-button");


    public void cookieMonster() {
        driver.findElement(hideCookieAlert).click();
    }

    public void clickQuestionByOrder(By elementLocator) {
        WebElement element = driver.findElement(elementLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public String getAnswerTextByOrder(By elementLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        return element.getText();
    }

    public void clickButtonOrderHeader() {
        driver.findElement(BUTTON_ORDER_HEADER).click();
    }

    public void clickButtonOrderRoadmap() {
        WebElement element = driver.findElement(BUTTON_ORDER_ROADMAP);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

}