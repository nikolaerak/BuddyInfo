package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	AddressBookRepository addressBookRepository;
	
	@Autowired
	BuddyInfoRepository buddyInfoRepository;


    @GetMapping("/home")
    public String greeting(Model model) {
        Iterable<AddressBook> books = addressBookRepository.findAll();
        List<Long> ids = new ArrayList<>();
        for(AddressBook a: books) {
            ids.add(a.getId());
            model.addAttribute("ids", ids);
        }
        return "addressbooks";
    }
    @GetMapping("/home/{id}")
    public String greeting(@PathVariable("id") Long id, Model model) {
        model.addAttribute("buddies", addressBookRepository.findById(id).get().getInfo());
        return "addressbook";
    }


    @GetMapping("/addressbooks")
    public Iterable<AddressBook> address() {
        return addressBookRepository.findAll();
    }

    @PostMapping("/addressbook")
    public AddressBook addressBook() {
        AddressBook ab = new AddressBook();
        ab = addressBookRepository.save(ab);
        return ab;
    }
    
    @GetMapping("addressbook/{id}")
    public AddressBook getAddressBookById(@PathVariable("id") Long id){
        Optional<AddressBook> oAddressBook = addressBookRepository.findById(id);
        if (oAddressBook.isPresent()){
            return oAddressBook.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }
    
    @GetMapping("buddyinfos")
    public Iterable<BuddyInfo> buddy() {
        return buddyInfoRepository.findAll();
    }
    
    @GetMapping("addressbook/buddyinfo/{id}")
    public BuddyInfo getBuddyInfoById(@PathVariable("id") Long id){
        Optional<BuddyInfo> buddy = buddyInfoRepository.findById(id);
        if (buddy.isPresent()){
            return buddy.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }
    
    @PostMapping("addressbook/{id}/buddyinfo")
    public BuddyInfo addBuddyInfo(@PathVariable("id") Long id, @RequestBody BuddyInfo buddyinfo) {
        Optional<AddressBook> a = addressBookRepository.findById(id);
        if(!a.isPresent()) {
            throw new ResourceNotFoundException();
        }

        AddressBook ab = a.get();
        buddyinfo = buddyInfoRepository.save(buddyinfo);
        ab.addBuddy(buddyinfo);
        addressBookRepository.save(ab);
        return buddyinfo;
    }

    @DeleteMapping("addressbook/{id}/buddyinfo/{buddyId}")
    public void removeBuddy(@PathVariable("id") Long id, @PathVariable("buddyId") Long buddyId) {
        buddyInfoRepository.deleteById(buddyId);
    }

}
