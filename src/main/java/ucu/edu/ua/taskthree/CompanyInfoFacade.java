package ucu.edu.ua.taskthree;
import org.json.JSONObject;

public class CompanyInfoFacade {
    private final PDLReaderSubsystem pdlReader;
    private final WebScraperSubsystem webScraper;
    private final BrandfetchSubsystem brandfetch;

    public CompanyInfoFacade(String pdlApiKey) {
        this.pdlReader = new PDLReaderSubsystem(pdlApiKey);
        this.webScraper = new WebScraperSubsystem();
        this.brandfetch = new BrandfetchSubsystem();
    }

    public Company getCompanyDetails(String website) {
        String name = "";
        String description = "";
        String logo = "";
    
        try {
            JSONObject pdlData = pdlReader.getCompanyInfo(website);
            name = pdlData.optString("name", "Unknown Company");
            description = pdlData.optString("description",
             "No description available");
        } catch (Exception e) {
            System.err.println("PDL Error: " + e.getMessage());
        }
    
        if (description.isEmpty()) {
            description = webScraper.scrapeDescription(website);
        }
    
        logo = brandfetch.fetchLogo(website);
        return new Company(name, description, logo);
    }    
}
