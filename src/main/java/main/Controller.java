package main;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
	
	@Autowired
	AddressBookRepository addressBookRepository;
	
	@Autowired
	BuddyInfoRepository buddyInfoRepository;

    @GetMapping("/addressBook")
    public Iterable<AddressBook> address() {
        return addressBookRepository.findAll();
    }

    @PostMapping("/addressBook")
    public AddressBook addressBook() {
        AddressBook ab = new AddressBook();
        ab = addressBookRepository.save(ab);
        return ab;
    }
    
    @GetMapping("addressBook/{id}")
    public AddressBook getAddressBookById(@PathVariable("id") Integer id){
        Optional<AddressBook> oAddressBook = addressBookRepository.findById(id);
        if (oAddressBook.isPresent()){
            return oAddressBook.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }
    
    @GetMapping("/addressBook/buddyinfo")
    public Iterable<BuddyInfo> buddy() {
        return buddyInfoRepository.findAll();
    }
    
    @GetMapping("addressBook/buddyinfo/{id}")
    public BuddyInfo getBuddyInfoById(@PathVariable("id") Integer id){
        Optional<BuddyInfo> buddy = buddyInfoRepository.findById(id);
        if (buddy.isPresent()){
            return buddy.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }
    
    @PostMapping("/addressBook/buddyinfo")
    public BuddyInfo buddyInfo(@ModelAttribute BuddyInfo buddyinfo) {
        BuddyInfo buddy = new BuddyInfo();
        buddy = buddyInfoRepository.save(buddy);
        return buddy;
    }

}
