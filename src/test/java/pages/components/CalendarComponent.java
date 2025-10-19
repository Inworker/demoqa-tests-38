package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
public class CalendarComponent {

    private SelenideElement  dateOfBirthInput = $("#dateOfBirthInput"),
    yearLocator = $(".react-datepicker__year-select"),
    monthLocator = $(".react-datepicker__month-select"),
    dayLocator = $(".react-datepicker__day--007");
    public CalendarComponent setBirthday(String year, String month) {
        dateOfBirthInput.click();
        yearLocator.selectOption(year);

        monthLocator.click();
        monthLocator.selectOption(month);

        dayLocator.click();
        return this;
    }
}
