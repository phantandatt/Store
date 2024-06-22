package respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Discount;
@Repository
public interface DiscountRepository extends JpaRepository<Discount, String> {

}
