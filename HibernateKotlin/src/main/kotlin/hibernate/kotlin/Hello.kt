package hibernate.kotlin

import hibernate.kotlin.dao.GenericDAO
import hibernate.kotlin.dao.Select
import hibernate.kotlin.dao.StatusDAO
import hibernate.kotlin.dao.UserDAO
import hibernate.kotlin.domains.Status
import hibernate.kotlin.domains.Users

fun main(args: Array<String>)
{
    //Create a userDAO and restrict it to type Select. This means that although the UserDAO has
    //other methods, it will only be able to call the select methods.
    val userDAO: Select<Users> = UserDAO()

    println("${userDAO.selectOne(1).firstName} ${userDAO.selectOne(1).lastName}")

    /*
    Create a StatusDAO
     */
    val statusDAO = StatusDAO()
    val status = Status()
    status.status = "limbo"

    /*
    Uses the insert method that the statusDAO inherits from GenericDAO to insert a new status.
     */
    statusDAO.insert(status)

    for (s in statusDAO.selectAll())
    {
        println(s.status)
    }
}


