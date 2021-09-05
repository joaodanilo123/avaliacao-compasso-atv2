package bolsa.compasso.api.states.controller.dto;

import bolsa.compasso.api.states.model.State;

import java.util.ArrayList;
import java.util.List;

public class StateDTO {
    private long id;
    private final String name;
    private final String region;
    private final long population;
    private final String capital;
    private final long area;

    public StateDTO(State state){
        if (state.getId() != null)  this.id = state.getId();
        this.name = state.getName();
        this.region = state.getRegion();
        this.population = state.getPopulation();
        this.capital = state.getCapital();
        this.area = state.getArea();
    }

    public static List<StateDTO> converter(List<State> states) {
        List<StateDTO> dtos = new ArrayList<>();

        for (State state : states) {
            dtos.add(new StateDTO(state));
        }

        return dtos;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public long getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }

    public long getArea() {
        return area;
    }
}
