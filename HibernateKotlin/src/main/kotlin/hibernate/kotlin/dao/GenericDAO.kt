package hibernate.kotlin.dao

import hibernate.kotlin.utility.SessionFactoryUtil

/*
This class uses generics to define concrete definitions for insert, update and delete operations
so that you don't have to write them more than once. It also contains abstract methods for selecting that must be
defined in any implementing classes.
 */
abstract class GenericDAO<T>
{
    protected val sessionFactory = SessionFactoryUtil.sessionFactory

    fun insert(obj: T)
    {
        val session = sessionFactory.openSession()
        val transaction = session.beginTransaction()
        session.save(obj)
        transaction.commit()
        session.close()
    }

    fun update(obj: T)
    {
        val session = sessionFactory.openSession()
        session.update(obj)
        session.close()
    }

    fun delete(obj: T)
    {
        val session = sessionFactory.openSession()
        val transaction = session.beginTransaction()
        session.delete(obj)
        transaction.commit()
        session.close()
    }

    abstract fun selectOne(id: Int): T

    abstract fun selectAll(): List<T>
}