package legacy.kms.chapter01;

public class Audience {

    private final Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public long buy(Ticket ticket) {
        if(bag.hasInvitation()){
            bag.setTicket(ticket);
            return 0L;
        } else{
            bag.minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
}
