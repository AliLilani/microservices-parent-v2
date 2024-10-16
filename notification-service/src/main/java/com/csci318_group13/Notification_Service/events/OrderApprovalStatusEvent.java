package com.csci318_group13.Notification_Service.events;

public class OrderApprovalStatusEvent {

    private  OrderApprovalStatusData orderApprovalStatusData ;

    public OrderApprovalStatusEvent() {
    }

    public OrderApprovalStatusEvent(OrderApprovalStatusData orderApprovalStatusData) {
        this.orderApprovalStatusData = orderApprovalStatusData;
    }

    public OrderApprovalStatusData getOrderApprovalStatusData() {
        return orderApprovalStatusData;
    }

    public void setOrderApprovalStatusData(OrderApprovalStatusData orderApprovalStatusData) {
        this.orderApprovalStatusData = orderApprovalStatusData;
    }

    @Override
    public String toString() {
        return "OrderApprovalStatusEvent{" +
                "orderApprovalStatusData=" + orderApprovalStatusData +
                '}';
    }
}
