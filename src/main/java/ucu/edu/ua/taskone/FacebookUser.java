package ucu.edu.ua.taskone;
import java.time.LocalDateTime;

public class FacebookUser {
    private String email;
    private String userCountry;
    private LocalDateTime userActiveTime;

    public FacebookUser(String email, String userCountry, LocalDateTime userActiveTime) {
        this.email = email;
        this.userCountry = userCountry;
        this.userActiveTime = userActiveTime;
    }

    public String getEmail() {
        return email;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public LocalDateTime getUserActiveTime() {
        return userActiveTime;
    }
}
