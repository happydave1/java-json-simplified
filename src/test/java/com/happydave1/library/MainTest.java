package com.happydave1.library;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class MainTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void checkJsonCreation() {
        // test with toy POJO
        Task task = new Task(1, "wash dishes");
        JSON testJson = new JSON(task); 
        assertTrue(testJson.getObject() == task);
    }
}
