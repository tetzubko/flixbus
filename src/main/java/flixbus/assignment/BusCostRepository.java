package flixbus.assignment;

import flixbus.assignment.model.BusCost;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusCostRepository extends MongoRepository<BusCost, String> {
    BusCost findByLineId(Integer id);
}
