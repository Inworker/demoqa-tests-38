package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FinalTableComponent {
    private SelenideElement title = $("#example-modal-sizes-title-lg"),
                            resultTable = $(".table-responsive"),
                            close = $("#closeLargeModal");

    public FinalTableComponent closeResultTable(){
        close.click();
        return this;
    }

    public FinalTableComponent checkTitle(){
        title.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public FinalTableComponent checkTableData(String key, String value){
        resultTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public FinalTableComponent checkNotVisibleTable()
    {
        title.shouldNot(exist);
        return this;
    }

}
