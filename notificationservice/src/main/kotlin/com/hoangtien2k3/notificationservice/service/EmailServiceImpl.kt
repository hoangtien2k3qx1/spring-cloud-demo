package com.hoangtien2k3.notificationservice.service

import com.hoangtien2k3.notificationservice.dto.MessageDTO
import jakarta.mail.MessagingException
import jakarta.mail.internet.MimeMessage
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.thymeleaf.context.Context
import org.thymeleaf.spring6.SpringTemplateEngine
import java.nio.charset.StandardCharsets

@Slf4j
@Service
class EmailServiceImpl @Autowired constructor(
    val javaMailSender: JavaMailSender,
    val springTemplateEngine: SpringTemplateEngine
) : EmailService {

    @Value("\${spring.mail.username}")
    lateinit var from: String

    @Async
    override fun sendEmail(messageDTO: MessageDTO) {
        try {
//            logger.info("Start ---> Send Email")
            val message: MimeMessage = javaMailSender.createMimeMessage()
            val helper: MimeMessageHelper = MimeMessageHelper(message, StandardCharsets.UTF_8.name())

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

//            logger.info("Send Email Successfully")
        } catch (ex: MessagingException) {
            ex.printStackTrace()
        }
    }


}