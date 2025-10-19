package tests;


import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends TestBase{

    TextBoxPage textBoxPage = new TextBoxPage();

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

        textBoxPage.openPage("/automation-practice-form")
            .setFullName("Alex", "Ivanov")
            .setEmail("alex@egorov.com")
            .setGender("Male")
            .setPhone("9993334455")
            .setBirthday("2025", "May")
            .setSubject("Maths")
            .setHobbby("Sports")
            .uploadPicture("AtomicHeart_sample.jpg")
            .setAddress("Some street 1")
            .setStateAndCity("NCR", "Delhi")
            .submit()
            .checkData();
    }
}
