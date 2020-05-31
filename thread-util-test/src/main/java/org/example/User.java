package org.example;

/**
 * Created by oxygen 
 * @author oxygen
 * @time 2020/5/31 12:19
 **/
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
