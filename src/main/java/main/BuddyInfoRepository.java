package main;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "buddy", path = "buddy")
public interface BuddyInfoRepository extends PagingAndSortingRepository<BuddyInfo, Integer> {

	Optional<BuddyInfo> findById(Integer id);
    List<BuddyInfo> findByAddress(@Param("address")String address);
    List<BuddyInfo> findByPhoneNumber(@Param("number")String number);
    List<BuddyInfo> findByName(@Param("name") String name);
}
