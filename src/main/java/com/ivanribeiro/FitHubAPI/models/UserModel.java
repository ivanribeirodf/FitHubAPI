package com.ivanribeiro.FitHubAPI.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ivanribeiro.FitHubAPI.UserRole;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="tb_users")
public class UserModel extends RepresentationModel<UserModel>  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Schema(example = "0361c0c4-8da6-11ef-88cd-cecb03cd8761")
	private UUID 		user_id;
	
	@Schema(example = "Ivan Ribeiro")
	private String 		user_name;
	
	@Schema(example = "23/09/1990")
	private LocalDate	user_birthdate;
	
	@Schema(example = "Rua das Árvores Azuis, Res. Cassimiro, Bloco D, Apart 703")
	private String 		user_address;
	
	@JsonIgnore
	@Schema(example = "$2a$10$")
	private String 		user_password;
	
	@Schema(example = "Record creation date and time 2024-11-27T12:00:00")
	private LocalDateTime 	created_at;
	
	@Schema(example = "Date and time the record was last updated 2024-11-27T15:00:00")
	private LocalDateTime		updated_at;
	
	@PrePersist
    protected void onCreate() {
        this.created_at = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = LocalDateTime.now();
    }
	
	@Pattern(regexp = ".+@.+\\..+", message = "O email deve ser válido.")
	private String user_email;

	@Pattern(regexp = "\\d{10,15}", message = "O telefone deve conter apenas números, entre 10 e 15 dígitos.")
	private String user_phone;	
	
	
	@Enumerated(EnumType.STRING)
    @Schema(example = "STUDENT", description = "Role do usuário (ADMIN, TRAINER, STUDENT)")
    private UserRole user_role; 
	
	public UUID getUser_id() {
		return user_id;
	}
	public void setUser_id(UUID user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}	
	
	public LocalDate getUser_birthdate() {
		return user_birthdate;
	}

	public void setUser_birthdate(LocalDate user_birthdate) {
		this.user_birthdate = user_birthdate;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public UserRole getUser_role() {
		return user_role;
	}

	public void setUser_role(UserRole user_role) {
		this.user_role = user_role;
	}
	
	
}	
