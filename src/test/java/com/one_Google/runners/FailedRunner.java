package com.google.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features ={"@target/rerun.txt"},
        glue ={"com/one_Google/step_definitions"}
)


public class FailedRunner {
}
