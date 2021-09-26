package com.gerimedica.test.auth;


import com.gerimedica.test.VangofConfig;

public class UsersProvider {

    //TODO: suggest give users more meaningful names, e.g. userWithPolicies, userWithoutPolicies etc
    private static User user1;
    private static User user2;

    public static void init(VangofConfig config) {
        user1 = new User(config.username1(), config.password1());
        user2 = new User(config.username2(), config.password2());
    }

    public static User getUser1() {
        return user1;
    }

    public static User getUser2() {
        return user2;
    }

}