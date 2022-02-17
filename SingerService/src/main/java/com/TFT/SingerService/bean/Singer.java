package com.TFT.SingerService.bean;

import io.swagger.annotations.ApiModelProperty;

public class Singer {
    @ApiModelProperty(notes = "Singer's Id", name = "id", required = true, value = "1")
    private int id;
    @ApiModelProperty(notes = "Singer's first name", name = "firstName", required = true, value = "William")
    private String firstName;
    @ApiModelProperty(notes = "Singer's last name", name = "lastName", required = true, value = "Kalubi Mwamba")
    private String lastName;
    @ApiModelProperty(notes = "Singer's nickname", name = "nickName", required = true, value = "Damso")
    private String nickName;
    @ApiModelProperty(notes = "Singer's age", name = "age", required = true, value = "29")
    private int age;
    @ApiModelProperty(notes = "Singer's alive state", name = "isAlive", required = true, value = "true")
    private boolean isAlive;

    public Singer(int id, String firstName, String lastName, String nickName, int age, boolean isAlive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.age = age;
        this.isAlive = isAlive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                ", isAlive=" + isAlive +
                '}';
    }
}
