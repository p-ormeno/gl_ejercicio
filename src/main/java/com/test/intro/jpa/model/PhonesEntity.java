package com.test.intro.jpa.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Phones.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "PHONES", schema= "BCI")
public class PhonesEntity {

	@Id
	@Column(name ="PHONE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer phoneId;

	/** The insert date. */
	@Column(name ="INSERT_DATE")
	private LocalDateTime insertDate;
	
	@Column(name ="PHONE_NUMBER")
	private Integer phoneNumber;
	
	@Column(name ="CITY_CODE")
	private Integer cityCode;
	
	@Column(name ="COUNTRY_CODE")
	private Integer countryCode;
	
	/** The user. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable = false)
	private UserEntity user;
}	
