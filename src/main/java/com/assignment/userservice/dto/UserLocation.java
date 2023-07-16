package com.assignment.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLocation {
	private UserLocationStreet street;
    private String city;
    private String state;
    private String country;
    private String postcode;
    private UserLocationCoordinates coordinates;
    private UserLocationTimezone timezone;
}
