package com.assignment.userservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User2 {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@OneToOne
	@JoinColumn(name = "ref_id", referencedColumnName = "id" )
	private User user;
	private String email;
}
