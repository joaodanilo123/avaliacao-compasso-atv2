package bolsa.compasso.api.states.repository;

import bolsa.compasso.api.states.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
