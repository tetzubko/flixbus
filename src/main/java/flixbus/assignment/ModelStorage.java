package flixbus.assignment;

import flixbus.assignment.model.BusCost;
import flixbus.assignment.model.Connection;
import flixbus.assignment.model.DriverCost;
import org.springframework.stereotype.Component;

@Component
public class ModelStorage {
    public void createSampleModel(ConnectionRepository connectionRepository, BusCostRepository busCostRepository, DriverCostRepository driverCostRepository){
        connectionRepository.deleteAll();
            Connection connection1 = new Connection(3, "Munich", "Stuttgart", 800, 8);
            Connection connection2 = new Connection(6, "Brussels", "Cologne", 200, 2);
            Connection connection3 = new Connection(1, "Berlin", "Munich", 800, 8);
            Connection connection4 = new Connection(4, "Strasbourg", "Freiburg", 100, 1);
            Connection connection5 = new Connection(4, "Stuttgart", "Zurich", 500, 5);
            Connection connection6 = new Connection(7, "Freiburg", "Zurich", 300, 3);
            Connection connection7 = new Connection(5, "Brussels", "Strasbourg", 800, 8);
            Connection connection8 = new Connection(9, "Madrid", "Seville", 300, 3);
            Connection connection9 = new Connection(6, "Cologne", "Amsterdam", 300, 3);
            Connection connection10 = new Connection(10, "Madrid", "Barcelona", 400, 4);
            Connection connection11 = new Connection(9, "Lisbon", "Madrid", 300, 3);
            Connection connection12 = new Connection(8, "Zurich", "Milan", 800, 8);
            Connection connection13 = new Connection(5, "Strasbourg", "Paris", 700, 7);
            Connection connection14 = new Connection(1, "Prague", "Berlin", 400, 4);
            Connection connection15 = new Connection(5, "Milan", "Rome", 800, 8);
            Connection connection16 = new Connection(3, "Munich", "Vienna", 400, 3.5);
            Connection connection17 = new Connection(4, "Stuttgart", "Freiburg", 150, 2);
            Connection connection18 = new Connection(2, "Warsaw", "Berlin", 600, 6);
            connectionRepository.insert(connection1);
            connectionRepository.insert(connection2);
            connectionRepository.insert(connection3);
            connectionRepository.insert(connection4);
            connectionRepository.insert(connection5);
            connectionRepository.insert(connection6);
            connectionRepository.insert(connection7);
            connectionRepository.insert(connection8);
            connectionRepository.insert(connection9);
            connectionRepository.insert(connection10);
            connectionRepository.insert(connection11);
            connectionRepository.insert(connection12);
            connectionRepository.insert(connection13);
            connectionRepository.insert(connection14);
            connectionRepository.insert(connection15);
            connectionRepository.insert(connection16);
            connectionRepository.insert(connection17);
            connectionRepository.insert(connection18);

            // Bus Cost
            busCostRepository.deleteAll();
            BusCost busCost1 = new BusCost(1, 7.158948707);
            BusCost busCost2 = new BusCost(2, 3.424000008);
            BusCost busCost3 = new BusCost(3, 1.414111432);
            BusCost busCost4 = new BusCost(4, 5.659771674);
            BusCost busCost5 = new BusCost(5, 8.454682637);
            BusCost busCost6 = new BusCost(6, 3.177561073);
            BusCost busCost7 = new BusCost(7, 3.775982779);
            BusCost busCost8 = new BusCost(8, 8.476787342);
            BusCost busCost9 = new BusCost(9, 6.764022645);
            BusCost busCost10 = new BusCost(10, 0.608684765);
            busCostRepository.insert(busCost1);
            busCostRepository.insert(busCost2);
            busCostRepository.insert(busCost3);
            busCostRepository.insert(busCost4);
            busCostRepository.insert(busCost5);
            busCostRepository.insert(busCost6);
            busCostRepository.insert(busCost7);
            busCostRepository.insert(busCost8);
            busCostRepository.insert(busCost9);
            busCostRepository.insert(busCost10);

            // Driver Cost
            driverCostRepository.deleteAll();
            DriverCost driverCost1 = new DriverCost(1, 7.25534698);
            DriverCost driverCost2 = new DriverCost(2, 0.396874932);
            DriverCost driverCost3 = new DriverCost(3, 5.582751583);
            DriverCost driverCost4 = new DriverCost(4, 10.15811534);
            DriverCost driverCost5 = new DriverCost(5, 8.239126123);
            DriverCost driverCost6 = new DriverCost(6, 11.97823609);
            DriverCost driverCost7 = new DriverCost(7, 7.898952736);
            DriverCost driverCost8 = new DriverCost(8, 8.74074805);
            DriverCost driverCost9 = new DriverCost(9, 1.45593449);
            DriverCost driverCost10 = new DriverCost(10, 7.698439109);
            driverCostRepository.insert(driverCost1);
            driverCostRepository.insert(driverCost2);
            driverCostRepository.insert(driverCost3);
            driverCostRepository.insert(driverCost4);
            driverCostRepository.insert(driverCost5);
            driverCostRepository.insert(driverCost6);
            driverCostRepository.insert(driverCost7);
            driverCostRepository.insert(driverCost8);
            driverCostRepository.insert(driverCost9);
            driverCostRepository.insert(driverCost10);
    }
}
