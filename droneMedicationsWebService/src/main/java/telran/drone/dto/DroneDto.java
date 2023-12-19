package telran.drone.dto;


import jakarta.validation.constraints.*;

public record DroneDto(@NotNull @Pattern(regexp ="[a-zA-Z0-9]] {1,100}", message = "wrong serial number") String serialNumber,
		@NotNull(message = "wrong model") DroneModel model,
		@NotNull (message = "wrong weight") @Min (10) @Max (500)  int weightLimit,
		@NotNull (message = "wrong battary percent")@Min (0) @Max(100) double batteryPercent,
		@NotNull (message = "wrong state") DroneState state) {

}




