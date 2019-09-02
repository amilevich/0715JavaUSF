import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.expense.beans.Ticket;
import com.expense.dao.TicketDaoImpl;

public class Tests {

	TicketDaoImpl ticketDao= new TicketDaoImpl();
	
	@Test
	public void testClaimsById() {
		List<Ticket> ticketList = new ArrayList<Ticket>();
		assertEquals(ticketList, ticketDao.selectTicketsByEmpId(99995));
	}
	
	@Test
	public void testAllClaims() {
		List<Ticket> tickets = new ArrayList<Ticket>();
		assertEquals(tickets, ticketDao.selectAllTickets());
	}
	
	
	@Test
	public void testAllPendingClaims() {
		List<Ticket> ticketList = new ArrayList<Ticket>();
		assertEquals(ticketList, ticketDao.selectAllPendingTickets());
	}
	
	@Test
	public void testAllPendingClaimsById() {
		List<Ticket> ticketList = new ArrayList<Ticket>();
		assertEquals(ticketList, ticketDao.selectAllPendingTicketsById(99999));
	}
	
	@Test
	public void testAllResolvedClaims() {
		List<Ticket> ticketList = new ArrayList<Ticket>();
		assertEquals(ticketList, ticketDao.selectAllResolvedTickets());
	}
	
	
	
	

}
