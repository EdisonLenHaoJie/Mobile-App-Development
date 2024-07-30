package com.fit2081.assignment12081;

public class EventNavDrawer {




    private String EventNavId;

    private String EventNavName;

    private String CategoryAddNavId;

    private int TicketNavCount;

    private boolean isAddNavActive;



    public EventNavDrawer(String eventNavId, String eventNavName, String categoryAddNavId, int ticketNavCount, boolean isAddNavActive) {
        EventNavId = eventNavId;
        EventNavName = eventNavName;
        CategoryAddNavId = categoryAddNavId;
        TicketNavCount = ticketNavCount;
        this.isAddNavActive = isAddNavActive;


    }

    public String getEventNavId() {
        return EventNavId;
    }

    public String getEventNavName() {
        return EventNavName;
    }

    public String getCategoryAddNavId() {
        return CategoryAddNavId;
    }

    public int getTicketNavCount() {
        return TicketNavCount;
    }

    public boolean isAddNavActive() {
        return isAddNavActive;
    }
}
