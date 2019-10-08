
public final class Airplane {
    private int id;
    private int maxCapacity;
    private int currentCapacity;
    private boolean state;

    public Airplane(){}

    public Airplane(int id, int maxCapacity, int currentCapacity, boolean state) {
        this.id = id;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
        this.state = state;
    }

    public Airplane(int id, boolean state){
        this.id = id;
        this.maxCapacity = 0;
        this.currentCapacity = 0;
        this.state = state;
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
