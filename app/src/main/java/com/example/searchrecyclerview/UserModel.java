package com.example.searchrecyclerview;

public class UserModel {

    private int userImage;
    private String userName;
    private String userDescription;

    public UserModel(int userImage, String userName, String userDescription) {
        this.userImage = userImage;
        this.userName = userName;
        this.userDescription = userDescription;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }
}
