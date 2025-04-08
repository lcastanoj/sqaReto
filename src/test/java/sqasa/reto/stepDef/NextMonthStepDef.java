package sqasa.reto.stepDef;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import sqasa.reto.questions.ValidationDate;
import sqasa.reto.task.OpenBrowserTask;
import sqasa.reto.task.SelectTheNextMonthDayTask;
import sqasa.reto.utils.DriverFactory;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.equalTo;
import static sqasa.reto.interfaces.JQueryDataPickerUI.DATE_INPUT;

public class NextMonthStepDef {
    @Before
    public void setUp() {
        setTheStage(new OnlineCast());

        WebDriver customDriver = DriverFactory.getDriver();
        theActorCalled("user").whoCan(BrowseTheWeb.with(customDriver));
    }

    @Given("I open the jQuery DatePicker page")
    public void iOpenTheJQueryDatePickerPage() {
        theActorInTheSpotlight().wasAbleTo(
                OpenBrowserTask.url("https://jqueryui.com/datepicker/")
        );
    }

    @When("I select the {string} of the next month")
    public void iSelectTheOfTheNextMonth(String day) {
        theActorInTheSpotlight().attemptsTo(SelectTheNextMonthDayTask.button(day));
    }

    @Then("I should see the selected {string} in the date selection field")
    public void iShouldSeeTheSelectedInTheDateSelectionField(String date) {
        theActorInTheSpotlight().should(
                seeThat("the selected date", ValidationDate.from(DATE_INPUT),
                        equalTo(date))
        );
    }


}
