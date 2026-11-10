package com.fastcooking.dishes.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.fastcooking.dishes.exception.InvalidTypeException;

public class JsonWriter {
    
    public String toJson (Object element){

        if (element == null) return "null";

        if (element instanceof Boolean) {
            return formatBoolean(element);
        }

        if (element instanceof Number number) {
            return formatNumber(number);
        }

        if (element instanceof String text) {
            return formatString(text);
        }
        
        if (element instanceof Enum enumText) {
            return formatString(enumText.toString());
        }

        if(element instanceof Collection<?> elementCollection){
            return formatCollection(elementCollection);
        }
        
        if(element.getClass().isArray()){
            return formatArray(element);
        }


        if(element instanceof Map<?,?> elementMap){
            return formatMap(elementMap);
        }

        throw new InvalidTypeException("Invalid Type");
    }

    private String formatBoolean(Object boolObject){
        return boolObject.toString();
    }
  
    private String formatNumber(Number num){
        if (Double.isFinite(num.doubleValue()) && !Double.isNaN(num.doubleValue())) {
            return num.toString();
        }

        throw new InvalidTypeException("Invalid Type");
    }

    private String formatArray(Object objectArray){

        StringBuilder sb = new StringBuilder();

        sb.append("[");

        int arrayLenght = Array.getLength(objectArray);

        for (int i = 0; i < arrayLenght; i++) {
            if(i != 0) sb.append(", ");
            sb.append(toJson(Array.get(objectArray, i)));
        }

        sb.append("]");

        return sb.toString();
    }

    private String formatCollection(Collection<?> c){
            
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        sb.append(
            c.stream()
                .map(o -> toJson(o))
                .collect(Collectors.joining(", "))
        );

        sb.append("]");

        return sb.toString();
    }

    private String formatString(String text){
        StringBuilder sb = new StringBuilder();

        sb.append('"');
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
                
                // Make coma character (") into a special symbol -> Name: \"Carlos
                case '"': 
                    sb.append("\""); break;
                
                /** 
                 * Tab Name:\tCarlos
                 * Result:
                 * Name:    Carlos
                */
                case '\t': 
                    sb.append("\t"); break;
                case '\\':
                    sb.append("\\\\"); break;
                
                /**
                 * Line feed: "Hello\nWorld" 
                 * Result:
                 * Hello 
                 * World
                 * 
                */
                case '\n': 
                    sb.append("\\n"); break;

                /**
                 * Carriage return: Texto\rBorra
                 * Result: Borra
                 * Borra smashed Texto bc it returned at the begining 
                 */
                case '\r': 
                    sb.append("\\r"); break;
                /**
                 * Backspace: Holaa\b
                 * Result: Hola
                 * \b removed one "a" 
                 */

                case '\b': // Retroceso
                    sb.append("\\b"); break;
                /**
                 * Form feed: Hoja1\fHoja2
                 * Result: A physical printer would cut paper here 
                 * and send "Hoja 2" to new page
                 */
                case '\f': 
                    sb.append("\\f"); break;
                default: 
                // Safely discard any other invisible ASCII control characters (0 to 31)
                    if (c < ' ') sb.append(String.format("\\u%04x", (int)c));
                    sb.append(c); 
                break;                        
            }

        }
        
        sb.append('"');

        return sb.toString().trim();
    }

    private String formatMap(Map<?,?> map){
        
        StringBuilder sb = new StringBuilder();

        sb.append("{");

        boolean first = true;
        
        for(Entry<?,?> entry : map.entrySet()){

            if(!first) sb.append(",");
            sb.append("\n");
            sb.append("  " + formatString(String.valueOf(entry.getKey())));
            sb.append(" : ");
            sb.append(toJson(entry.getValue()));
            first = false;
        }

        sb.append('}');
        return sb.toString().trim();
    }
}


