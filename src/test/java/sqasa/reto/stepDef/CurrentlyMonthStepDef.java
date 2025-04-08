package sqasa.reto.stepDef;

import io.cucumber.java.en.When;
import sqasa.reto.task.SelectDayOfTheCurrentlyDay;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CurrentlyMonthStepDef {
    @When("I select the {string} of the current month")
    public void iSelectTheOfTheCurrentMonth(String day) {
        theActorInTheSpotlight().attemptsTo(SelectDayOfTheCurrentlyDay.button(day));
    }
}
