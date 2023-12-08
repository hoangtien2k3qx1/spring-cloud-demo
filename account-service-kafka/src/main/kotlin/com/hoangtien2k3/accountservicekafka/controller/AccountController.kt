package com.hoangtien2k3.accountservicekafka.controller

import com.hoangtien2k3.accountservicekafka.model.AccountDTO
import com.hoangtien2k3.accountservicekafka.model.MessageDTO
import com.hoangtien2k3.accountservicekafka.model.StatisticDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Date

@RestController
@RequestMapping("/account")
class AccountController @Autowired constructor(val kafkaTemplate: KafkaTemplate<String, Any>) {

    @PostMapping("/new")
    fun create(@RequestBody account: AccountDTO): AccountDTO {
        // Tạo và gửi thông báo thống kê
        val statistic = StatisticDTO("Account ${account.email} is created", Date())
        kafkaTemplate.send("statistic", statistic)

        // Tạo và gửi thông báo
        val messageDTO = MessageDTO(
            to = account.email,
            toName = account.name,
            subject = "Welcome to Demo Kafka by hoangtien2k3",
            content = "Learn Kafka following the basic project"
        )
        kafkaTemplate.send("notification", messageDTO)

        return account
    }
}
