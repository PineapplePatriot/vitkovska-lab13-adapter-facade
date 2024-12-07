package ucu.edu.ua.taskone;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AdapterPatternExample {
    public static void main(String[] args) {
        TwitterUser twitterUser = new TwitterUser("twitter@example.com",
         "USA", LocalDateTime.now().minusMinutes(30));
        FacebookUser facebookUser = new FacebookUser("facebook@example.com",
         "USA", LocalDateTime.now().minusMinutes(50));

        User twitterAdapter = new TwitterUserAdapter(twitterUser);
        User facebookAdapter = new FacebookUserAdapter(facebookUser);

        List<User> users = new ArrayList<>();
        users.add(twitterAdapter);
        users.add(facebookAdapter);
        MessageSender sender = new MessageSender();
        sender.send("Hello, active users!", users, "USA");
    }
}
