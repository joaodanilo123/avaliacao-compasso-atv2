package bolsa.compasso.api.states.controller.filter;

import bolsa.compasso.api.states.controller.dto.StateDTO;
import bolsa.compasso.api.states.model.State;
import bolsa.compasso.api.states.repository.StateRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StateFilter {

    private final StateRepository stateRepository;
    private String orderBy = "ANY";
    private String region = "ANY";

    public StateFilter(String orderBy, String region, StateRepository stateRepository){
        this.stateRepository = stateRepository;

        if(orderBy != null) this.orderBy = orderBy.toUpperCase();
        if(region != null) this.region = region.toUpperCase();

    }

    public List<State> getResults(){
        return order(orderBy, filterByRegion(region));
    }

    private List<State> filterByRegion(String region){
        List<State> states = new ArrayList<>();
        if (region.equals("ANY")){
            states = stateRepository.findAll();
        } else states = stateRepository.findAllByRegion(region);

        return states;
    }

    private List<State> order(String orderBy, List<State> filteredList){
        switch (orderBy){
            case "AREA":
                filteredList.sort(Comparator.comparing(State::getArea));
                break;
            case "POPULATION":
                filteredList.sort(Comparator.comparing(State::getPopulation));
                break;
            default: break;
        }

        return filteredList;
    }

}
