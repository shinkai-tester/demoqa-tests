import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests {

    Faker data = new Faker();
    String firstName = data.name().firstName();
    String lastName = data.name().lastName();
    String email = firstName + '.' + lastName + "@example.com";
    String phone = data.phoneNumber().subscriberNumber(10);
    LocalDate birthday = data.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    String month = StringUtils.capitalize(birthday.getMonth().name().toLowerCase());
    String year = Integer.toString(birthday.getYear());
    String day = birthday.format(DateTimeFormatter.ofPattern("dd"));
    String[] genders = new String[]{"Male","Female","Other"};
    String gender = getRndValueArr(genders);
    String[] hobbies = new String[]{"Sports","Reading","Music"};
    String hobby = getRndValueArr(hobbies);
    String currAddress = data.address().streetAddress();

    public static String getRndValueArr(String[] arr) {
        int rnd = new Random().nextInt(arr.length);
        return arr[rnd];
    }

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1680x1050";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillAllDataTest() {

        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day.react-datepicker__day--0" + day).click();
        $("#subjectsWrapper").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath("Bugcat_Capoo.jpg");
        $("#currentAddress").setValue(currAddress);
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Karnal")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text(gender),
                text(phone),
                text(day + " " + month + "," + year),
                text("Computer Science"),
                text(hobby),
                text("Bugcat_Capoo.jpg"),
                text(currAddress),
                text("Haryana"),
                text("Karnal")
        );

        $("#closeLargeModal").click();
    }
}
