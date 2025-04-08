package sqasa.reto.stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sqasa.reto.task.ManuallyInteractionTask;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.junit.Assert.assertTrue;
import static sqasa.reto.interfaces.JQueryDataPickerUI.DATE_INPUT;

public class ManuallyInteractionStepDef {

    @When("I try to type a {string} manually into the date field")
    public void iTryToTypeAManuallyIntoTheDateField(String date) {
        theActorInTheSpotlight().attemptsTo(ManuallyInteractionTask.button(date));
    }

    @Then("the date field should still be empty")
    public void theDateFieldShouldStillBeEmpty() {
        String value = String.valueOf(DATE_INPUT);
        assertTrue("The field should remain empty", value.isEmpty());
    }
}
