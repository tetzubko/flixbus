package flixbus.assignment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "connection")
public class Connection {
    @Id
    private String id;
    private Integer lineId;
    private String city1;
	private String city2;
	private double distance;
    private double duration;

	public Connection(Integer lineId, String city1, String city2, double distance, double duration) {
		this.lineId = lineId;
		this.city1 = city1;
		this.city2 = city2;
		this.distance = distance;
		this.duration = duration;
	}

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public String getCity1() {
        return city1;
    }

    public void setCity1(String city1) {
        this.city1 = city1;
    }

    public String getCity2() {
        return city2;
    }

    public void setCity2(String city2) {
        this.city2 = city2;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
