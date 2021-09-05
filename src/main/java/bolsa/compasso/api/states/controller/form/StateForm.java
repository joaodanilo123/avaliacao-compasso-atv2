package bolsa.compasso.api.states.controller.form;

import bolsa.compasso.api.states.model.State;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StateForm {

    @NotNull
    @NotEmpty
    private String name;
    private String region;
    private long population;
    private String capital;
    private long area;

    public StateForm(){}

    public State convert(){
        return new State(name, region, population, capital, area);
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
