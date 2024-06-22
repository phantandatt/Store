package respository;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Cart;

public interface CartRespository extends JpaRepository<Cart, Long> {

	 @Query("SELECT DISTINCT c FROM Cart c WHERE c.username = :username")
	public List<Cart> findByUsername( String username);

}
