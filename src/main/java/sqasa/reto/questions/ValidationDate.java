package sqasa.reto.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidationDate implements Question<String> {

    private final Target dateField;

    public ValidationDate(Target dateField) {
        this.dateField = dateField;
    }

    public static ValidationDate from(Target dateField) {
        return new ValidationDate(dateField);
    }

    @Override
    public String answeredBy(Actor actor) {
        return dateField.resolveFor(actor).getValue();
    }
}
