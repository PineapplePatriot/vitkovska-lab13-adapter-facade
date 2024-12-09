import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import ucu.edu.ua.taskone.MessageSender;
import ucu.edu.ua.taskone.User;
import ucu.edu.ua.taskone.TwitterUser;
import ucu.edu.ua.taskone.FacebookUser;
import ucu.edu.ua.taskone.TwitterUserAdapter;
import ucu.edu.ua.taskone.FacebookUserAdapter;


class MessageSenderTest {
    private static final int ACTIVE_USER_THRESHOLD_MINUTES = 30;
    private static final int ANOTHER_CONSTANT_EXAMPLE = 50;
    private static final int ANOTHER_CONSTANT_TWO = 2;
    private MessageSender messageSender;
    private List<User> users;

    @BeforeEach
    void setUp() {
        messageSender = new MessageSender();
        users = new ArrayList<>();
        TwitterUser twitterUser = new TwitterUser(
            "active_twitter@example.com", "USA", 
            LocalDateTime.now().minusMinutes(
                ACTIVE_USER_THRESHOLD_MINUTES));
        users.add(new TwitterUserAdapter(twitterUser));
        FacebookUser facebookUser = new FacebookUser(
            "active_facebook@example.com", "USA", 
            LocalDateTime.now().minusMinutes(
                ANOTHER_CONSTANT_EXAMPLE));
        users.add(new FacebookUserAdapter(facebookUser));
        TwitterUser inactiveTwitterUser = new TwitterUser(
            "inactive_twitter@example.com", "USA", 
            LocalDateTime.now().minusHours(
                ANOTHER_CONSTANT_TWO));
        users.add(new TwitterUserAdapter(inactiveTwitterUser));
    }

    @Test
    void testSendMessageToActiveUsers() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        messageSender.send("Hello, active users!", 
        users, "USA");
        String output = outputStream.toString();

        Assertions.assertTrue(output.contains("active_twitter@example.com"),
         "Expected active Twitter user to receive a message.");
        Assertions.assertTrue(output.contains("active_facebook@example.com"), 
        "Expected active Facebook user to receive a message.");
        Assertions.assertFalse(output.contains("inactive_twitter@example.com"), 
        "Inactive user should not receive a message.");
    }

    @Test
    void testSendMessageToNonMatchingCountry() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        messageSender.send("Hello, active users!", 
        users, "Canada");
        String output = outputStream.toString();

        Assertions.assertFalse(output.contains("active_twitter@example.com"), 
        "No users from Canada should receive a message.");
        Assertions.assertFalse(output.contains("active_facebook@example.com"), 
        "No users from Canada should receive a message.");
    }
}
