public abstract class Ticket {
    private String name;
    private int id;
    private int estimate;
    private boolean isCompleted = false;


    public Ticket(int id, String name, int estimate) {
        this.name = name;
        this.id = id;
        this.estimate = estimate;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getEstimate() {
        return estimate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void complete() {
        isCompleted = true;
    }
}