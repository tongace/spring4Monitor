package com.dxc.application.firstfunction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FirstControllerTest {
    private FirstController firstController;

    @Test
    public void test_hello_api_from_FirstController() {
        firstController = new FirstController();
        String response = firstController.helloAPI("Chairat");
        String expected = "hello! Chairat";
        assertEquals(expected, response);
    }
}