package com.ivanribeiro.FitHubAPI.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import com.ivanribeiro.FitHubAPI.SpecialtyRole;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_trainers")
public class TrainersModel extends RepresentationModel<TrainersModel> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Schema(example = "0361c0c4-8da6-11ef-88cd-cecb03cd8761")
	private UUID trainer_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", nullable = false)
	private UserModel user_id;
	
	@Schema(example = "Musculação")
	private SpecialtyRole specialty; //(e.g., musculação, yoga)  
	
	@Schema(example = "10")
	private Integer experience_years;  
	
	@Schema(description = "Data de criação do registro", example = "2024-11-27T12:00:00")
    private LocalDateTime created_at;

    @Schema(description = "Data de atualização do registro", example = "2024-11-27T15:00:00")
    private LocalDateTime updated_at;  
    
    @PrePersist
    protected void onCreate() {
        this.created_at = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = LocalDateTime.now();
    }

	public UUID getTrainer_id() {
		return trainer_id;
	}

	public void setTrainer_id(UUID trainer_id) {
		this.trainer_id = trainer_id;
	}

	public UserModel getUser_id() {
		return user_id;
	}

	public void setUser_id(UserModel user_id) {
		this.user_id = user_id;
	}

	public SpecialtyRole getSpecialty() {
		return specialty;
	}

	public void setSpecialty(SpecialtyRole specialty) {
		this.specialty = specialty;
	}

	public Integer getExperience_years() {
		return experience_years;
	}

	public void setExperience_years(Integer experience_years) {
		this.experience_years = experience_years;
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
    
    

}
