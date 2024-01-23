package lesson_19.Parsing_from_Object_to_JSONfile_Jackson.Serialization_to_Json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson_19.Parsing_from_Object_to_JSONfile_Jackson.Parsers.ParseStation;

import java.io.FileWriter;
import java.io.IOException;

public class StationToJson {

    public void stationToJson (ParseStation parseStation){

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter()     // для орматирования json с отступами
                    .withRootName("Stations")                               // для задания имени листа
                    .writeValueAsString(parseStation.getStationList(parseStation.numberStation(), parseStation.nameStation()));
            try {
                FileWriter fileWriter = new FileWriter("/Users/АВС/IdeaProjects/TestMaven/src/main/java/lesson_17/Parsing_from_Object_to_JSONfile_Jackson/data/Station.json");
                fileWriter.write(json);
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
