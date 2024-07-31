package PageObjectModel;

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
    private final static By button_order_header = By.xpath(".//button[@class='Button_Button__ra12g']");
    // "Заказать" в середине страницы
    private final static By button_order_roadmap = By.cssSelector("div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button");
    // Элементы Accordion
    // Первый вопрос кнопка
    public final static By button_question_1 = By.id("accordion__heading-0");
    // Панель c текстом ответа на первый вопрос
    public final static By text_answer_1 = By.id("accordion__panel-0");
    // Второй вопрос кнопка
    public final static By button_question_2 = By.id("accordion__heading-1");
    // Панель c текстом ответа на второй вопрос
    public final static By text_answer_2 = By.id("accordion__panel-1");
    // Третий вопрос кнопка
    public final static By button_question_3 = By.id("accordion__heading-2");
    // Панель c текстом ответа на третий вопрос
    public final static By text_answer_3 = By.id("accordion__panel-2");
    // Четвертый вопрос кнопка
    public final static By button_question_4 = By.id("accordion__heading-3");
    // Панель c текстом ответа на четвертый вопрос
    public final static By text_answer_4 = By.id("accordion__panel-3");
    // Пятый вопрос кнопка
    public final static By button_question_5 = By.id("accordion__heading-4");
    // Панель c текстом ответа на пятый вопрос
    public final static By text_answer_5 = By.id("accordion__panel-4");
    // Шестой вопрос кнопка
    public final static By button_question_6 = By.id("accordion__heading-5");
    // Панель c текстом ответа на шестой вопрос
    public final static By text_answer_6 = By.id("accordion__panel-5");
    // Седьмой вопрос кнопка
    public final static By button_question_7 = By.id("accordion__heading-6");
    // Панель c текстом ответа на седьмой вопрос
    public final static By text_answer_7 = By.id("accordion__panel-6");
    // Восьмой вопрос кнопка
    public final static By button_question_8 = By.id("accordion__heading-7");
    // Панель c текстом ответа на восьмой вопрос
    public final static By text_answer_8 = By.id("accordion__panel-7");
    //Кнопка на алерте про куки
    private final By hide_cookie_alert = By.id("rcc-confirm-button");


    public void cookieMonster() {
        driver.findElement(hide_cookie_alert).click();
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
        driver.findElement(button_order_header).click();
    }

    public void clickButtonOrderRoadmap() {
        WebElement element = driver.findElement(button_order_roadmap);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

}