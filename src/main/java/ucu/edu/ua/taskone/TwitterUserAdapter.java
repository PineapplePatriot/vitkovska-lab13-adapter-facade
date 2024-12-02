package ucu.edu.ua.taskone;
import java.time.LocalDateTime;

public class TwitterUserAdapter implements User {
    private TwitterUser twitterUser;

    public TwitterUserAdapter(TwitterUser twitterUser) {
        this.twitterUser = twitterUser;
    }

    @Override
    public String getEmail() {
        return twitterUser.getUserMail();
    }

    @Override
    public String getCountry() {
        return twitterUser.getCountry();
    }

    @Override
    public LocalDateTime getLastActiveTime() {
        return twitterUser.getLastActiveTime();
    }
}
