package com.hoangtien2k3.notificationservice.controller

import com.hoangtien2k3.notificationservice.dto.MessageDTO
import com.hoangtien2k3.notificationservice.service.EmailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class NotificationController @Autowired constructor(
    val emailService: EmailService
){
    @PostMapping("/send-notification")
    fun sendNotification(@RequestBody messageDTO: MessageDTO) {
        emailService.sendEmail(messageDTO)
    }
}