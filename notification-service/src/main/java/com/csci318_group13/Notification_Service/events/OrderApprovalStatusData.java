package com.csci318_group13.Notification_Service.events;

public class OrderApprovalStatusData {
    private  Boolean approved ;
    private String placingOrderID ;

    public OrderApprovalStatusData() {
    }

    public OrderApprovalStatusData(Boolean approved, String placingOrderID) {
        this.approved = approved;
        this.placingOrderID = placingOrderID;
    }

    public Boolean getApproved() {
        return approved;
    }

    public String getPlacingOrderID() {
        return placingOrderID;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }



    public void setPlacingOrderID(String placingOrderID) {
        this.placingOrderID = placingOrderID;
    }

    @Override
    public String toString() {
        return "OrderApprovalStatusData{" +
                "approved=" + approved +
                ", placingOrderID='" + placingOrderID + '\'' +
                '}';
    }
}
