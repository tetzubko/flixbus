package flixbus.assignment;

import flixbus.assignment.model.Connection;
import flixbus.assignment.model.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BusController {
    private List<String> connectionsList = new ArrayList<>();

    @Autowired
    private ConnectionRepository connectionRepository;
    @Autowired
    private BusCostRepository busCostRepository;
    @Autowired
    private DriverCostRepository driverCostRepository;

    @GetMapping("/information")
    public Information getInformationByCities(@RequestParam String city1, @RequestParam String city2) throws Exception {
        int lines = getNumOfLines(city1, city2);
        double busCost = getBusCost();
        double driverCost = getDriverCost();
        return new Information(lines, busCost, driverCost, busCost+driverCost);
    }

    private Integer getNumOfLines(String city1, String city2) throws Exception {
        List<String> isVisited = new ArrayList<>();
        ArrayList<String> pathList = new ArrayList<>();

        pathList.add(city1);
        connectionsList = new ArrayList<>();
        getAllPaths(city1, city2, isVisited, pathList);

        if (connectionsList.isEmpty()) {
            throw new ConnectionNotFoundException();
        }
        return connectionsList.size() - 1;
    }

    private void getAllPaths(String start, String destination, List<String> isVisited, List<String> localPathList) {
        if (start.equals(destination)) {
            if (connectionsList.isEmpty()) {
                connectionsList.addAll(localPathList);
            }
            if (!connectionsList.isEmpty() && connectionsList.size() > localPathList.size() && !localPathList.isEmpty()) { // if quicker route found
                connectionsList = new ArrayList<>();
                connectionsList.addAll(localPathList);
            }
            return;
        }

        isVisited.add(start);

        List<String> adjacentCities = getAdjacent(start);
        for (String c : adjacentCities) {
            if (!isVisited.contains(c)) {
                localPathList.add(c);
                getAllPaths(c, destination, isVisited, localPathList);
                localPathList.remove(c);
            }
        }
        isVisited.remove(start);
    }

    private List<String> getAdjacent(String city1) {
        List<String> adjacent = new ArrayList<>();

        List<Connection> connections1 = connectionRepository.findByCity1(city1); // if city is in the first column
        for (Connection connection : connections1) {
            adjacent.add(connection.getCity2());
        }

        List<Connection> connections2 = connectionRepository.findByCity2(city1); // if city is in the second column
        for (Connection connection : connections2) {
            adjacent.add(connection.getCity1());
        }
        return adjacent;
    }

    private double getBusCost() {
        double totalBusCost = 0;
        for(int i=0; i<connectionsList.size()-1; i++){
            String stop1 = connectionsList.get(i);
            String stop2 = connectionsList.get(i+1);

            Connection connection = connectionRepository.findByCity1AndCity2(stop1, stop2);
            if(connection==null){
                connection = connectionRepository.findByCity1AndCity2(stop2, stop1); // if columns are in different order
            }
            double cost_per_km = busCostRepository.findByLineId(connection.getLineId()).getBusCostPerKm();
            totalBusCost+=cost_per_km*connection.getDistance();
        }
        return totalBusCost;
    }

    private double getDriverCost() {
        double totalDriverCost = 0;
        for(int i=0; i<connectionsList.size()-1; i++){
            String stop1 = connectionsList.get(i);
            String stop2 = connectionsList.get(i+1);

            Connection connection = connectionRepository.findByCity1AndCity2(stop1, stop2);
            if(connection==null){
                connection = connectionRepository.findByCity1AndCity2(stop2, stop1); // if columns are in different order
            }
            double cost_per_hr = driverCostRepository.findByLineId(connection.getLineId()).getDriverCostPerHr();
            totalDriverCost+=cost_per_hr*connection.getDuration();
        }
        return totalDriverCost;
    }
}
