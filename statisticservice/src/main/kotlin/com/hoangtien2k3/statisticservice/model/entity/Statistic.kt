package com.hoangtien2k3.statisticservice.model.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.util.Date

@Entity
@Table(name = "statistic")
class Statistic(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(name = "message")
    var message: String?,

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    var createdDate: Date
)