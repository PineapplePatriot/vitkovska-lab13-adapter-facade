package ucu.edu.ua.tasktwo;

import lombok.Getter;

public class ReportBuilder {
    @Getter
    private Database db;

    public ReportBuilder(Database db) {
        this.db = db;
    }
}
