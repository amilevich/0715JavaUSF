package com.expense.dao;
import java.util.List;

import com.expense.beans.Ticket;

public interface TicketDao {
    
    //CREATE
    public void insertTicket(Ticket ticket);
        
    //READ
    public Ticket selectTicketsById(int claimid);
    public List<Ticket> selectTicketsByEmpId(int empid);
    public List<Ticket> selectAllTickets();
    public List<Ticket> selectAllPendingTickets();
    public List<Ticket> selectAllResolvedTickets();
        
    //UPDATE
    public void updateClaim(Ticket ticket);
    public void updateClaimToResolved(Ticket ticket);
    public void updateTicketToDenied(Ticket ticket);
        
    //DELETE
    public int deleteClaim(Ticket ticket);
}

