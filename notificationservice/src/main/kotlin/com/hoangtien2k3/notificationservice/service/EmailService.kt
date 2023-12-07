package com.hoangtien2k3.notificationservice.service

import com.hoangtien2k3.notificationservice.dto.MessageDTO

interface EmailService {
    fun sendEmail(messageDTO: MessageDTO)
}