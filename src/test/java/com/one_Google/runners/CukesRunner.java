package com.one_Google.runners;

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
        glue ={"com/one_Google/step_definitions"},
        dryRun = false,
        tags = "@google"
)

public class CukesRunner {

}

