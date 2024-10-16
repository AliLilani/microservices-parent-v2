package com.csci318_group13.customer_Service.DTO;

import com.csci318_group13.customer_Service.domain.model.valueobjects.ContactInfo;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;

import java.util.Objects;

public class CustomerDTO {

    private String fName;

    private String lName;

    private  Long id ;



    private ContactInfo contactInfo ;







    public CustomerDTO() {
    }

    public CustomerDTO(String fName, String lName, ContactInfo contactInfo) {
        this.fName = fName;
        this.lName = lName;
        this.contactInfo = contactInfo;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }



    public String getlName() {
        return lName;
    }


    @Override
    public String toString() {
        return "CustomerDTO{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", id=" + id +
                ", contactInfo=" + contactInfo +
                '}';
    }


}
