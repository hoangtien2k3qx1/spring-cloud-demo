package com.hoangtien2k3.accountservice.entity

import jakarta.persistence.*

@Entity
@Table
class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(name = "name")
    var name: String,

    @Column(name = "password")
    var password: String,

    @Column(name = "username", unique = true)
    var username: String,

    @ElementCollection
    @CollectionTable(name = "user_role", joinColumns = [JoinColumn(name = "account_id")])
    @Column(name = "role")
    var roles: MutableSet<String> = HashSet()
)