package com.hoangtien2k3.accountservicekafka.model

import lombok.Builder

@Builder
class MessageDTO(
    var to: String,
    var toName: String,
    var subject: String,
    var content: String
) {
    constructor() : this("", "", "", "")
}
