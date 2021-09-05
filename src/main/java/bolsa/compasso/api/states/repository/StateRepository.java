package bolsa.compasso.api.states.repository;

import bolsa.compasso.api.states.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {
    List<State> findAllByRegion(String region);
}
