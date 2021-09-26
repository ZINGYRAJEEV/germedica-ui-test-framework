package com.gerimedica.test;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:environments/${property.file}.properties"})
public interface VangofConfig extends Config {

    @Key("base.url")
    String baseUrl();

    @Key("user1.username")
    String username1();

    @Key("user1.password")
    String password1();

    @Key("user2.username")
    String username2();

    @Key("user2.password")
    String password2();
}

