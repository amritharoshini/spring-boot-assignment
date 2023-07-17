package com.assignment.userservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gender;
    private String nameTitle;
    private String nameFirst;
    private String nameLast;
    private Integer locationStreetNumber;
    private String locationStreetName;
    private String locationCity;
    private String locationState;
    private String locationCountry;
    private String locationPostcode;
    private String locationCoordinatesLatitude;
    private String locationCoordinatesLongitude;
    private String locationTimezoneOffset;
    private String locationTimezoneDescription;
    private String email;
    private String loginUuid;
    private String loginUsername;
    private String loginPassword;
    private String loginSalt;
    private String loginMd5;
    private String loginSha1;
    private String loginSha256;
    private String dobDate;
    private Integer dobAge;
    private String registeredDate;
    private Integer registeredAge;
    private String phone;
    private String cell;
    private String idName;
    private String idValue;
    private String pictureLarge;
    private String pictureMedium;
    private String pictureThumbnail;
    private String nat;
}
