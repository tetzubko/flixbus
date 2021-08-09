package flixbus.assignment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "driver_cost")
public class DriverCost {
    @Id
    private Integer lineId;
    private double driverCostPerHr;

    public DriverCost(Integer lineId, double driverCostPerHr) {
        this.lineId = lineId;
        this.driverCostPerHr = driverCostPerHr;
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public double getDriverCostPerHr() {
        return driverCostPerHr;
    }

    public void setDriverCostPerHr(double driverCostPerHr) {
        this.driverCostPerHr = driverCostPerHr;
    }
}
