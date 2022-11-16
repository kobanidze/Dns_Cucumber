package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/scenarios",
        glue = "ru.dns.shop.framework.steps",
        plugin = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        tags = "@success"
)
public class CucumberRunnerTest {
}
