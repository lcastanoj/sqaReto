package sqasa.reto.interfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class JQueryDataPickerUI {
    public static final Target FIRST_IFRAME = Target.the("IFRAME")
            .located(By.cssSelector(".demo-frame"));
    public static final Target DATE_INPUT = Target.the("INPUT")
            .located(By.id("datepicker"));
    public static final Target NEXT_MONTH_ARROW = Target.the("FLECHA MES SIGUIENTE")
            .located(By.cssSelector(".ui-datepicker-next"));
    public static final Target DAY_SELECTION = Target.the("DAY SELECTION")
            .locatedBy("//a[@data-date='{0}']");
}
