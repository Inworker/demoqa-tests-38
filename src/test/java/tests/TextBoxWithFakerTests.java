package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import pages.components.FinalTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxWithFakerTests extends TestBase{

    TextBoxPage textBoxPage = new TextBoxPage();
    FinalTableComponent finalTableComponent = new FinalTableComponent();

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
//        Faker faker = new Faker();
//        String firstName = faker.name().firstName(); // Emory
//        String lastName = faker.name().lastName(); // Barton
//        String email = faker.internet().emailAddress(); // Barton
//        String address = faker.address().streetAddress();

        textBoxPage.openPage("/automation-practice-form")
            .setFullName(firstName, lastName)
            .setEmail(email)
            .setGender("Male")
            .setPhone("9993334455")
            .setDate("2025", "May", "07")
            .setSubject("Maths")
            .setHobbby("Sports")
            .uploadPicture("AtomicHeart_sample.jpg")
            .setAddress(address)
            .setStateAndCity("NCR", "Delhi")
            .submit()
            .checkData();
    }

    @Test
    void fillRequiredFields() {

        textBoxPage.openPage("/automation-practice-form")
                .setFullName("Alex", "Ivanov")
                .setGender("Male")
                .setPhone("9993334455")
                .setDate("2025", "May", "07")
                .setHobbby("Sports")
                .submit()
                .checkRequairedFields();
    }
    @Test
    void fillNonRequiredFields() {

        textBoxPage.openPage("/automation-practice-form")
                .setEmail("alex@egorov.com")
                .setDate("2025", "May", "07")
                .setSubject("Maths")
                .setHobbby("Sports")
                .uploadPicture("AtomicHeart_sample.jpg")
                .setAddress("Some street 1")
                .setStateAndCity("NCR", "Delhi")
                .submit();
        finalTableComponent.checkNotVisibleTable();
    }
}
