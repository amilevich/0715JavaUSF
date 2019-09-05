package hibernate.kotlin.dao

interface Insert<T>
{
    fun insert(obj: T)
}