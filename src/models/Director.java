package models;

public class Director implements Comparable <Director>{
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public int compareTo(Director o) {
        return 0;
    }
}
