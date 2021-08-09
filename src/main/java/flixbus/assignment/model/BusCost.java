package flixbus.assignment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bus_cost")
public class BusCost {
    @Id
    private Integer lineId;
    private double busCostPerKm;

    public BusCost(Integer lineId, double busCostPerKm) {
        this.lineId = lineId;
        this.busCostPerKm = busCostPerKm;
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public double getBusCostPerKm() {
        return busCostPerKm;
    }

    public void setBusCostPerKm(double busCostPerKm) {
        this.busCostPerKm = busCostPerKm;
    }
}
