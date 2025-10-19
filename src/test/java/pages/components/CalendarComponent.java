package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
public class CalendarComponent {

    private SelenideElement  dateOfBirthInput = $("#dateOfBirthInput"),
    yearLocator = $(".react-datepicker__year-select"),
    monthLocator = $(".react-datepicker__month-select");
    private String dayLocator = ".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)";


    public CalendarComponent setBirthday(String year, String month, String day) {
        dateOfBirthInput.click();
        yearLocator.selectOption(year);

        monthLocator.click();
        monthLocator.selectOption(month);
        $(String.format(dayLocator, day)).click();
        return this;
    }
}
