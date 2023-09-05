package com.springapp.vehicleservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;
    @Column(name = "name")
    private String username;
	@Column(name = "email", unique = true)
    private String userEmail;
    @Column(name = "pass")
    private String password;
    @Column(name = "phno")
    private String contactNo;

    public User() {

    }
    
    public User(int userId, String userName, String userEmail, String password, String contactNo) {
        this.userId = userId;
        this.username = userName;
        this.userEmail = userEmail;
        this.password = password;
        this.contactNo = contactNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + username + ", userEmail=" + userEmail + ", password="
                + password + ", contactNo=" + contactNo + "]";
    }
    
}
