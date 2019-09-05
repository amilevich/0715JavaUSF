package hibernate.kotlin.dao

interface Select<T>
{
    fun selectOne(id: Int): T

    fun selectAll(): Array<T>
}