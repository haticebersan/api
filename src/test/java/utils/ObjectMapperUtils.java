package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojos.JsonPlaceHolderPojo;

public class ObjectMapperUtils {
    //This method will accept String Json data as first parameter and convert it into second parameter's data type
    public static <T> T convertJsonToJava( String stringJson, Class<T> tClass){//Generic Method
        try {
            return   new ObjectMapper().readValue(stringJson, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
