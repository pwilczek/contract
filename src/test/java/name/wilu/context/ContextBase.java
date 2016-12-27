package name.wilu.context;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

public abstract class ContextBase {

	@Before
	public void setUp() {
		RestAssuredMockMvc.standaloneSetup(new Controller(new Service()));
	}

	public void name(String name) {
		assert "some-name".equals(name) : "The name is wrong!";

	}

}
