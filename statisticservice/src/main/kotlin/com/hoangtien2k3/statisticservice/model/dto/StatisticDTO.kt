package com.hoangtien2k3.statisticservice.model.dto

import lombok.Data
import java.util.Date

@Data
class StatisticDTO(
    var id: Long,
    var message: String,
    var createdDate: Date
)