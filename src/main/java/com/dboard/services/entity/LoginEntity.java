package com.dboard.services.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOGIN")
public class LoginEntity {

    private String userName;
    private String password;
    private String fromEmail;
    private String toEmail;

    @Id
    @Column(name="LOGIN_USER_NAME")
    public String getUserName() {
        return userName;
    }

    @Column(name="LOGIN_PASSWORD")
    public String getPassword() {
        return password;
    }

    @Column(name="FROM_EMAIL")
    public String getFromEmail() {
        return fromEmail;
    }

    @Column(name="TO_EMAIL")
    public String getToEmail() {
        return toEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
