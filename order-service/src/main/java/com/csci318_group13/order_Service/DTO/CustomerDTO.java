package com.csci318_group13.order_Service.DTO;

import java.util.Objects;

public class CustomerDTO {

    private String fName;

    private String lName;

    private String email;

    public CustomerDTO() {
    }

    public CustomerDTO(String fName, String lName, String email) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getlName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerDTO that)) return false;
        return Objects.equals(getfName(), that.getfName()) && Objects.equals(getlName(), that.getlName()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getfName(), getlName(), getEmail());
    }
}
