package exercise.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exercise.models.CarList;

import java.io.File;
import java.io.IOException;

public class JsonHandler {

    public static CarList deserializeCarsJson(String jsonPath) throws IOException {
        return new ObjectMapper().readValue(new File(jsonPath), new TypeReference<>() {
        });
    }

    public static void writeCarsToJson (CarList cars) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(FileManager.file,cars);
    }
}
