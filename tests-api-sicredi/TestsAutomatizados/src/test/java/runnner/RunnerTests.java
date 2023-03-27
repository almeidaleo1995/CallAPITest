package runnner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
        "pretty",
        "html:target/cucumber.html",
        "json:target/cucumber.json"
        },
        tags = "",
        features = "src/test/resources/features",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        stepNotifications = true,
        glue= "stepdefinitions")


public class RunnerTests {
}
