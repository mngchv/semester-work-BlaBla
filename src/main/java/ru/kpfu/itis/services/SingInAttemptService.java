package ru.kpfu.itis.services;

public interface SingInAttemptService {
    public void loginSucceeded(String key);

    public void loginFailed(String key);

    public boolean isBlocked(String key);

}