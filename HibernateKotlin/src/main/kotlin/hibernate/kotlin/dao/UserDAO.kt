package hibernate.kotlin.dao

import hibernate.kotlin.domains.Users
import hibernate.kotlin.utility.SessionFactoryUtil
import org.hibernate.criterion.Restrictions

/*
Class implementing several of the CRUD interfaces and specifying the type for them.
 */
class UserDAO : Select<Users>, Insert<Users>
{
    private val sessionFactory = SessionFactoryUtil.sessionFactory

    override fun insert(obj: Users)
    {
        val session = sessionFactory.openSession()
        val transaction = session.beginTransaction()
        session.save(obj)
        transaction.commit()
        session.close()
    }

    override fun selectOne(id: Int): Users
    {
        val session = sessionFactory.openSession()
        val criteria = session.createCriteria(Users::class.java).add(Restrictions.eq("userId", id))
        val result: Users = criteria.uniqueResult() as Users
        session.close()
        return result
    }

    override fun selectAll(): Array<Users>
    {
        val session = sessionFactory.openSession()
        val criteria = session.createCriteria(Users::class.java)
        val results: Array<Users> = criteria.list() as Array<Users>
        session.close()

        return results
    }

}