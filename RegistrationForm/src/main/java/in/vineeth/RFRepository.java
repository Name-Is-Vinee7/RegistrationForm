package in.vineeth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RFRepository extends JpaRepository<FormRegistration, Integer> {

	Optional<FormRegistration> findByusername(String username);

}
