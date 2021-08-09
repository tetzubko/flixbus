package flixbus.assignment;

import flixbus.assignment.model.Connection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionRepository extends MongoRepository<Connection, String>{
    List<Connection> findByCity1(String city1);
    List<Connection> findByCity2(String city2);
    Connection findByCity1AndCity2(String city1, String city2);
}
