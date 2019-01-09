package iot.application;

public class Genre {
    public int id;
    public String name;
    public String toString() {
        return String.format("ID: %s | Name: %s", id, name);
    }
}
