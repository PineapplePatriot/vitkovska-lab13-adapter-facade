import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ucu.edu.ua.tasktwo.Authorization;
import ucu.edu.ua.tasktwo.Database;
import ucu.edu.ua.tasktwo.ReportBuilder;

class IntegrationTest {
    @Test
    void testMainFlow() {
        Database db = new Database();
        Authorization auth = new Authorization();
        if (auth.login(db)) {
            ReportBuilder reportBuilder = new ReportBuilder(db);
            Assertions.assertNotNull(reportBuilder.getDb(),
             "ReportBuilder should contain a non-null Database instance.");
        } else {
            Assertions.fail("Authorization failed in main flow.");
        }
    }
}
