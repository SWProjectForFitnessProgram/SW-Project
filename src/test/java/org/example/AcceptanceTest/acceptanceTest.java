package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features/Admin/add.feature",
    plugin = {"html:target/cucumber/wikipedia.html"},
    monochrome = true,
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    glue = {"org.example.AcceptanceTest"}
)


public class acceptanceTest {

}
