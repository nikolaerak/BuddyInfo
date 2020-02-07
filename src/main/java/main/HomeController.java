package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    //a
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

}
