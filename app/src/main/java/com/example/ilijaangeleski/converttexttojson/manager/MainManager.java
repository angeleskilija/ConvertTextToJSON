package com.example.ilijaangeleski.converttexttojson.manager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ilija Angeleski on 11/21/2017.
 */
public class MainManager {
    private static final String EMOJIS_REGEX = "\\:[a-zA-Z0-9\\-\\_]+:";
    private static final String MENTIONS_REGEX = "\\@[a-zA-Z0-9\\-\\_]+";
    private static final String URL_REGEX = "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
            + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
            + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)";

    private StorageManager storageManager;

    public MainManager(StorageManager storageManager) {
        this.storageManager = storageManager;
    }

    public String parseUserInput(String text) throws JSONException {
        JSONObject output = new JSONObject();
        output.put("emojis", extractEmojisFromText(text));
        output.put("links", extractUrlsFromText(text));
        output.put("mentions", extractMentionsFromText(text));

        storageManager.saveResult(output.toString());

        return output.toString();
    }

    private JSONArray extractUrlsFromText(String text) throws JSONException {
        JSONArray urls = new JSONArray();
        List<String> foundUrls = findAppearance(text, URL_REGEX);
        for (String url : foundUrls) {
            JSONObject temp = new JSONObject();
            temp.put("url", url);
            urls.put(temp);
        }

        return urls;
    }

    private JSONArray extractEmojisFromText(String text) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        List<String> foundEmojis = findAppearance(text, EMOJIS_REGEX);
        for (String emoji : foundEmojis) {
            JSONObject temp = new JSONObject();
            temp.put("value", emoji);
            jsonArray.put(temp);
        }

        return jsonArray;
    }

    private JSONArray extractMentionsFromText(String text) throws JSONException {
        JSONArray mentionedUser = new JSONArray();
        List<String> foundUsers = findAppearance(text, MENTIONS_REGEX);
        for (String user : foundUsers) {
            JSONObject temp = new JSONObject();
            temp.put("value", user);
            mentionedUser.put(temp);
        }

        return mentionedUser;
    }

    private List<String> findAppearance(String text, String regex) {
        List<String> foundItems = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            foundItems.add(matcher.group());
        }

        return foundItems;
    }
}
