package com.calculator.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
//                "rerun:target/rerun.txt",
//                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/calculator/step_definitions",
        dryRun = false,
        tags = "@GC-1",
        publish = false

)
public class CukesRunner {}
