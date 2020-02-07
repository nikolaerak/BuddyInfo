package main;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;


@SpringBootTest
public class SmokeTest {

    @Autowired
    private Controller controller;

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(controller);
    }
}