package com.example.demo.tests;

import com.example.demo.controllers.ApplicationCreationController;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IdCheckTest
{
    ApplicationCreationController controller = new ApplicationCreationController();

    @Test
    public void checkExistingId()
    {
        int id = 1000;
        assertEquals("Should be true", true, controller.checkCustomerId(id));
    }

    @Test
    public void checkWrongId()
    {
        int id = 5679;
        assertEquals("Should be false", false, controller.checkCustomerId(id));
    }
}
