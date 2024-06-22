package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
	@Id
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "dob")
	private String dob;
	@Column(name = "email")
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "role")
	private int role;

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", dob=" + dob + ", email=" + email
				+ ", address=" + address + ", role=" + role + "]";
	}

}