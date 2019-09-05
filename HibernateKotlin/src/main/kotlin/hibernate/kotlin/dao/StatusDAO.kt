package hibernate.kotlin.dao

import hibernate.kotlin.domains.Status
import org.hibernate.criterion.Restrictions

/*
Concrete class implementing the GenericDAO and supplying the type of Status.
 */
class StatusDAO : GenericDAO<Status>
{
    constructor() {}

    override fun selectOne(id: Int): Status
    {
        val session = sessionFactory.openSession()
        val criteria = session.createCriteria(Status::class.java).add(Restrictions.eq("statusId", id))
        val result: Status = criteria.uniqueResult() as Status
        session.close()
        return result
    }

    override fun selectAll(): List<Status>
    {
        val session = sessionFactory.openSession()
        val criteria = session.createCriteria(Status::class.java)
        val results = criteria.list() as List<Status>
        session.close()

        return results
    }

}