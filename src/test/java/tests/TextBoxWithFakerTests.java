package tests;

import com.github.javafaker.Faker;
import data.TestData;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import pages.components.FinalTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static data.TestData.getRandomCity;
import static java.lang.String.format;

public class TextBoxWithFakerTests extends TestBase{

    TextBoxPage textBoxPage = new TextBoxPage();
    FinalTableComponent finalTableComponent = new FinalTableComponent();
    TestData testData = new TestData();

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
        textBoxPage.openPage()
            .setFullName(testData.firstName, testData.lastName)
            .setEmail(testData.email)
            .setGender(testData.gender)
            .setPhone(testData.phone)
            .setDate(testData.year, testData.month, testData.day)
            .setSubject(testData.subjects)
            .setHobby(testData.hobbies)
            .uploadPicture(testData.pathImage)
            .setAddress(testData.address)
            .setStateAndCity(testData.state, testData.city)
            .submit();
        finalTableComponent
                .checkTableData("Student Name", testData.firstName + " " + testData.lastName)
                .checkTableData("Student Email",testData.email)
                .checkTableData("Gender", testData.gender)
                .checkTableData("Mobile", testData.phone)
                .checkTableData("Date of Birth",testData.day + " " + testData.month + "," + testData.year)
                .checkTableData("Subjects", testData.subjects)
                .checkTableData("Hobbies", testData.hobbies)
                .checkTableData("Picture",testData.pathImage)
                .checkTableData("Address", testData.address)
                .checkTableData("State and City", testData.state + " " + testData.city);
    }

    @Test
    void fillRequiredFields() {

        textBoxPage.openPage()
                .setFullName(testData.firstName, testData.lastName)
                .setGender(testData.gender)
                .setPhone(testData.phone)
                .setDate(testData.year, testData.month, testData.day)
                .setHobby(testData.hobbies)
                .submit();
        finalTableComponent.checkTitle()
                .checkTableData("Student Name", testData.firstName + " " + testData.lastName)
                .checkTableData("Mobile", testData.phone)
                .checkTableData("Date of Birth",testData.day + " " + testData.month + "," + testData.year);
    }
    @Test
    void fillNonRequiredFields() {

        textBoxPage.openPage()
                .setEmail(testData.email)
                .setDate(testData.year, testData.month, testData.day)
                .setSubject(testData.subjects)
                .setHobby(testData.hobbies)
                .uploadPicture(testData.pathImage)
                .setAddress(testData.address)
                .setStateAndCity(testData.state, testData.city)
                .submit();
        finalTableComponent.checkNotVisibleTable();
    }
}
