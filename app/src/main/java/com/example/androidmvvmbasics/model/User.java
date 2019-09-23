package com.example.androidmvvmbasics.model;

// the model holds the user's email and password
public class User {

    private String email;
    private String password;

    private String buttonState;

    // constructor takes email and password strings and assigns them to the class variables
    public User(String email, String password, String buttonState) {
        this.email = email;
        this.password = password;

        this.buttonState = buttonState;
    }

    // set email method
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    ///
    public void setButton(String buttonState) {this.buttonState = buttonState;}

    public String getButton() { return buttonState;}

}
