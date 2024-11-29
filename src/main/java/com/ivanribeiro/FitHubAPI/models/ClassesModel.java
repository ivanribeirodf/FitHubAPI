package com.ivanribeiro.FitHubAPI.models;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tp_classes")
public class ClassesModel extends RepresentationModel<ClassesModel> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Schema(example = "0361c0c4-8da6-11ef-88cd-cecb03cd8761")
	private UUID classe_id;  
	
	@Schema(example = "Spinning")
	private String classe_name;  
	
	private trainer_id (FK -> trainers.id)  
	start_time  
	end_time  
	capacity  
	created_at  
	updated_at 

}
