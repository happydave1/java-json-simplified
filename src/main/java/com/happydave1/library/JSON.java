package com.happydave1.library;

import java.lang.reflect.Field;

public class JSON {
    
    private Object obj;
 
    public JSON(Object obj) {
        this.obj = obj;
    }

    private String stringify() throws IllegalAccessException {
        // produce a string representing the object in json notation
        String json = "{";
        int numFields = this.obj.getClass().getDeclaredFields().length;
        int counter = 0;
        
        for (Field field : this.obj.getClass().getDeclaredFields()) {
            field.setAccessible(true); // access private fields
            Object val = field.get(this.obj);
            json += field.getName() + ":" + val;
            if (counter + 1 < numFields) {
                counter++;
                json += ",";
            }
        }

        json += "}";
        return json;
    }

    @Override
    public String toString() {
        try {
            return this.stringify();
        } catch (IllegalAccessException e) {
            System.out.println(e);
            return null;
        }
    }

    public Object getObject() {
        return this.obj;
    }

    public void setObject(Object object) {
        this.obj = object;
    }

    // driver code
    // public static void main(String[] args) {
    //     Task testTask = new Task(1, "wash dishes");
    //     JSON testJson = new JSON(testTask);
    //     try {
    //         System.out.println(testJson.stringify());
    //     } catch (IllegalAccessException e) {
    //         System.out.println(e);
    //     } 
        
    // }

}
