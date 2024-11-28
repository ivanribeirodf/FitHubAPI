package com.ivanribeiro.FitHubAPI.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import com.ivanribeiro.FitHubAPI.MemberShipRole;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="tb_membership")
public class MembershipModel extends RepresentationModel<MembershipModel> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(example = "0361c0c4-8da6-11ef-88cd-cecb03cd8761")
	private UUID member_id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@Schema(description = "Referência ao usuário associado", example = "0361c0c4-8da6-11ef-88cd-cecb03cd8761")
	private UserModel user_id; 
	
	@Schema(example = "99.99", description = "Preço do plano")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero.")
    private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	@Schema(example = "Mensal", description = "Tipo de plano (mensal, anual, etc.)")
    @NotBlank(message = "O tipo de plano é obrigatório.")
    private MemberShipRole  membership_type;
	
	@Schema(example = "2024-01-01", description = "Data de início do plano")
	@NotNull(message = "A data de início é obrigatória.")
	private LocalDate start_date;
	
	@Schema(example = "2024-12-31", description = "Data de término do plano")
    private LocalDate end_date;
	
	@Schema(example = "ativo", description = "Status do plano")
    @NotBlank(message = "O status é obrigatório.")
    private String status;
	
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
    
    

}
