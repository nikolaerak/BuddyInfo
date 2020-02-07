import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import main.JPAApplication;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(classes={JPAApplication.class})
@AutoConfigureMockMvc
public class TestWebApp {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void testGetAddressBook_none() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/addressbooks")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    @Order(2)
    public void testCreateAddressBook() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/addressbook")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1, \"buddies\":[]}")));
    }

    @Test
    @Order(3)
    public void testGetAddressBook() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/addressbooks")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1, \"buddies\":[]}")));
    }
}
