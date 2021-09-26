package com.gerimedica.test.auth;


public class LoggedUser {
    private static final int TIME_TILL_AUTH_IS_VALID_MS = 60000;
    private String username;
    private long loggedInAt;
    private String token;

    public boolean isTimedOut() {
        return System.currentTimeMillis() - loggedInAt > TIME_TILL_AUTH_IS_VALID_MS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getLoggedInAt() {
        return loggedInAt;
    }

    public void setLoggedInAt(long loggedInAt) {
        this.loggedInAt = loggedInAt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
