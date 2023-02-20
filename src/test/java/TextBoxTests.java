import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    Faker data = new Faker();

    String firstName = data.name().firstName();
    String lastName = data.name().lastName();
    String fullName = firstName + " " + lastName;
    String email = firstName + '.' + lastName + "@example.com";
    String currAddress = data.address().fullAddress();
    String permAddress = data.address().fullAddress();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1680x1050";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/text-box");

        $("#userName").setValue(fullName);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currAddress);
        $("#permanentAddress").setValue(permAddress);

        $("#submit").click();

        $("#output").shouldHave(
                text(fullName),
                text(email),
                text(currAddress),
                text(permAddress)
        );
    }
}