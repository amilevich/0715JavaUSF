package hibernate.kotlin.domains

import javax.persistence.*

@Entity
@Table
class Status
{
    @Id
    @Column(name = "STATUS_ID")
    @SequenceGenerator(name="STATUS_ID_SEQ", sequenceName="STATUS_ID_SEQ")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "STATUS_ID_SEQ")
    var statusId: Int = 0

    @Column
    var status: String = ""

    constructor() {}

    constructor(statusId: Int, status: String)
    {
        this.statusId = statusId
        this.status = status
    }
}