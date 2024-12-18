package org.example.AcceptanceTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        plugin = {"html:pages/cucumber.html"},
//    monochrome = true,
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    glue = {"org.example.AcceptanceTest"}
)


public class acceptanceTest {

}
