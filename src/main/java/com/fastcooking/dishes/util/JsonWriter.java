package com.fastcooking.dishes.util;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.fastcooking.dishes.exception.InvalidTypeException;

public class JsonWriter {
    
    public String toJson (Object element){

        if (element == null) return "null";

        if (element instanceof Boolean) {
            return (String)element;
        }

        if (element instanceof Number number) {
            if (Double.isFinite(number.doubleValue()) && !Double.isNaN(number.doubleValue())) {
                return number.toString();
            }
        }

        if (element instanceof String text) {

            StringBuilder sb = new StringBuilder();

                sb.append('"');
                for(char c : text.toCharArray()){
                    if(c == '\"') continue;
                    else if(c == '\\') continue;
                    else if(c == '\\') continue;
                    else if(c == '\n') continue;
                    else if(c == '\r') continue;
                    else if(c == '\t') continue;
                    else if(c == '\b') continue;
                    else if(c == '\f') continue;
                }
                sb.append('"');

            return sb.toString();
        }

        if(element instanceof Collection<?> elementCollection){

            StringBuilder sb = new StringBuilder();

            sb.append("[");

            sb.append(
                elementCollection.stream()
                    .map(o -> toJson(o))
                    .collect(Collectors.joining(","))
            );

            sb.append("]");
        }

        if(element instanceof Map<?,?> elementMap){
            
            StringBuilder sb = new StringBuilder();

            sb.append("{");

            int itemNum = 0;
            for(Entry<?,?> entry : elementMap.entrySet()){

                if(itemNum != 0) sb.append(",");
                sb.append(toJson(entry.getKey()));
                sb.append(":");
                sb.append(toJson(entry.getValue()));   
                sb.append("\n");

                itemNum++;
            }

            sb.append("}");
        }

        throw new InvalidTypeException("Invalid Type");
    }
}
