import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.revature.util.SessionFactoryUtil;

import antlr.collections.List;

public class BearDaoImpl{
	SessionFactory sf=SessionFactoryUtil.getSessionFactory();
	
	public void queryDemo(){
		Session sess=sf.openSession();
		String hql="From Bear as b Where b.breed =:type";
		Query query=sess.createQuery(hql);
		query.setParameter("type", "polar");
		List<Bear>bears=query.list();
		
		
		SQLQuery nativeSqlQuery=sess.createSQLQuery("Select * from bears when breed=" +breed);
	}
}
