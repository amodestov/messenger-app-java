package com.aleksandrmodestov.messenger;

public class User {

    private String id;
    private String firstName;
    private String secondName;
    private int age;
    private boolean online;

    public User() {
    }

    public User(String id, String firstName, String secondName, int age, boolean online) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.online = online;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public boolean isOnline() {
        return online;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", isOnline=" + online +
                '}';
    }
}
