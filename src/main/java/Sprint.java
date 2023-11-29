public class Sprint {
    private int count = 0;
    private int totalEstimate = 0;
    private final int capacity;
    private final Ticket[] listTickets;
    private final int ticketsLimit;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        this.listTickets = new Ticket[ticketsLimit];
    }

    private boolean validateTicket(Ticket ticket) {
        if (ticket == null) {
            return false;
        }
        if (ticket.isCompleted()) {
            return false;
        }
        if (count + 1 > ticketsLimit) {
            return false;
        }
        if (totalEstimate + ticket.getEstimate() > capacity) {
            return false;
        }
        return true;
    }

    public boolean addUserStory(UserStory userStory){
        if (!validateTicket(userStory)) {
            return false;
        }

        for (UserStory dependency : userStory.getDependencies()) {
            if (dependency.isCompleted()) {
                continue;
            }

            boolean isInSprint = false;
            for (Ticket ticket : listTickets) {
                if (ticket.getId() == dependency.getId()) {
                    isInSprint = true;
                    break;
                }
            }
            if (!isInSprint) {
                return false;
            }
        }

        listTickets[count++] = userStory;
        totalEstimate += userStory.getEstimate();
        return true;
    }

    public boolean addBug(Bug bugReport){
        if (!validateTicket(bugReport)) {
            return false;
        }
        listTickets[count++] = bugReport;
        totalEstimate += bugReport.getEstimate();
        return true;
    }

    public Ticket[] getTickets(){
        return listTickets;
    }

    public int getTotalEstimate(){
        return totalEstimate;
    }
}
