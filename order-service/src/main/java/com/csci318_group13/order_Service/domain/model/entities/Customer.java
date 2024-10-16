package com.csci318_group13.order_Service.domain.model.entities;

import jakarta.persistence.*;

@Entity
@Embeddable
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_sequence" ,
        sequenceName = "customer_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,
     generator = "customer_sequence")
Long id ;
    @Column
    private String fName;
    @Column
    private String lName;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String address;

    public Customer() {
    }

    public Customer(String fName, String lName, String email, String phone, String address) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
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

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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
        return "Customer{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }



}
