import org.junit.Assert;
import pageobjectmodel.HomePage;
import pageobjectmodel.OrderPage;
import testdata.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderTest extends TestSettings {
    private final String fname;
    private final String lname;
    private final String adress;
    private final String telnum;
    private final String comment;

    public OrderTest(String fname, String lname, String adress, String telnum, String comment) {
        this.fname = fname;
        this.lname = lname;
        this.adress = adress;
        this.telnum = telnum;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                { Constants.FNAME1, Constants.LNAME1, Constants.ADRESS1, Constants.TELNUM1, Constants.COMMENT1 },
                { Constants.FNAME2, Constants.LNAME2, Constants.ADRESS2, Constants.TELNUM2, Constants.COMMENT2 },
                { Constants.FNAME3, Constants.LNAME3, Constants.ADRESS3, Constants.TELNUM3, Constants.COMMENT3 }
        };
    }


    @Test
    public void orderFlowHeaderButtonPositive() {
        HomePage homePage = new HomePage(driver);
        homePage.clickButtonOrderHeader();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.inputFname(fname);
        orderPage.inputLname(lname);
        orderPage.inputAddress(adress);
        orderPage.inputStation();
        orderPage.inputTelnum(telnum);
        orderPage.clickButtonProceed();
        orderPage.inputOrderDate();
        orderPage.selectDuration();
        orderPage.inputOrderColour();
        orderPage.inputComment(comment);
        orderPage.clickButtonOrder();
        orderPage.clickButtonConfirm();
        Assert.assertTrue(orderPage.isPopupShown());
        Assert.assertTrue("Текст заголовка не соответствует ожидаемому", orderPage.isPopupHeaderTextShown());
    }

    @Test
    public void orderFlowRoadmapButtonPositive() {
        HomePage homePage = new HomePage(driver);
        homePage.clickButtonOrderRoadmap();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.inputFname(fname);
        orderPage.inputLname(lname);
        orderPage.inputAddress(adress);
        orderPage.inputStation();
        orderPage.inputTelnum(telnum);
        orderPage.clickButtonProceed();
        orderPage.inputOrderDate();
        orderPage.selectDuration();
        orderPage.inputOrderColour();
        orderPage.inputComment(comment);
        orderPage.clickButtonOrder();
        orderPage.clickButtonConfirm();
        Assert.assertTrue(orderPage.isPopupShown());
        Assert.assertTrue("Текст заголовка не соответствует ожидаемому", orderPage.isPopupHeaderTextShown());
    }
}