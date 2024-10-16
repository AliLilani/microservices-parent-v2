package com.csci318_group13.customer_Service.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ContactInfo {

    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String address;

    public ContactInfo() {
    }

    public ContactInfo(String email, String phone, String address) {
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
