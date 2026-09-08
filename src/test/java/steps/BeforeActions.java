package steps;

import io.cucumber.java.Before;
import utility.SeleniumDriver;

public class BeforeActions {
@Before
	public void setup() {
		SeleniumDriver.setupDriver();
	}
}
