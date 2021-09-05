package bolsa.compasso.api.states.controller;

import bolsa.compasso.api.states.controller.dto.StateDTO;
import bolsa.compasso.api.states.controller.form.StateForm;
import bolsa.compasso.api.states.model.State;
import bolsa.compasso.api.states.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/states")
public class StateController {

    @Autowired
    StateRepository stateRepository;

    @GetMapping
    public ResponseEntity<List<StateDTO>> list(){
        List<State> states = stateRepository.findAll();

        if(states.size() == 0) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(StateDTO.converter(states));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateDTO> show(@PathVariable Long id){
        Optional<State> state = stateRepository.findById(id);
        if(state.isPresent()){
            return ResponseEntity.ok(new StateDTO(state.get()));
        }

        return ResponseEntity.notFound().build();

    }

    @PostMapping
    @Transactional
    public ResponseEntity<StateDTO> register(@RequestBody @Valid StateForm form, UriComponentsBuilder uriBuilder){
        State newState = form.convert();
        stateRepository.save(newState);

        URI uri = uriBuilder.path("/api/states/").buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(new StateDTO(newState));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<StateDTO> update(@RequestBody @Valid StateUpdateForm form, @PathVariable Long id){
        Optional<State> state = stateRepository.findById(id);
        if(state.isPresent()){
            return ResponseEntity.ok(new StateDTO(form.update(id, stateRepository)));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remove(@PathVariable Long id){
        Optional<State> state = stateRepository.findById(id);
        if(state.isPresent()){
            stateRepository.delete(state.get());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }



}
