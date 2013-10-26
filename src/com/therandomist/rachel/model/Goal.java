package com.therandomist.rachel.model;

public class Goal {

    int id;
    String name;
    String shortCode;
    int color;
    transient boolean selected;

    public Goal(int id, String name, String shortCode, int color) {
        this.id = id;
        this.name = name;
        this.shortCode = shortCode;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getShortCode() {
        return shortCode;
    }

    public int getColor() {
        return color;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goal)) return false;

        Goal goal = (Goal) o;

        if (name != null ? !name.equals(goal.name) : goal.name != null) return false;
        if (shortCode != null ? !shortCode.equals(goal.shortCode) : goal.shortCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (shortCode != null ? shortCode.hashCode() : 0);
        return result;
    }
}
