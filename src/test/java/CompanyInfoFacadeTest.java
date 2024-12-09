import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import java.io.IOException;
import ucu.edu.ua.taskthree.PDLReaderSubsystem;
import ucu.edu.ua.taskthree.WebScraperSubsystem;
import ucu.edu.ua.taskthree.BrandfetchSubsystem;
import ucu.edu.ua.taskthree.CompanyInfoFacade;
import ucu.edu.ua.taskthree.Company;


class CompanyInfoFacadeTest {

    @Test
    void testPDLReaderSubsystem() throws Exception {
        String mockResponse = 
        "{\"name\": \"Test Company\", \"description\": \"A sample company\"}";
        PDLReaderSubsystem pdlReader = Mockito.mock(
            PDLReaderSubsystem.class);
        Mockito.when(pdlReader.getCompanyInfo("test.com"))
        .thenReturn(new JSONObject(mockResponse));
        JSONObject response = pdlReader.getCompanyInfo("test.com");
        Assertions.assertEquals("Test Company", 
        response.getString("name"));
        Assertions.assertEquals("A sample company", 
        response.getString("description"));
    }

    @Test
    void testWebScraperSubsystem() {
        WebScraperSubsystem scraper = new WebScraperSubsystem();
        String scrapedDescription = scraper
        .scrapeDescription("test.com");
        Assertions.assertNotNull(scrapedDescription);
        Assertions.assertTrue(scrapedDescription
        .contains("test.com"));
    }

    @Test
    void testBrandfetchSubsystem() {
        BrandfetchSubsystem brandfetch = new BrandfetchSubsystem();
        String logo = brandfetch.fetchLogo("test.com");

        Assertions.assertNotNull(logo);
        Assertions.assertEquals("https://brandfetch.com/logo/test.com", logo);
    }

    @Test
    void testCompanyInfoFacade() throws IOException, org.json.JSONException {
        PDLReaderSubsystem mockPDL = 
        Mockito.mock(PDLReaderSubsystem.class);
        WebScraperSubsystem mockScraper = 
        Mockito.mock(WebScraperSubsystem.class);
        BrandfetchSubsystem mockBrandfetch = 
        Mockito.mock(BrandfetchSubsystem.class);

        Mockito.when(mockPDL.getCompanyInfo("test.com"))
            .thenReturn(new JSONObject(
                "{\"name\": \"Mock Company\", \"description\": \"Mock description\"}"));
                Mockito.when(mockScraper.scrapeDescription("test.com"))
                .thenReturn("Fallback description");
                Mockito.when(mockBrandfetch.fetchLogo("test.com"))
                .thenReturn("https://brandfetch.com/logo/test.com");

        CompanyInfoFacade facade = new CompanyInfoFacade("dummyApiKey") {
            @Override
            public Company getCompanyDetails(String website) {
                return new Company("Mock Company",
                 "Mock description",
                 "https://brandfetch.com/logo/test.com");
            }
        };

        Company company = facade.getCompanyDetails("test.com");
        Assertions.assertEquals("Mock Company", company.getName());
        Assertions.assertEquals("Mock description", company.getDescription());
        Assertions.assertEquals("https://brandfetch.com/logo/test.com", company.getLogo());
    }
}