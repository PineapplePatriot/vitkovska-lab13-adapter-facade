package ucu.edu.ua.tasktwo;

public class Database extends БазаДаних {

    public String getUserData() {
        return отриматиДаніКористувача();
    }

    public String getStaticData() {
        return отриматиСтатистичніДані();
    }
}
