package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    private SelenideElement firstNameLocator = $("#firstName"),
     lastNameLocator = $("#lastName"),
     emailLocator = $("#userEmail"),
     genderLocator = $("#genterWrapper"),
     phoneLocator = $("#userNumber"),

     subjectLocator = $("#subjectsInput"),
     hobbyLocator = $("#hobbiesWrapper"),
     pathPictureLocator = $("#uploadPicture"),
     addressLocator = $("#currentAddress"),
     labelStateLocator = $("#stateCity-label"),
     stateLocator = $("#react-select-3-input"),
     cityLocator = $("#react-select-4-input"),
     submitLocator = $("#submit");
    CalendarComponent calendarComponent = new CalendarComponent();




    public TextBoxPage  openPage(String url) {

        open(url);
        return this;
    }

    public TextBoxPage setFullName(String fullName, String lastName)
    {
        firstNameLocator.sendKeys(fullName);
        lastNameLocator.sendKeys(lastName);
        return this;
    }

    public TextBoxPage  setEmail(String mail) {

        emailLocator.sendKeys(mail);
        return this;

    }

    public TextBoxPage setDate(String year, String month) {
        calendarComponent.setBirthday( year,  month);
        return this;
    }

    public TextBoxPage  setGender(String gender) {

        genderLocator.$(byText(gender)).click();
        return this;

    }

    public TextBoxPage  setPhone(String phone) {

        phoneLocator.sendKeys(phone);
        return this;
    }

    public TextBoxPage  setSubject(String subject) {

        subjectLocator.setValue(subject).pressEnter();
        return this;

    }

    public TextBoxPage  setHobbby(String hobby) {

        hobbyLocator.$(byText(hobby)).click();
        return this;

    }

    public TextBoxPage  uploadPicture(String pathPicture) {

        pathPictureLocator.uploadFromClasspath(pathPicture);
        return this;

    }

    public TextBoxPage  setAddress(String address) {

        addressLocator.setValue(address);
        return this;

    }

    public TextBoxPage  setStateAndCity(String state, String city) {

        labelStateLocator.scrollIntoView(true).click();;
        stateLocator.setValue(state).pressEnter();
        cityLocator.setValue(city).pressEnter();
        return this;

    }

    public TextBoxPage  submit() {

        submitLocator.click();
        return this;

    }
    public TextBoxPage  checkData(){
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
        return this;

    }
}

