package com.hoangtien2k3.accountservicekafka.model

import java.util.Date

class StatisticDTO(
    var message: String,
    var createdDate: Date
) {
    constructor() : this("", Date())
}