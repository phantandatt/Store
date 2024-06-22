package respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;
import model.Product;

@Repository
public interface ProductRespository extends JpaRepository<Product, Integer> {

	public Product findById(int productId);

	public List<Product> findByNameContaining(String name);
}
