package ucu.edu.ua.taskthree;
import org.json.JSONObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class PDLReaderSubsystem {
    private final String apiKey;

    public PDLReaderSubsystem(String apiKey) {
        this.apiKey = apiKey;
    }

    public JSONObject getCompanyInfo(String website) throws IOException {
        URL url = new URL(
        "https://api.peopledatalabs.com/v5/company/enrich?website=" 
        + website);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Api-Key", apiKey);
        connection.connect();
        String response = new Scanner(connection.getInputStream()).
        useDelimiter("\\Z").next();
        return new JSONObject(response);
    }
}
