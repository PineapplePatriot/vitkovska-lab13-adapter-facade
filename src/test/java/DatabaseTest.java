import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ucu.edu.ua.tasktwo.Database;

class DatabaseTest {
    private Database db;

    @BeforeEach
    void setUp() {
        db = new Database();
    }

    @Test
    void testGetUserData() {
        Assertions.assertEquals("hello", db.getUserData(),
         "getUserData should return 'hello' from the legacy method.");
    }

    @Test
    void testGetStaticData() {
        Assertions.assertEquals("hello2", db.getStaticData(), 
        "getStaticData should return 'hello2' from the legacy method.");
    }
}
