package main;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TestWebApp {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void testGetAddressBook_none() throws Exception {
        this.mockMvc.perform(get("/addressbooks"))
                .accept(MediaType.APPLICATION_JSON)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    @Order(2)
    public void testCreateAddressBook() throws Exception {
        this.mockMvc.perform(post("/addressbook"))
                .accept(MediaType.APPLICATION_JSON)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1, \"buddies\":[]}")));
    }

    @Test
    @Order(3)
    public void testGetAddressBook() throws Exception {
        this.mockMvc.perform(get("/addressbooks"))
                .accept(MediaType.APPLICATION_JSON)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1, \"buddies\":[]}")));
    }

    @Test
    @Order(3)
    public void testGetAddressBook() throws Exception {
        this.mockMvc.perform(get("/addressbooks"))
                .accept(MediaType.APPLICATION_JSON)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1, \"buddies\":[]}")));
    }
}
