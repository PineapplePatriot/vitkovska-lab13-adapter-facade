import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ucu.edu.ua.tasktwo.Authorization;
import ucu.edu.ua.tasktwo.Database;

class AuthorizationTest {
    private Authorization auth;
    private Database db;

    @BeforeEach
    void setUp() {
        auth = new Authorization();
        db = new Database();
    }

    @Test
    void testLoginSuccess() {
        Assertions.assertTrue(auth.login(db), 
        "Login should succeed when using the adapter.");
    }
}
