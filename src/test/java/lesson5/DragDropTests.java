package lesson5;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragDropTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1680x1050";
    }

    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement elemA = $("#column-a");
        SelenideElement elemB = $("#column-b");
        (elemA).dragAndDropTo(elemB);
        elemB.shouldHave(exactText("A"));
        elemA.shouldHave(exactText("B"));
    }
}
