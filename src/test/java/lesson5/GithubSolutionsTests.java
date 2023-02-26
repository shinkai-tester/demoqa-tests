package lesson5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubSolutionsTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1680x1050";
    }

    @Test
    void githubSolutionsHoverTest() {
        open("https://github.com/");
        $(byText("Solutions")).hover();
        $(byAttribute("href", "/enterprise")).click();
        $(byText("GitHub for enterprises")).
                sibling(0).
                shouldHave(text("Build like the best"));

    }
}
