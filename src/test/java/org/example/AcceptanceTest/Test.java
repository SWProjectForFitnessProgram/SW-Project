package org.example.AcceptanceTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/Features/Client"},monochrome = true, snippets = SnippetType.CAMELCASE,
        glue = {"org.example.AcceptanceTest"})
public class Test {


}

