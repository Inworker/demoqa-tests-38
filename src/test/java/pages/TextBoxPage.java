package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.FinalTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    FinalTableComponent finalTableComponent = new FinalTableComponent();

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

    private String url = "/automation-practice-form";





    public TextBoxPage openPage() {

        open(url);
        return this;
    }

    public TextBoxPage setFullName(String fullName, String lastName)
    {
        firstNameLocator.sendKeys(fullName);
        lastNameLocator.sendKeys(lastName);
        return this;
    }

    public TextBoxPage setEmail(String mail) {

        emailLocator.sendKeys(mail);
        return this;

    }

    public TextBoxPage setDate(String year, String month, String day) {
        calendarComponent.setBirthday( year,  month, day);
        return this;
    }

    public TextBoxPage setGender(String gender) {

        genderLocator.$(byText(gender)).click();
        return this;

    }

    public TextBoxPage setPhone(String phone) {

        phoneLocator.sendKeys(phone);
        return this;
    }

    public TextBoxPage setSubject(String subject) {

        subjectLocator.setValue(subject).pressEnter();
        return this;

    }

    public TextBoxPage setHobby(String hobby) {

        hobbyLocator.$(byText(hobby)).click();
        return this;

    }

    public TextBoxPage uploadPicture(String pathPicture) {

        pathPictureLocator.uploadFromClasspath(pathPicture);
        return this;

    }

    public TextBoxPage setAddress(String address) {

        addressLocator.setValue(address);
        return this;

    }

    public TextBoxPage setStateAndCity(String state, String city) {

        labelStateLocator.scrollIntoView(true).click();
        stateLocator.setValue(state).pressEnter();
        cityLocator.setValue(city).pressEnter();
        return this;

    }

    public void submit() {

        submitLocator.scrollTo();
        submitLocator.scrollTo().click();
    }
}

