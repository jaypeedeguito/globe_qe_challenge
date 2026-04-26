package com.core.utility;

import io.cucumber.java.Scenario;

public class TestDataModel {

    // Variables (Fields)
    private static String email;
    private static String password;

    static Scenario scenario;

    // Getter and Setter for email
    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        TestDataModel.email = email;
    }

    // Getter and Setter for password
    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        TestDataModel.password = password;
    }


    public static Scenario getScenario() {
        return scenario;
    }

    public static void setScenario(Scenario scenario) {
        TestDataModel.scenario = scenario;
    }

}
