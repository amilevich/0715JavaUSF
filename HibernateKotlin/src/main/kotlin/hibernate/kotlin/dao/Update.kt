package hibernate.kotlin.dao

interface Update<T>
{
    fun update(obj: T)
}