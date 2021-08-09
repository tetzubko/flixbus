package flixbus.assignment;

import flixbus.assignment.model.DriverCost;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverCostRepository extends MongoRepository<DriverCost, String> {
    DriverCost findByLineId(Integer id);
}
