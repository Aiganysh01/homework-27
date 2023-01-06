package models;

public class Cast{
    String name;
    String roleName;

    public String getName() {
        return name;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return getName() + " в роли " + getRoleName() + "\n";
    }
}
