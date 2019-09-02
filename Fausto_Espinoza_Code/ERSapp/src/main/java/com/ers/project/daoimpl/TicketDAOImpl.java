package com.ers.project.daoimpl;

import java.util.List;

import com.ers.project.dao.ticket.CreateTicketDAO;
import com.ers.project.dao.ticket.FindAllByStatusDAO;
import com.ers.project.dao.ticket.FindAllByStatusNameDAO;
import com.ers.project.dao.ticket.FindAllEmplTicketsDAO;
import com.ers.project.dao.ticket.UpdateTicketDAO;
import com.ers.project.interfaces.MainInterface;
import com.ers.project.model.ReimbursementTicket;
import com.ers.project.model.Ticket;

public class TicketDAOImpl implements MainInterface<ReimbursementTicket> {

	@Override
	public boolean createRecord(ReimbursementTicket t) {
		return CreateTicketDAO.createTicket(t);
	}

	@Override
	public ReimbursementTicket findRecordById(ReimbursementTicket t) {
		return null;
	}

	@Override
	public List<ReimbursementTicket> findAllRecord() {
		return null;
	}
	
	public List<ReimbursementTicket> findAllRecord(long t) {
		return FindAllByStatusDAO.findAll(t);
	}
	public List<ReimbursementTicket> findAllRecord(long t, long t1) {
		return FindAllEmplTicketsDAO.findAll(t, t1);
	}
	
	public List<Ticket> findAllTicket(long t){
		return FindAllByStatusNameDAO.findAll(t);
	}

	@Override
	public boolean updateRecord(ReimbursementTicket t) {
		return UpdateTicketDAO.updateTicket(t);
	}

	@Override
	public boolean deleteRecord(ReimbursementTicket t) {
		return false;
	}

}
