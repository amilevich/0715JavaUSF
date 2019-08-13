package data.dao;

public interface CommonDAO<Id,Model> {   //Id can be Integer or String only
										 //Model -> Application, BankAccount, Customer, Employee, UserAccount
	Model getOne(Id id);
	Id insertOne(Model member);
	boolean updateOne(Model member);
	Integer deleteOne(Id id);
}
