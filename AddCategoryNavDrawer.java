package com.fit2081.assignment12081;

import android.widget.EditText;
import android.widget.Switch;

public class AddCategoryNavDrawer {

    private String CategoryNavId;

    private String CategoryNavName;

    private int EventNavCount;

    private boolean isNavActive;

    public AddCategoryNavDrawer(String categoryId, String categoryName, int eventCount, boolean isActive) {
        CategoryNavId = categoryId;
        CategoryNavName = categoryName;
        EventNavCount = eventCount;
        this.isNavActive = isActive;
    }

    public String getCategoryId() {
        return CategoryNavId;
    }

    public String getCategoryName() {
        return CategoryNavName;
    }

    public int getEventCount() {
        return EventNavCount;
    }

    public void setEventNavCount(int eventNavCount) {
        EventNavCount = eventNavCount;
    }

    public boolean isActive() {
        return isNavActive;
    }
}
