package runner;


import io.cucumber.testng.*;

@CucumberOptions(features="src/test/resources/features/kapoorlamps.feature", monochrome = true,glue= {"steps"},

plugin= {"html:target/cucumber-reports/cucumber-html-reports.html","pretty"})
public class RunCuke extends AbstractTestNGCucumberTests{
	


	
	

}
