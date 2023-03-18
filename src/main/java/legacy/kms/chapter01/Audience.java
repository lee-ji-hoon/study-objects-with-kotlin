package legacy.kms.chapter01;

public class Audience {

    private final Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public boolean hasInvitation() {
        return bag.hasInvitation();
    }

    public void setTicket(Ticket ticket) {
        bag.setTicket(ticket);
    }

    public void plusAmount(Long amount) {
        bag.plusAmount(amount);
    }

    public void minusAmount(Long amount) {
        bag.minusAmount(amount);
    }
}
