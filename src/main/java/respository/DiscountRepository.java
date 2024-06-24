package respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import model.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, String> {

	@Modifying
	@Transactional
	@Query("UPDATE Discount a SET a.value = :newValue WHERE a.code = :code")
	public int updateVauleOfCode(String code, int newValue);
}
