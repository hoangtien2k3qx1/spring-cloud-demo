package com.hoangtien2k3.notificationservice.service

import com.hoangtien2k3.notificationservice.dto.MessageDTO
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Slf4j
@Service
class MessageService @Autowired constructor(val emailService: EmailService) {
    @KafkaListener(id = "notificationGroup", topics = ["notification"])
    fun listen(messageDTO: MessageDTO) {
        try {
            emailService.sendEmail(messageDTO)
        } catch (e: Exception) {
//            log.error("Error processing Kafka message", e)
        }
    }

}