package com.hoangtien2k3.notificationservice.service

import com.hoangtien2k3.notificationservice.dto.MessageDTO
import jakarta.mail.MessagingException
import jakarta.mail.internet.MimeMessage
import org.hibernate.type.StandardBasicTypes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMailMessage
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import org.thymeleaf.context.Context
import org.thymeleaf.spring6.SpringTemplateEngine
import java.nio.charset.StandardCharsets

@Service
class EmailServiceImpl @Autowired constructor(
    val javaMailSender: JavaMailSender,
    val springTemplateEngine: SpringTemplateEngine
) : EmailService {

    override fun sendEmail(messageDTO: MessageDTO) {
        try {

//            log.info("Start ---> Send Email")

            var message: MimeMessage = javaMailSender.createMimeMessage()
            var helper: MimeMessageHelper = MimeMessageHelper(message, StandardCharsets.UTF_8.name())

            // load template email with context
            val context = Context()
            context.setVariable("name", messageDTO.toName)
            context.setVariable("content", messageDTO.content)
            val html: String = springTemplateEngine.process("welcom-email", context)

            // send email
            helper.setTo(messageDTO.to)
            helper.setText(html, true)
            helper.setSubject(messageDTO.subject)
            helper.setFrom(messageDTO.from)
            javaMailSender.send(message)

//            log.info("Send Email Successfully")

        } catch (ex: MessagingException) {
            ex.printStackTrace()
        }
    }


}