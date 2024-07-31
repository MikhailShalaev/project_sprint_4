import PageObjectModel.HomePage;
import TestData.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class FaqTest {
    private WebDriver driver;
    private final By questionNumber;
    private final By answerText;
    private final String expectedAnswerText;

    public FaqTest(By questionNumber, By answerText, String expectedAnswerText) {
        this.questionNumber = questionNumber;
        this.answerText = answerText;
        this.expectedAnswerText = expectedAnswerText;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {
                        HomePage.button_question_1, HomePage.text_answer_1, Constants.EXP_TEXT_1
                }, {
                HomePage.button_question_2,
                HomePage.text_answer_2,
                Constants.EXP_TEXT_2
        }, {
                HomePage.button_question_3,
                HomePage.text_answer_3,
                Constants.EXP_TEXT_3
        }, {
                HomePage.button_question_4,
                HomePage.text_answer_4,
                Constants.EXP_TEXT_4
        }, {
                HomePage.button_question_5,
                HomePage.text_answer_5,
                Constants.EXP_TEXT_5
        }, {
                HomePage.button_question_6,
                HomePage.text_answer_6,
                Constants.EXP_TEXT_6
        }, {
                HomePage.button_question_7,
                HomePage.text_answer_7,
                Constants.EXP_TEXT_7
        }, {
                HomePage.button_question_8,
                HomePage.text_answer_8,
                Constants.EXP_TEXT_8
        },
        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(Constants.TEST_URL);
        HomePage homePage = new HomePage(driver);
        homePage.cookieMonster();
    }

    @Test
    public void isAnswerTextCorrect() {
        HomePage homePage = new HomePage(driver);
        homePage.clickQuestionByOrder(questionNumber);
        Assert.assertEquals(expectedAnswerText, homePage.getAnswerTextByOrder(answerText));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}