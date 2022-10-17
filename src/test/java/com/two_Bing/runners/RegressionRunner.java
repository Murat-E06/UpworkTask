package com.two_Bing.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
        },
        features ={"src/test/resources/features"},
        glue ={"com/two_Bing/step_definitions"},
        dryRun = false,
        tags = ""
)

public class RegressionRunner {
}
