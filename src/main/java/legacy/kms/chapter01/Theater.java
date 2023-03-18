package legacy.kms.chapter01;

public class Theater {

    private final TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        if (audience.hasInvitation()) {
            Ticket ticket = ticketSeller.getTicket();
            audience.setTicket(ticket);
        } else {
            Ticket ticket = ticketSeller.getTicket();
            audience.minusAmount(ticket.getFee());
            ticketSeller.plusAmount(ticket.getFee());
            audience.setTicket(ticket);
        }
    }
}
