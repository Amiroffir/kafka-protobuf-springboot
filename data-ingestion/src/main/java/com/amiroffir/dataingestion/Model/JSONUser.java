package com.amiroffir.dataingestion.Model;



public class JSONUser {
    private int id;
    private String name;
    private String email;

    public JSONUser() {
    }

//    public JSONUser(User protoUser) {
//        this.id = protoUser.getId();
//        this.name = protoUser.getName();
//        this.email = protoUser.getEmail();
//    }

public JSONUser(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
// This method is for converting the User object to ProtoUser object
//    public User toProtoUser() {
//        return User.newBuilder()
//            .setId(this.id)
//            .setName(this.name)
//            .setEmail(this.email)
//            .build();
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}