package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recoveryroomtypes")
public class RecoveryRoomType extends BaseEntity {
    //Id -> BaseEntity
	
	@NotNull
	@Length(min = 5, max = 50)
	@Column(name = "name", unique = true)
    String name;
}
