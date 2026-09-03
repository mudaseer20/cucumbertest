package runner;
import io.cucumber.testng.*;

@CucumberOptions(features="src/test/resources/features/almlogin.feature",  monochrome = true,tags="@staging and not @prod",glue= {"steps"},


plugin= {"html:target/cucumber-reports/cucumber-html-reports.html","pretty"})
public class RunCuke extends AbstractTestNGCucumberTests{

}
