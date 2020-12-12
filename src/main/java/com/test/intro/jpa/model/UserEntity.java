package com.test.intro.jpa.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class UserEntity.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "USERS", schema= "BCI")
public class UserEntity {

	/** The user id. */
	@Id
	@Column(name ="USER_ID")
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String userId;
	
	/** The insert date. */
	@Column(name ="INSERT_DATE")
	private LocalDateTime insertDate;
	
	/** The update date. */
	@Column(name ="UPDATE_DATE")
	private LocalDateTime updateDate;
	
	/** The user name. */
	@Column(name ="USER_NAME")
	private String userName;
	
	/** The user email. */
	@Column(name ="USER_EMAIL")
	private String userEmail;

	/** The user password. */
	@Column(name ="USER_PASSWORD")
	private String userPassword;
	
	/** The is active. */
	@Column(name ="IS_ACTIVE")
	private Boolean isActive;
	
	/** The last login. */
	@Column(name ="LAST_LOGIN")
	private LocalDateTime lastLogin;
	
	/** The token. */
	@Column(name ="TOKEN")
	private String token;

	/** The items. */
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private Set<PhonesEntity> phones;
	
}
