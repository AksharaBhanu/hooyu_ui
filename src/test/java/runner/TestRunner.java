package runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import stepdefinitions.BaseUtils;
import utils.GenericUtils;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"stepdefinitions"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		snippets = SnippetType.CAMELCASE,
		dryRun = false
)
public class TestRunner {

	@BeforeClass
	public static void beforeRun() {
		System.out.println("---------Before Any scenario runs -----------");
		String env = GenericUtils.getProperties("global","ENV");
		String url = GenericUtils.getProperties(env,"URL");
		String browser = GenericUtils.getProperties(env,"BROWSER");
		long duration =Long.parseLong(GenericUtils.getProperties(env,"DURATION"));
		
		BaseUtils.appUrl = url;
		BaseUtils.browser=browser;
		BaseUtils.duration = duration;
	}
}


