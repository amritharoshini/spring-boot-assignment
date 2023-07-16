package com.assignment.userservice.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
	private String gender;
    private UserName name;
    private UserLocation location;
    private String email;
    private UserLogin login;
    private UserDob dob;
    private UserDob registered;
    private String phone;
    private String cell;
    private UserId id;
    private UserPicture picture;
    private String nat;
}
