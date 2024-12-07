package ucu.edu.ua.tasktwo;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        Authorization auth = new Authorization();
        if (auth.login(db)) {
            ReportBuilder br = new ReportBuilder(db);
        }
    }
}
