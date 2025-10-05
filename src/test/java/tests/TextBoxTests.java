package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
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
        $x("//label[text() = 'Male']").click();
        $("#userNumber").setValue("9993334455");

        $("#dateOfBirthInput").click();
        $$x("//div[@role = 'option']").last().click();

        $("#subjectsInput").setValue("Maths");
        $x("//div[contains(@id, 'option')]").click();

        $x("//label[text() = 'Sports']").click();

        $("#uploadPicture").uploadFromClasspath("AtomicHeart_sample.jpg");

        $("#currentAddress").setValue("Some street 1");

        $x("//div[text() = 'Select State']").scrollIntoView(true).click();
        $$x("//div[contains(@id, 'option')]").first().click();

        $x("//div[text() = 'Select City']").click();
        $$x("//div[contains(@id, 'option')]").first().click();

        $("#submit").click();
    }
}
