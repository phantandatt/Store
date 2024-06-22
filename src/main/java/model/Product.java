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

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
	@Id
	@Column(name = "ProductID")
	int productID;
	@Column(name = "productName")
	String name;
	@Column(name = "categoryid")
	int categoryID;
	@Column(name = "Description")
	String description;
	@Column(name = "price")
	int price;
	@Column(name = "stockQuantity")
	int stockQuantity;
	@Column(name = "unit_price")
	String unit_price;
	@Column(name = "imgpath")
	String imgPath;
	@Column(name = "color")
	String color;

	
}