package com.example.androidmvvmbasics.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;
import android.util.Patterns;

import com.android.databinding.library.baseAdapters.BR;
import com.example.androidmvvmbasics.model.User;

public class LoginViewModel extends BaseObservable {
    // make an object of type User as defined in the model/User.java
    private User user;

    private String successMessage = "Login was successful";
    private String errorMessage = "Email or Password is incorrect";

    @Bindable
    private String toastMessage = null;

    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public void setUserEmail(String email) {
        //call the setEmail method in User.java
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserEmail() {
        return user.getEmail();
    }

    @Bindable
    public String getUserPassword() {
        return user.getPassword();
    }

    public void setUserPassword(String password) {
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    public LoginViewModel() {
        user = new User("","","OFF");
        setToastMessage(getButtonState());
    }

    public void onLoginClicked() {
        if (isInputDataValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }

    public void setButtonState(String buttonState) {
        user.setButton(buttonState);
        setToastMessage(getButtonState());
        //notifyPropertyChanged(BR.buttonState);
    }

    public String getButtonState() { return user.getButton();}

    public void onButtonClicked() {
        // check what state button is in on/off
        // change text to reflect new state
        if (getButtonState().equals("ON")) {
            setButtonState("OFF");
        }
        else {
            setButtonState("ON");
        }
        setToastMessage(getButtonState());
    }

    public Boolean isInputDataValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;
    }

}

