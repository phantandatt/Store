package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "bill")
public class Order {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "date")
	private String date;
	@Column(name = "total_Price")
	private int total_Price;
	@Column(name = "status")
	private String status;

}
