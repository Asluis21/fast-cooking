package com.fastcooking.dishes.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JsonWritterTest {

    private JsonWriter jsonWriter;

    @BeforeEach 
    void setUp(){
        this.jsonWriter = new JsonWriter();
    }

    @Test 
    void checkNullInJson(){
        assertEquals("null", jsonWriter.toJson(null));
    }

    @Test 
    void checkBooleanTypeInJSon(){
        Boolean booleanAttribute = true;
        assertEquals("true", jsonWriter.toJson(booleanAttribute));
    }
    
    @Test 
    void checkIntegerTypeInJSon(){
        Integer integerAttribute = 100;
        assertEquals("100", jsonWriter.toJson(integerAttribute));
    }
    
    @Test 
    void checkDoubleTypeInJSon(){
        Double doubleAttribute = 100.0;
        assertEquals("100.0", jsonWriter.toJson(doubleAttribute));
    }
    
    @Test 
    void checkFloatTypeInJSon(){
        Float floatAttribute = 100.0F;
        assertEquals("100.0", jsonWriter.toJson(floatAttribute));
    }
    
    @Test 
    void checkShortTypeInJSon(){
        Short ShortrAttribute = 1;
        assertEquals("1", jsonWriter.toJson(ShortrAttribute));
    }
    
    @Test 
    void checkByteTypeInJSon(){
        Short btyeAttribute = 1;
        assertEquals("1", jsonWriter.toJson(btyeAttribute));
    }

    @Test 
    void checkStringTypeInJson(){
        String text = "El cliente dijo:\"Hola Mundo\"";
        assertEquals("\"El cliente dijo:\\\"Hola Mundo\\\"\"", jsonWriter.toJson(text));
    }
    
    @Test 
    void checkListTypeInJson(){
        List<Object> listObjects = List.of(1, 100.2, "El cliente dijo:\"Hola Mundo\"");
        assertEquals("[1, 100.2, \"El cliente dijo:\\\"Hola Mundo\\\"\"]", jsonWriter.toJson(listObjects));
    }

    @Test 
    void checkArrayTypeInJson(){
        Object[] listObjects = {1, 100.2, "El cliente dijo:\"Hola Mundo\""};
        assertEquals("[1, 100.2, \"El cliente dijo:\\\"Hola Mundo\\\"\"]", jsonWriter.toJson(listObjects));
    }

    @Test 
    void checkMapTypeInJson(){
        Map<String, Object> mapObjects = new LinkedHashMap<>(){{
            put("key1", "value1");
            put("key2", 100);
            put("key3", List.of(1, "Hola\tworld", true));
        }};

        assertEquals(
        """ 
        {
          "key1" : "value1",
          "key2" : 100,
          "key3" : [1, "Hola world", true] 
        }""", jsonWriter.toJson(mapObjects));
    }
}
