package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = false;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Alex");
        $("#userEmail").setValue("alex@egorov.com");
        $("#currentAddress").setValue("Some street 1");
        $("#permanentAddress").setValue("Another street 1");
        $("#submit").click();

        $("#output #name").shouldHave(text("Alex"));
        $("#output #email").shouldHave(text("alex@egorov.com"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 1"));
    }

    @Test
    void fillSecondFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");

        $("#userEmail").setValue("alex@egorov.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9993334455");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2025");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__day--007").click();

        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#uploadPicture").uploadFromClasspath("AtomicHeart_sample.jpg");
        $("#currentAddress").setValue("Some street 1");

        $("#stateCity-label").scrollIntoView(true).click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        var dataTable = $("tbody");
        dataTable.shouldHave(text("Alex Ivanov"));
        dataTable.shouldHave(text("alex@egorov.com"));
        dataTable.shouldHave(text("Male"));
        dataTable.shouldHave(text("9993334455"));
        dataTable.shouldHave(text("07 May,2025"));
        dataTable.shouldHave(text("Maths"));
        dataTable.shouldHave(text("Sports"));
        dataTable.shouldHave(text("AtomicHeart_sample.jpg"));
        dataTable.shouldHave(text("Some street 1"));
        dataTable.shouldHave(text("NCR Delhi"));
    }
}
