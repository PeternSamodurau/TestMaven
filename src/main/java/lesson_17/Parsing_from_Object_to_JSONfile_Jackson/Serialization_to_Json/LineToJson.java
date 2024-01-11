package lesson_17.Parsing_from_Object_to_JSONfile_Jackson.Serialization_to_Json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson_17.Parsing_from_Object_to_JSONfile_Jackson.Parsers.ParseLine;
import lesson_17.Parsing_from_Object_to_JSONfile_Jackson.Parsers.ParseStation;

import java.io.FileWriter;
import java.io.IOException;

public class LineToJson {

    public void lineToJson (ParseLine parseLine){

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter()     // для фрматирования json с отступами
                    .withRootName("Lines")                               // для задания имени листа
                    .writeValueAsString(parseLine.getLineList(parseLine.nameLine()));
            try {
                FileWriter fileWriter = new FileWriter("/Users/АВС/IdeaProjects/TestMaven/src/main/java/lesson_17/Parsing_from_Object_to_JSONfile_Jackson/data/Line.json");
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
