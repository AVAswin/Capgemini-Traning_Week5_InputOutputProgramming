import com.google.gson.*;
import java.io.*;
import java.util.*;

public class IPLDataCensorship {

    // Function to censor the team name
    public static String censorTeamName(String teamName) {
        // List of teams to be censored
        List<String> teamsToCensor = Arrays.asList("Mumbai Indians", "Royal Challengers Bangalore", "Delhi Capitals", "Chennai Super Kings");

        // Check if the team name is in the list of teams to censor
        for (String team : teamsToCensor) {
            if (teamName.contains(team)) {
                return teamName.replace(team.split(" ")[0], team.split(" ")[0] + " ***");
            }
        }
        return teamName; // If not in the list, return the team name as it is
    }

    // Function to censor the player of the match name
    public static String censorPlayerOfMatch(String playerName) {
        return "REDACTED";
    }

    // Censor the JSON input
    public static JsonArray censorJson(JsonArray inputJson) {
        for (JsonElement matchElement : inputJson) {
            JsonObject match = matchElement.getAsJsonObject();
            
            // Censor team names
            match.addProperty("team1", censorTeamName(match.get("team1").getAsString()));
            match.addProperty("team2", censorTeamName(match.get("team2").getAsString()));
            
            // Censor player of the match
            match.addProperty("player_of_match", censorPlayerOfMatch(match.get("player_of_match").getAsString()));
        }
        return inputJson;
    }

    // Censor the CSV input
    public static List<List<String>> censorCsv(List<List<String>> inputCsv) {
        for (List<String> row : inputCsv) {
            row.set(1, censorTeamName(row.get(1)));  // team1 column
            row.set(2, censorTeamName(row.get(2)));  // team2 column
            row.set(6, censorPlayerOfMatch(row.get(6)));  // player_of_match column
        }
        return inputCsv;
    }

    // Save censored JSON to a file
    public static void saveJsonOutput(JsonArray data, String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(data, writer);
        }
    }

    // Save censored CSV to a file
    public static void saveCsvOutput(List<List<String>> data, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (List<String> row : data) {
                writer.write(String.join(",", row));
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Example JSON Input (before censorship)
        String jsonInput = "[\n" +
                "  {\n" +
                "    \"match_id\": 101,\n" +
                "    \"team1\": \"Mumbai Indians\",\n" +
                "    \"team2\": \"Chennai Super Kings\",\n" +
                "    \"score\": {\n" +
                "      \"Mumbai Indians\": 178,\n" +
                "      \"Chennai Super Kings\": 182\n" +
                "    },\n" +
                "    \"winner\": \"Chennai Super Kings\",\n" +
                "    \"player_of_match\": \"MS Dhoni\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"match_id\": 102,\n" +
                "    \"team1\": \"Royal Challengers Bangalore\",\n" +
                "    \"team2\": \"Delhi Capitals\",\n" +
                "    \"score\": {\n" +
                "      \"Royal Challengers Bangalore\": 200,\n" +
                "      \"Delhi Capitals\": 190\n" +
                "    },\n" +
                "    \"winner\": \"Royal Challengers Bangalore\",\n" +
                "    \"player_of_match\": \"Virat Kohli\"\n" +
                "  }\n" +
                "]";

        // Example CSV Input (before censorship)
        String csvInput = "match_id,team1,team2,score_team1,score_team2,winner,player_of_match\n" +
                "101,Mumbai Indians,Chennai Super Kings,178,182,Chennai Super Kings,MS Dhoni\n" +
                "102,Royal Challengers Bangalore,Delhi Capitals,200,190,Royal Challengers Bangalore,Virat Kohli";

        // Parse the JSON input
        JsonArray jsonArray = JsonParser.parseString(jsonInput).getAsJsonArray();

        // Parse the CSV input
        List<List<String>> csvList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new StringReader(csvInput));
        String line;
        while ((line = reader.readLine()) != null) {
            csvList.add(Arrays.asList(line.split(",")));
        }

        // Apply censorship to JSON and CSV data
        JsonArray censoredJson = censorJson(jsonArray);
        List<List<String>> censoredCsv = censorCsv(csvList);

        // Save censored data to output files
        saveJsonOutput(censoredJson, "censored_output.json");
        saveCsvOutput(censoredCsv, "censored_output.csv");

        System.out.println("Censorship applied. Output saved to censored_output.json and censored_output.csv.");
    }
}
