package bolsa.compasso.api.states.controller;

import bolsa.compasso.api.states.model.State;
import bolsa.compasso.api.states.repository.StateRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class StateUpdateForm {

    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String region;
    @NotNull
    private long population;
    @NotNull
    @NotEmpty
    private String capital;
    @NotNull
    private long area;

    public State update(long id, StateRepository stateRepository){
        State state = stateRepository.getById(id);
        state.setName(this.name);
        state.setRegion(this.region);
        state.setPopulation(this.population);
        state.setCapital(this.capital);
        state.setArea(this.area);

        return state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }
}
