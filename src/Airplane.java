import org.jetbrains.annotations.Contract;

import java.util.Random;

public final class Airplane {
    private int id;
    private int maxCapacity;
    private int currentCapacity;
    private boolean state;

    @Contract(pure = true)
    public Airplane(){}

    public Airplane(int id, int maxCapacity, int currentCapacity, boolean state) {
        this.id = id;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
        this.state = state;
    }

    public Airplane(int id){
        this.id = id;
        this.maxCapacity = generateRandomIntIntRange(10, 20);
        this.currentCapacity = generateRandomIntIntRange(1, 10);
        this.state = new Random().nextBoolean();
    }

    public String removePassenger(int quantity){
        if (currentCapacity == 0) return "Imposible to remove, current capacity is 0";

        if (currentCapacity - quantity < 0) return "Current passengers are " + currentCapacity + " Imposible to remove " + (quantity - currentCapacity) + " passengers";

        currentCapacity = currentCapacity - quantity;

        return "Removed " + quantity + " passengers, " + currentCapacity + " passengers left";
    }

    public String addPassenger(int quantity){
        if (currentCapacity == maxCapacity) return "Imposible to add " + quantity + " passenger, max capacity is " + maxCapacity + ", current passengers are " + currentCapacity;

        if (currentCapacity + quantity > maxCapacity) return "Max capacity is " + maxCapacity + " Imposible to add " + (quantity + currentCapacity - maxCapacity) + " passengers";

        currentCapacity = currentCapacity + quantity;

        return "Added " + quantity + " passengers, " + currentCapacity + " passengers are";
    }

    private int generateRandomIntIntRange(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public int getId() {
        return id;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public boolean isState() {
        return state;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", maxCapacity=" + maxCapacity +
                ", currentCapacity=" + currentCapacity +
                ", state=" + state +
                '}';
    }
}
