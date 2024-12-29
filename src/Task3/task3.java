package Task3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class task3 {
    public static void main(String[] args) throws IOException {
        Path valuesPath = Path.of("src/Task3/values.json");
        Path reportPath = Path.of("src/Task3/report.json");
        Path testsPath = Path.of("src/Task3/tests.json");
        test(testsPath,valuesPath,reportPath);
    }

    public static void test(Path testsPath, Path valuesPath, Path reportPath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode testsJson = mapper.readTree(testsPath.toFile());
        JsonNode valuesJson = mapper.readTree(valuesPath.toFile());

        Map<Integer, String> valuesMap = new HashMap<>();
        for (JsonNode valueNode : valuesJson.get("values")) {
            int id = valueNode.get("id").asInt();
            String value = valueNode.get("value").asText();
            valuesMap.put(id, value);
        }

        fill_Values(testsJson.get("tests"), valuesMap);

        mapper.writerWithDefaultPrettyPrinter().writeValue(reportPath.toFile(), testsJson);
    }

    public static void fill_Values(JsonNode testsNode, Map<Integer, String> valuesMap){
        for (JsonNode testNode : testsNode) {
            if (testNode.has("id")) {
                int id = testNode.get("id").asInt();
                if (valuesMap.containsKey(id) && testNode instanceof ObjectNode) {
                    ((ObjectNode) testNode).put("value", valuesMap.get(id));
                }
            }
            if (testNode.has("values")) {
                fill_Values(testNode.get("values"), valuesMap);
            }
        }
    }
}
