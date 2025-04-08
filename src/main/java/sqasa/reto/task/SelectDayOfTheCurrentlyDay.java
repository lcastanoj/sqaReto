package sqasa.reto.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static sqasa.reto.interfaces.JQueryDataPickerUI.*;

public class SelectDayOfTheCurrentlyDay implements Task {
    private final String day;

    public SelectDayOfTheCurrentlyDay(String day) {
        this.day = day;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Switch.toFrame(FIRST_IFRAME.resolveFor(actor)),
                Click.on(DATE_INPUT),
                WaitUntil.the(DAY_SELECTION.of(day), isVisible()).forNoMoreThan(5).seconds(),
                Click.on(DAY_SELECTION.of(day))
        );
    }

    public static SelectDayOfTheCurrentlyDay button(String day) {
        return instrumented(SelectDayOfTheCurrentlyDay.class, day);
    }
}
