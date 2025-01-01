package org.example.AcceptanceTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import io.cucumber.spring.SpringFactory;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        objectFactory = io.cucumber.picocontainer.PicoFactory.class,
//        objectFactory= SpringFactory.class ,
        features = "src/test/java/Features",
//        plugin = {"html:pages/cucumber.html"},
//    monochrome = true,
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    glue = {"org.example.AcceptanceTest"}
)


public class acceptanceTest {

}
