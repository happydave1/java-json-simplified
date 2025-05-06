package com.happydave1.library;
import java.util.HashMap;
import java.nio.file.Paths;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        // create a java hashmap
        HashMap<String, String> testObj = new HashMap<>();

        // fill with toy data
        testObj.put("Token", "123456789");
        testObj.put("Error", "No error!");

        // link it with the JSONObject
        Path jsonpath = Paths.get("./test.json");

        // use case 1: pass the path and hashmap
        JSONFile jsonobject = new JSONFile(jsonpath, testObj);

        // use case 2: pass the path and add object later
        JSONFile jsonobject2 = new JSONFile(jsonpath);
        jsonobject2.setObject(testObj);

        // use case 3: must efficiently add key, value pairs to the file
        String testKey = "Author";
        String testValue = "happydave1";
        jsonobject.put(testKey, testValue);

    }
}

