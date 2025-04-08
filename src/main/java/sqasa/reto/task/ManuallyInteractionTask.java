package sqasa.reto.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static sqasa.reto.interfaces.JQueryDataPickerUI.DATE_INPUT;
import static sqasa.reto.interfaces.JQueryDataPickerUI.FIRST_IFRAME;

public class ManuallyInteractionTask implements Task {
    private final String date;

    public ManuallyInteractionTask(String date) {
        this.date = date;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Switch.toFrame(FIRST_IFRAME.resolveFor(actor)),
                Enter.theValue(date).into(DATE_INPUT)
        );
    }

    public static ManuallyInteractionTask button(String date) {
        return instrumented(ManuallyInteractionTask.class, date);
    }
}
