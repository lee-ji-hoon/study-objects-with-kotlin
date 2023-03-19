package legacy.kms.chapter01;

class TicketSeller {

    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience){
        Ticket ticket = ticketOffice.getTicket();
        long amount = audience.buy(ticket);
        ticketOffice.plusAmount(amount);
    }
}
