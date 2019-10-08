import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Airport {
    private String name = "International Airport";
    private List<Airplane> airplanes;

    public Airport() {
        this.airplanes = createAirplanes();
    }

    private List<Airplane> createAirplanes(){
        List<Airplane> airplanes = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            airplanes.add(new Airplane(i, i, i, true));
        }
        return airplanes;
    }

    public String getName() {
        return name;
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public void forEachAirplane(Consumer<? super Airplane> action) {
        getAirplanes().forEach(action);
    }
}
