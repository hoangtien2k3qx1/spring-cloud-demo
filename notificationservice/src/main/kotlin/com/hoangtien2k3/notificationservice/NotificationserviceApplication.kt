package com.hoangtien2k3.notificationservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class NotificationserviceApplication

fun main(args: Array<String>) {
	runApplication<NotificationserviceApplication>(*args)
}

