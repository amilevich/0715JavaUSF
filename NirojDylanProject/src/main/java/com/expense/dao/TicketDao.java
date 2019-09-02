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
    public List<Ticket> selectAllPendingTicketsById(int empid);//created by Niroj
        
    //UPDATE
    public void updateClaim(Ticket ticket);
    public void updateClaimToResolved(Ticket ticket);
    public void updateTicketToDenied(Ticket ticket);
    public void updateTicketToApprove(int cliamId);
    public void updateTicketToReject(int cliamId);
    //DELETE
    public int deleteClaim(Ticket ticket);
}

