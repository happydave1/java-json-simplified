package com.happydave1.library;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.commons.io.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class MainTest {

    Task task;
    Path testPath;
    String pathNameToTestJson;

    @BeforeEach
    public void createJsonFilesAndJavaObjects() {
        task = new Task(1, "wash dishes");
        testPath = Paths.get("target\\outputs\\json\\test.json");
        pathNameToTestJson = "target\\outputs\\json\\test.json";
    }

    @Test
    public void checkJsonCreation() {
        // test with toy POJO
        JSON testJson = new JSON(task); 
        assertTrue(testJson.getObject() == task);
    }

    // check constructor for JSONFile(Path, Object)
    @Test
    public void checkJsonFileCreation() throws IOException {

        JSON testTaskJson = new JSON(task);
        JSONFile testJsonFile = new JSONFile(testPath, testTaskJson);
        
        File tasksFile = new File("target\\outputs\\json\\tasks.json");
        File testFile = new File(pathNameToTestJson);
        assertTrue(FileUtils.contentEquals(tasksFile, testFile));
    }

    
}
