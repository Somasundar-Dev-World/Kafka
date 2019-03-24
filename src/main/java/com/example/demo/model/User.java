package com.example.demo.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class User {

    private String userId;

    private String userName;

    private String userDetails;

    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);


    public User() {
        LOGGER.info("Instantiating the user object.");
    }

    public User(String userId, String userName, String userDetails) {
        this.userId = userId;
        this.userName = userName;
        this.userDetails = userDetails;
        LOGGER.info("Instantiating the user object with arguments.");
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(String userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userDetails='" + userDetails + '\'' +
                '}';
    }
}
