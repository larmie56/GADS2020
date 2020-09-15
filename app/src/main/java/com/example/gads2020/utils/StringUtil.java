package com.example.gads2020.utils;

public class StringUtil {

    public static String formatLearningHours(int hours, String country) {
        return hours + " learning hours, " + country + ".";
    }

    public static String formatSkillIqScore(int score, String country) {
        return score + " skill IQ Score, " + country;
    }
}
