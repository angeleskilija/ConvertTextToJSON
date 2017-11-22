package com.example.ilijaangeleski.converttexttojson;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    @Test
    public void findMentions() {
        Pattern pattern = Pattern.compile("\\@[a-zA-Z0-9\\-\\_]+");

        Matcher matcher = pattern.matcher("Hello @Ilija nice to meet you. :smile: ");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    public void findEmojies() {
        Pattern pattern = Pattern.compile("\\:[a-zA-Z0-9\\-\\_]+:");

        Matcher matcher = pattern.matcher("Hello @Ilija nice to meet you. :smile: ");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}