package com.assignment.userservice.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assignment.userservice.dto.UserDob;
import com.assignment.userservice.dto.UserDto;
import com.assignment.userservice.dto.UserId;
import com.assignment.userservice.dto.UserLocation;
import com.assignment.userservice.dto.UserLocationCoordinates;
import com.assignment.userservice.dto.UserLocationStreet;
import com.assignment.userservice.dto.UserLocationTimezone;
import com.assignment.userservice.dto.UserLogin;
import com.assignment.userservice.dto.UserName;
import com.assignment.userservice.dto.UserPicture;
import com.assignment.userservice.dto.UserResults;
import com.assignment.userservice.model.User;
import com.assignment.userservice.model.User2;
import com.assignment.userservice.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final UserRepository userRepository;
	
	
	public void createUsers() {
		UserResults users = this.restTemplate.getForObject("https://randomuser.me/api/?results=10", UserResults.class);
		users.getResults().forEach(user -> saveToDb(user));
	}


	public UserDto getUserByEmail(String email) {
		Optional<User> user = this.userRepository.findByEmail(email);
		return mapUserToDto(user.get());
	}
	
	private void saveToDb(UserDto userDto) {
		User user = mapDtoToUser(userDto);
		this.userRepository.save(user);
	}
	
	private User mapDtoToUser(UserDto userDto) {
		return User.builder()
				.gender(userDto.getGender())
				.nameTitle(userDto.getName().getTitle())
				.nameFirst(userDto.getName().getFirst())
				.nameLast(userDto.getName().getLast())
				.locationStreetNumber(userDto.getLocation().getStreet().getNumber())
				.locationStreetName(userDto.getLocation().getStreet().getName())
				.locationCity(userDto.getLocation().getCity())
				.locationState(userDto.getLocation().getState())
				.locationCountry(userDto.getLocation().getCountry())
				.locationPostcode(userDto.getLocation().getPostcode())
				.locationCoordinatesLatitude(userDto.getLocation().getCoordinates().getLatitude())
				.locationCoordinatesLongitude(userDto.getLocation().getCoordinates().getLongitude())
				.locationTimezoneDescription(userDto.getLocation().getTimezone().getDescription())
				.locationTimezoneOffset(userDto.getLocation().getTimezone().getOffset())
				.email(userDto.getEmail())
				.loginUuid(userDto.getLogin().getUuid())
				.loginUsername(userDto.getLogin().getUsername())
				.loginPassword(userDto.getLogin().getPassword())
				.loginSalt(userDto.getLogin().getSalt())
				.loginSha1(userDto.getLogin().getSha1())
				.loginSha256(userDto.getLogin().getSha256())
				.dobDate(userDto.getDob().getDate())
				.dobAge(userDto.getDob().getAge())
				.registeredDate(userDto.getRegistered().getDate())
				.registeredAge(userDto.getRegistered().getAge())
				.phone(userDto.getPhone())
				.cell(userDto.getCell())
				.idName(userDto.getId().getName())
				.idValue(userDto.getId().getValue())
				.pictureMedium(userDto.getPicture().getMedium())
				.pictureLarge(userDto.getPicture().getLarge())
				.pictureThumbnail(userDto.getPicture().getThumbnail())
				.nat(userDto.getNat())
				.build();
	}
	
	private UserDto mapUserToDto(User user) {
		UserName name = UserName.builder()
				.title(user.getNameTitle())
				.first(user.getNameFirst())
				.last(user.getNameLast())
				.build();
		UserLocationStreet street = UserLocationStreet.builder()
				.name(user.getLocationStreetName())
				.number(user.getLocationStreetNumber())
				.build();
		UserLocationCoordinates coordinates = UserLocationCoordinates.builder()
				.latitude(user.getLocationCoordinatesLatitude())
				.longitude(user.getLocationCoordinatesLongitude())
				.build();
		UserLocationTimezone timezone = UserLocationTimezone.builder()
				.offset(user.getLocationTimezoneOffset())
				.description(user.getLocationTimezoneDescription())
				.build();
		UserLocation location = UserLocation.builder()
				.street(street)
				.city(user.getLocationCity())
				.state(user.getLocationState())
				.country(user.getLocationCountry())
				.postcode(user.getLocationPostcode())
				.coordinates(coordinates)
				.timezone(timezone)
				.build();
		UserLogin login = UserLogin.builder()
				.uuid(user.getLoginUuid())
				.username(user.getLoginUsername())
				.password(user.getLoginPassword())
				.salt(user.getLoginSalt())
				.md5(user.getLoginMd5())
				.sha1(user.getLoginSha1())
				.sha256(user.getLoginSha256())
				.build();
		UserDob dob = UserDob.builder()
				.date(user.getDobDate())
				.age(user.getDobAge())
				.build();
		UserDob registered = UserDob.builder()
				.date(user.getRegisteredDate())
				.age(user.getRegisteredAge())
				.build();
		UserId id = UserId.builder()
				.name(user.getIdName())
				.value(user.getIdValue())
				.build();
		UserPicture picture = UserPicture.builder()
				.large(user.getPictureLarge())
				.medium(user.getPictureMedium())
				.thumbnail(user.getPictureThumbnail())
				.build();
		return UserDto.builder()
				.gender(user.getGender())
				.name(name)
				.location(location)
				.email(user.getEmail())
				.login(login)
				.dob(dob)
				.registered(registered)
				.phone(user.getPhone())
				.cell(user.getCell())
				.id(id)
				.picture(picture)
				.nat(user.getNat())
				.build();
	}
}
 