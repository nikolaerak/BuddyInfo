import main.AddressBookController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;


@SpringBootTest
public class SmokeTest {

    @Autowired
    private AddressBookController addressBookController;

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(addressBookController);
    }
}