package ucu.edu.ua.taskone;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AdapterPatternExample {
    private static final int ACTIVE_USER_THRESHOLD_MINUTES = 30;
    private static final int ANOTHER_CONSTANT_EXAMPLE = 50;
    public static void main(String[] args) {
        TwitterUser twitterUser = new TwitterUser("twitter@example.com",
         "USA", LocalDateTime.now().minusMinutes(ACTIVE_USER_THRESHOLD_MINUTES));
        FacebookUser facebookUser = new FacebookUser("facebook@example.com",
         "USA", LocalDateTime.now().minusMinutes(ANOTHER_CONSTANT_EXAMPLE));

        User twitterAdapter = new TwitterUserAdapter(twitterUser);
        User facebookAdapter = new FacebookUserAdapter(facebookUser);

        List<User> users = new ArrayList<>();
        users.add(twitterAdapter);
        users.add(facebookAdapter);
        MessageSender sender = new MessageSender();
        sender.send("Hello, active users!", users, "USA");
    }
}
