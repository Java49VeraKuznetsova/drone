package telran.drone.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import telran.drone.dto.DroneDto;
import telran.drone.dto.DroneModel;
import telran.drone.dto.DroneState;
import jakarta.persistence.*;

@Entity
@Table(name = "drones")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@Getter

public class Drone {


	@Column(nullable = false, name = "serial_number")
	String serialNumber;
	
	@Enumerated(value=EnumType.STRING)
	@Column(nullable = false)
	DroneModel model;
	
	@Column(nullable = false, name = "weight_max")
	int weightLimit;
	
	@Column(nullable = false, name = "battery_in_percent")
	double batteryPercent;
	
	@Enumerated(value=EnumType.STRING)
	@Column(nullable = false)
	DroneState state;
	
	public Drone(DroneDto droneDto) {
		serialNumber = droneDto.serialNumber();
	    model = droneDto.model();
	    weightLimit = droneDto.weightLimit();
	    batteryPercent = droneDto.batteryPercent();
	    state = droneDto.state();
	
	}
	
	public DroneDto build() {
		
		return new DroneDto(serialNumber, model, weightLimit, batteryPercent, state);
	}
	

	public void setBatteryPercent(double batteryPercent) {
		this.batteryPercent = batteryPercent;
	}

	public void setState(DroneState state) {
		this.state = state;
	}

}
