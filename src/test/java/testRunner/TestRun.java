package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features=".//Features//Customer.feature",
        glue="stepDefinitions",
        //tags={"@sanity"},
        dryRun=false,   //Dry-run is used to compile feature files and step definitions in cucumber.
        monochrome=true,  //monochrome is used to display console output in color format or not
        plugin= {"pretty","html:Reports"}
)
public class TestRun {
}