import pageobjectmodel.HomePage;
import testdata.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

@RunWith(Parameterized.class)
public class FaqTest extends TestSettings {
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
                { HomePage.BUTTON_QUESTION_1, HomePage.TEXT_ANSWER_1, Constants.EXP_TEXT_1 },
                { HomePage.BUTTON_QUESTION_2, HomePage.TEXT_ANSWER_2, Constants.EXP_TEXT_2 },
                { HomePage.BUTTON_QUESTION_3, HomePage.TEXT_ANSWER_3, Constants.EXP_TEXT_3 },
                { HomePage.BUTTON_QUESTION_4, HomePage.TEXT_ANSWER_4, Constants.EXP_TEXT_4 },
                { HomePage.BUTTON_QUESTION_5, HomePage.TEXT_ANSWER_5, Constants.EXP_TEXT_5 },
                { HomePage.BUTTON_QUESTION_6, HomePage.TEXT_ANSWER_6, Constants.EXP_TEXT_6 },
                { HomePage.BUTTON_QUESTION_7, HomePage.TEXT_ANSWER_7, Constants.EXP_TEXT_7 },
                { HomePage.BUTTON_QUESTION_8, HomePage.TEXT_ANSWER_8, Constants.EXP_TEXT_8 },
        };
    }

    @Test
    public void isAnswerTextShownAndCorrect() {
        HomePage homePage = new HomePage(driver);
        homePage.clickQuestionByOrder(questionNumber);
        Assert.assertEquals(expectedAnswerText, homePage.getAnswerTextByOrder(answerText));
    }
}
