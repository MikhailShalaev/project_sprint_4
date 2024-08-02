package pageobjectmodel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.Constants;

public class OrderPage {
    private final WebDriver driver;
    //Поле ввода "Имя"
    private final static By INPUT_FNAME = By.xpath(".//input[@placeholder='* Имя']");
    //Поле ввода "Фамилия"
    private final static By INPUT_LNAME = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле ввода "Адрес"
    private final static By INPUT_ADRESS = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле ввода\выбора "Станция метро"
    private final static By INPUT_STATION = By.xpath(".//input[@placeholder='* Станция метро']");
    //Поле ввода "Телефон"
    private final static By INPUT_TELNUM = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div:nth-child(5) > input");
    //Кнопка "Далее"
    private final static By BUTTON_PROCEED = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Поле выбора даты
    private final static By INPUT_DATE = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Поле выбора "Срок аренды"
    private final static By INPUT_DURATION = By.xpath(".//div[@class='Dropdown-placeholder']");
    //Выпадающий список "Срок аренды"
    private final static By SELECT_DURATION = By.xpath(".//div[@class='Dropdown-menu']/div[2]");
    //Чекбокс выбора цвета "черный"
    private final static By SELECT_COLOUR_BLACK = By.id("black");
    //Поле ввода "Комментарий"
    private final static By INPUT_COMMENT = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать"
    private final static By BUTTON_ORDER = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка "да" в поп-апе
    private final static By BUTTON_SUBMIT = By.xpath(".//button[text()='Да']");
    //Текст сообщения об успешном оформлении
    private final static By ORDER_STATUS = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFname(String text) {
        driver.findElement(INPUT_FNAME).sendKeys(text);
    }
    public void inputLname(String text) {
        driver.findElement(INPUT_LNAME).sendKeys(text);
    }
    public void inputAddress(String text) {
        driver.findElement(INPUT_ADRESS).sendKeys(text);
    }
    public void inputStation() {
        driver.findElement(INPUT_STATION).click();
        driver.findElement(INPUT_STATION).sendKeys(Keys.DOWN);
        driver.findElement(INPUT_STATION).sendKeys(Keys.ENTER);
    }
    public void inputTelnum(String text) {
        driver.findElement(INPUT_TELNUM).sendKeys(text);
    }
    public void clickButtonProceed() {
        driver.findElement(BUTTON_PROCEED).click();
    }

    public void inputOrderDate() {
        driver.findElement(INPUT_DATE).sendKeys(Keys.DOWN);
        driver.findElement(INPUT_DATE).sendKeys(Keys.ENTER);
    }
    public void selectDuration() {
        driver.findElement(INPUT_DURATION).click();
        driver.findElement(SELECT_DURATION).click();
    }
    public void inputOrderColour() {
        driver.findElement(SELECT_COLOUR_BLACK).click();
    }

    public void inputComment(String text) {
        driver.findElement(INPUT_COMMENT).sendKeys(text);
    }
    public void clickButtonOrder() {
        driver.findElement(BUTTON_ORDER).click();
    }
    public void clickButtonConfirm() {
        driver.findElement(BUTTON_SUBMIT).click();
    }

    public boolean isPopupShown(){
        return driver.findElement(ORDER_STATUS).isDisplayed();
    }

    public boolean isPopupHeaderTextShown() {
        return driver.findElement(ORDER_STATUS).getText().contains(Constants.POPUP_EXP_TEXT);
    }

}