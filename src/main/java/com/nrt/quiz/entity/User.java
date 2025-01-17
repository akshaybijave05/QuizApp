package com.nrt.quiz.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users_detail")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int Id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "user_type")
	private String userType;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "password")
	private String password;

	@Column(name = "image_Path")
	private String imagePath;

	@Column(name = "phone")
	private String phone;
	
	@Column(name = "status")
	private int status;

	@Column(name = "address")
	private String address;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	@Column(name = "account_creation_date")
	private LocalDate CreationDate;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Set<UserPlayedQuizHistory> quizzes;

	@PrePersist
	protected void onCreate() {
		CreationDate = LocalDate.now();
	}

}
