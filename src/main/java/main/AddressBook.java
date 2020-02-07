package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    private Integer Id;
    private List<BuddyInfo> info;

    public AddressBook() {
        info = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo object) {
        info.add(object);
    }

    public void removeBuddy(BuddyInfo object) {
        info.remove(object);
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return this.Id;
    }

    @OneToMany
    public List<BuddyInfo> getInfo(){
        return this.info;
    }

    public void setInfo(List<BuddyInfo> info){
        this.info = info;
    }

    public void setId(Integer id){
        Id = id;
    }

    public void clear() {
        info.clear();
    }

    public String toString() {
        String s  = "";
        for(BuddyInfo b : info) {
            s+=b.toString()+"\n";
        }
        return s;
    }
}
