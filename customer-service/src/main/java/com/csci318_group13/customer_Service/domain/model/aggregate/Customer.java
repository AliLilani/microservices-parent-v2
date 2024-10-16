package com.csci318_group13.customer_Service.domain.model.aggregate;

import com.csci318_group13.customer_Service.domain.model.valueobjects.ContactInfo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
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
   @Embedded
   private ContactInfo contactInfo ;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public Customer(String fName, String lName, ContactInfo contactInfo) {
        this.fName = fName;
        this.lName = lName;
        this.contactInfo = contactInfo;

    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", contactInfo=" + contactInfo +
                '}';
    }
}
