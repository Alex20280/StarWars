package com.example.starwars.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {
    public static final HashMap<Integer, String> CONSTANT_MAP = new HashMap<Integer, String>() {
                {
                    put(28, "Action");
                    put(12, "Adventure");
                    put(16, "Animation");
                    put(35, "Comedy");
                    put(80, "Crime");
                    put(99, "Documentary");
                    put(18, "Drama");
                    put(10751, "Family");
                    put(14, "Fantasy");
                    put(36, "History");
                    put(27, "Horror");
                    put(10402, "Music");
                    put(9648, "Mystery");
                    put(10749, "Romance");
                    put(878, "Science Fiction");
                    put(10770, "TV Movie");
                    put(53, "Thriller");
                    put(10752, "War");
                    put(37, "Western");
                }
            };

    public static ArrayList<String> getGender(ArrayList<Integer> arrayList, HashMap<Integer, String> hashMap) {
        ArrayList<String> resultList = new ArrayList<String>();
        for (Map.Entry m : hashMap.entrySet()) {
            if (arrayList.contains(m.getValue()))
                resultList.add(m.getValue().toString());
        }
        return resultList;
    }

}

/*

    put(28, "Action");
    put(12, "Adventure");
    put(16, "Animation");
    put(35, "Comedy");
    put(80, "Crime");
    put(99, "Documentary");
    put(18, "Drama");
    put(10751, "Family");
    put(14, "Fantasy");
    put(36, "History");
    put(27, "Horror");
    put(10402, "Music");
    put(9648, "Mystery");
    put(10749, "Romance");
    put(878, "Science Fiction");
    put(10770, "TV Movie");
    put(53, "Thriller");
    put(10752, "War");
    put(37, "Western");*/