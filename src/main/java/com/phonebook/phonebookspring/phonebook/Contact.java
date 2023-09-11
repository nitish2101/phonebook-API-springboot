package com.phonebook.phonebookspring.phonebook;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Contact {
    @Id
    @GeneratedValue
    private Long id;
    private Long phoneNo;
    private String name;
    private String email;

    public Contact(){}

    public Contact(long phoneNo, String name, String email) {
        this.phoneNo = phoneNo;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", phoneNo=" + phoneNo +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
