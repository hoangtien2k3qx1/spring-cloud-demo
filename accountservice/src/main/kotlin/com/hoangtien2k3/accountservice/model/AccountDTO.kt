package com.hoangtien2k3.accountservice.model

import lombok.Data

@Data
class AccountDTO(
    var id: Long,
    var name: String,
    var password: String,
    var username: String,
    var roles: MutableSet<String>
)
