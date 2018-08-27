package models.enums;

public enum AgeType {
    HATCHLING(20, "Hatchling"),
    ADOLESCENT(50, "Adolescent"),
    ADULT(80, "Adult");

    private final int ageTreshold;
    private final String humanREadable;

    AgeType(int ageTreshold, String humanReadable) {
        this.ageTreshold = ageTreshold;
        this.humanREadable = humanReadable;
    }

    public String getHumanREadable() {
        return humanREadable;
    }

    public int getAgeTreshold() {
        return ageTreshold;
    }
}
