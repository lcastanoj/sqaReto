package sqasa.reto.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "sqasa.reto.stepDef",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}