package main;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addressbook", path = "addressbook")
public interface AddressBookRepository  extends PagingAndSortingRepository<AddressBook, Integer> {

	Optional<AddressBook> findById(Integer id);


}