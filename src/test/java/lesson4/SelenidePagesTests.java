package lesson4;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenidePagesTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1680x1050";
    }

    String expectedCode = """
            @ExtendWith({SoftAssertsExtension.class})
            class Tests {
              @Test
              void test() {
                Configuration.assertionMode = SOFT;
                open("page.html");
                
                $("#first").should(visible).click();
                $("#second").should(visible).click();
              }
            }""";

    @Test
    void softAssertionsJUnit5CodeTest() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("div .filter-bar #wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box[role='navigation']").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        String actualCode =
                $("#user-content-3-using-junit5-extend-test-class")
                .ancestor("h4")
                .sibling(0)
                .$("pre")
                .getText();

        Assertions.assertEquals(
                expectedCode,
                actualCode,
                "JUnit5 example code on SoftAssertions page is not the same as expected");
    }
}
