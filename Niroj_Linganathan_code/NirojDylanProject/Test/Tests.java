import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
        assertNotEquals(ticketList, ticketDao.selectTicketsByEmpId(9000));
    }
    
    @Test
    public void testAllClaims() {
        List<Ticket> tickets = new ArrayList<Ticket>();
        tickets=ticketDao.selectAllTickets();
        assertNotEquals(tickets, ticketDao.selectAllTickets());
    }
    
    
    @Test
    public void testAllPendingClaims() {
        List<Ticket> ticketList = new ArrayList<Ticket>();
        assertNotEquals(ticketList, ticketDao.selectAllPendingTickets());
    }
    
    @Test
    public void testAllPendingClaimsById() {
        List<Ticket> ticketList = new ArrayList<Ticket>();
        assertEquals(ticketList, ticketDao.selectAllPendingTicketsById(99999));
    }
    
   
    
	}


