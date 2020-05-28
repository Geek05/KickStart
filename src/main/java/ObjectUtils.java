import gherkin.deps.com.google.gson.Gson;

import java.util.Objects;

public class ObjectUtils {

    public static <T> Object CloneObject(Object object, Class<T> className){
        Gson gson = new Gson();
        String jsonString = gson.toJson(object);
        T clone = gson.fromJson(jsonString, className);
        return clone;
    }
    
    public static String GetSystemProperty(String propertyName, String defaultValue){
        String propertyValue = System.getProperty(propertyName);
        if(Objects.isNull(propertyValue))
            propertyValue = System.getenv(propertyName);
        return Objects.nonNull(propertyValue) ? propertyValue : defaultValue;
    }
}
