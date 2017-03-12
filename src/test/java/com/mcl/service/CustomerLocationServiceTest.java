import static org.junit.Assert.assertTrue;
import org.junit.rules.ExpectedException;
import org.junit.Test;
import org.junit.Rule;
import org.junit.BeforeClass;

import com.mcl.service.CustomerLocationService;
import com.mcl.exceptions.FailureException;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class CustomerLocationServiceTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void givenCustomerIdTheLocationIdReturned() throws FailureException {
		CustomerLocationService location = new CustomerLocationService();

		String myLocation = location.findLocationIdByCustomerId("test.customer");
		assertTrue(myLocation.contains("London"));
	}

	@Test
	public void customerIdMustNotBeNull() throws FailureException {
	    CustomerLocationService location = new CustomerLocationService();
	    exception.expect(FailureException.class);
	    String myLocation = location.findLocationIdByCustomerId(null);
	}

	@Test
	public void customerIdMustNotBeEmpty() throws FailureException {
	    CustomerLocationService location = new CustomerLocationService();
	    exception.expect(FailureException.class);
	    String myLocation = location.findLocationIdByCustomerId("");
	}

	@Test
	public void customerIdMustNotBeBlank() throws FailureException {
	    CustomerLocationService location = new CustomerLocationService();
	    exception.expect(FailureException.class);
	    String myLocation = location.findLocationIdByCustomerId(" ");
	}

}