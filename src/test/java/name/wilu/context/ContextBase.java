package name.wilu.context;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

import java.util.UUID;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public abstract class ContextBase {

    @Before
    public void setUp() {
        Service service = mock(Service.class);
        when(service.get(any()))
                .then(i -> new Entry()
                        .setId(UUID.fromString(i.getArguments()[0].toString()))
                        .setName("some-name"));
        when(service.add(any())).thenCallRealMethod();
        RestAssuredMockMvc.standaloneSetup(new Controller(service));
    }

    public void name(String name) {
        assert "some-name".equals(name) : "The name is wrong!";
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
    }

}
