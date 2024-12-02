package ucu.edu.ua.taskone;
import java.time.LocalDateTime;

public class TwitterUser {
    private String userMail;
    private String country;
    private LocalDateTime lastActiveTime;

    public TwitterUser(String userMail, String country, LocalDateTime lastActiveTime) {
        this.userMail = userMail;
        this.country = country;
        this.lastActiveTime = lastActiveTime;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getCountry() {
        return country;
    }

    public LocalDateTime getLastActiveTime() {
        return lastActiveTime;
    }
}
