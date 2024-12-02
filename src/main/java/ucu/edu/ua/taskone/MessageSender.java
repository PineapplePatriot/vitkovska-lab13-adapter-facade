package ucu.edu.ua.taskone;
import java.time.LocalDateTime;
import java.util.List;

public class MessageSender {
    public void send(String text, List<User> users, String country) {
        LocalDateTime now = LocalDateTime.now();
        for (User user : users) {
            if (user.getCountry().equalsIgnoreCase(country)
                    && user.getLastActiveTime().isAfter(now.minusHours(1))) {
                System.out.println("Sending message to " + user.getEmail() + ": " + text);
            }
        }
    }
}
