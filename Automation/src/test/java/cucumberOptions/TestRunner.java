package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(  
	    features = "src/test/java/features",
	    glue="stepDefinations",
	    //glue = "stepDefinitionPages",
	    //tags="@NiuliTest1",
	    tags= "@demoQABook",
	    //tags="@SmokeTest",
	    monochrome=true,
	    plugin= {"pretty","json:target/cucumber.json","junit:target/cukes.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		publish = true
		
		)

	    
public class TestRunner {

}
