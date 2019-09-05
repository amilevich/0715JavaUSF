package hibernate.kotlin.domains

import javax.persistence.*

@Entity
@Table
class Users
{
    @Id
    @Column(name = "USER_ID")
    @SequenceGenerator(name="USER_ID_SEQ", sequenceName="USER_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "USER_ID_SEQ")
    var userId: Int = 0

    @Column(name = "USER_NAME")
    lateinit var userName: String

    @Column(name = "PASSWORD")
    lateinit var password: String

    @Column(name = "FIRST_NAME")
    lateinit var firstName: String

    @Column(name = "LAST_NAME")
    lateinit var lastName: String

    @Column(name = "TYPE")
    lateinit var type: String

    constructor() {}

    constructor(userId: Int, userName: String, password: String, firstName: String,
                lastName: String, type: String)
    {
        this.userId = userId
        this.userName = userName
        this.password = password
        this.firstName = firstName
        this.lastName = lastName
        this.type = type
    }
}