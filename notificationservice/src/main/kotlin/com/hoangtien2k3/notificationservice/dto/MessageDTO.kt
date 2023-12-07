package com.hoangtien2k3.notificationservice.dto

import lombok.Data

@Data
class MessageDTO(
    var from: String,
    var to: String,
    var toName: String,
    var subject: String,
    var content: String
)