package org.example.entities;

public class User {

    private String userId;
    private String name;
    private String emailId;
    private long mobileNumber;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public User(String userId, String name, String emailId, long mobileNumber) {
        this.userId = userId;
        this.name = name;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
    }

}
