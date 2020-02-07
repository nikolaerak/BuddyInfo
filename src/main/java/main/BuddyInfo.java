package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BuddyInfo {

    private Long Id;
    private String address;
    private String phoneNumber;
    private String name;

    public BuddyInfo(){}

    public BuddyInfo(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.phoneNumber = number;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return this.Id;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setId(Long newID) {
        this.Id = newID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return ("Name: " + name + "\n" + "Address: " + address + "\n" + "Phone Number: " + phoneNumber + "\n");
    }

    public String greeting() {
        return("Hello " + name +"!");
    }
}
