package com.happydave1.library;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;


public class JSONFile {

    private Path jsonFilePath;
    private JSON jsonObj;

    public JSONFile(Path jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }
    
    public JSONFile(Path jsonFilePath, JSON jsonObj) {
        this.jsonFilePath = jsonFilePath;
        this.jsonObj = jsonObj;
        try {
            writeObj(this.jsonObj);
        } catch (IOException e) {
            System.out.println(e);
        } 
        
    }

    public void put(String key, String value) {
        // TODO: implement
    }

    public void remove(String key) {

    }

    public void update(String key) {

    }

    public void setObj(JSON jsonObj) {
        // TODO: implement
    }

    public JSON getObj() {
        return this.jsonObj;
    }

    private void writeObj(JSON jsonObj) throws IOException {
        Files.writeString(this.jsonFilePath, jsonObj.toString(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
    }

    public static void main(String[] args) throws IOException {
        // driver code

        Path testPath = Paths.get("target\\outputs\\json\\test.json");
        Task testTask = new Task(1, "do dishes");
        JSON testJsonObject = new JSON(testTask);
        JSONFile testFile = new JSONFile(testPath, testJsonObject); // should automatically instantiate the file
    }
}
