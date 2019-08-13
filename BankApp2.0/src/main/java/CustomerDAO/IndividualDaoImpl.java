package CustomerDAO;

import java.util.List;

import com.bank.app.mainInterface.IndividualDAO;
import com.mybank.app.Individual;

public class IndividualDaoImpl implements IndividualDAO {

	CreateCustomerDAO indiv = new CreateCustomerDAO();
	@Override
	public int insertIndividual(Individual individual) {
		// TODO Auto-generated method stub
		return indiv.createIndividual(individual);
	}

	@Override
	public Individual selectIndividualByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Individual> selectAllIndividual() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateIndividual(Individual individual) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteIndividual(Individual individual) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

}
