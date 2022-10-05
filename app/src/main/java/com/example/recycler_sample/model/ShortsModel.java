package com.example.recycler_sample.model;

import java.util.List;

public class ShortsModel {
    public String title;
    public List<ChildModel> items;

    public ShortsModel(String title, List<ChildModel> items) {
        this.title = title;
        this.items = items;
    }
}
