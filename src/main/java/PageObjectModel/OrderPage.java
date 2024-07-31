package PageObjectModel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private final WebDriver driver;
    //Поле ввода "Имя"
    private final static By input_fname = By.xpath(".//input[@placeholder='* Имя']");
    //Поле ввода "Фамилия"
    private final static By input_lname = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле ввода "Адрес"
    private final static By input_adress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле ввода\выбора "Станция метро"
    private final static By input_station = By.xpath(".//input[@placeholder='* Станция метро']");
    //Поле ввода "Телефон"
    private final static By input_telnum = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div:nth-child(5) > input");
    //Кнопка "Далее"
    private final static By button_proceed = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Поле выбора даты
    private final static By input_date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Поле выбора "Срок аренды"
    private final static By input_duration = By.xpath(".//div[@class='Dropdown-placeholder']");
    //Выпадающий список "Срок аренды"
    private final static By select_duration = By.xpath(".//div[@class='Dropdown-menu']/div[2]");
    //Чекбокс выбора цвета "черный"
    private final static By select_color_black = By.id("black");
    //Поле ввода "Комментарий"
    private final static By input_comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать"
    private final static By button_order = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка "да" в поп-апе
    private final static By button_sumbit = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Текст сообщения об успешном оформлении
    private final static By order_status = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFname(String text) {
        driver.findElement(input_fname).sendKeys(text);
    }
    public void inputLname(String text) {
        driver.findElement(input_lname).sendKeys(text);
    }
    public void inputAddress(String text) {
        driver.findElement(input_adress).sendKeys(text);
    }
    public void inputStation() {
        driver.findElement(input_station).click();
        driver.findElement(input_station).sendKeys(Keys.DOWN);
        driver.findElement(input_station).sendKeys(Keys.ENTER);
    }
    public void inputTelnum(String text) {
        driver.findElement(input_telnum).sendKeys(text);
    }
    public void clickButtonProceed() {
        driver.findElement(button_proceed).click();
    }

    public void inputOrderDate() {
        driver.findElement(input_date).sendKeys(Keys.DOWN);
        driver.findElement(input_date).sendKeys(Keys.ENTER);
    }
    public void selectDuration() {
        driver.findElement(input_duration).click();
        driver.findElement(select_duration).click();
    }
    public void inputOrderColour() {
        driver.findElement(select_color_black).click();
    }

    public void inputComment(String text) {
        driver.findElement(input_comment).sendKeys(text);
    }
    public void clickButtonOrder() {
        driver.findElement(button_order).click();
    }
    public void clickButtonConfirm() {
        driver.findElement(button_sumbit).click();
    }

    public boolean isOrderCreated() {
        return driver.findElement(order_status).isDisplayed();
    }

}