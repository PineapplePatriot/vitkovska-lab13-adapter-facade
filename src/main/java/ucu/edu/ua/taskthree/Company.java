package ucu.edu.ua.taskthree;

public class Company {
    private final String name;
    private final String description;
    private final String logo;

    public Company(String name, String description, 
    String logo) {
        this.name = name;
        this.description = description;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLogo() {
        return logo;
    }

    @Override
    public String toString() {
        return "Company{"
                + "name='" + name + '\'' 
                + ", description='" + description + '\'' 
                + ", logo='" + logo + '\'' 
                + '}';
    }
}
