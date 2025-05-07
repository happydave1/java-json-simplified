package com.happydave1.library;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.ArrayList;


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
            writeObj();
        } catch (IOException e) {
            System.out.println(e);
        } 
        
    }

    public void setObj(JSON jsonObj) {
        this.jsonObj = jsonObj;
        try {
            writeObj();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public JSON getObj() {
        return this.jsonObj;
    }

    private void writeObj() throws IOException {
        Files.writeString(this.jsonFilePath, this.jsonObj.toString(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }


}
