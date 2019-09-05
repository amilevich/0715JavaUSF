package hibernate.kotlin.dao

interface Delete<T>
{
    fun delete(obj: T)
}