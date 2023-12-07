package com.hoangtien2k3.statisticservice.controller

import com.hoangtien2k3.statisticservice.model.dto.StatisticDTO
import com.hoangtien2k3.statisticservice.service.StatisticService
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import kotlin.math.log

@RestController
@Slf4j
class StatisticController @Autowired constructor(var statisticService: StatisticService) {

    @PostMapping("/statistic")
    fun add(@RequestBody statisticDTO: StatisticDTO): ResponseEntity<StatisticDTO> {
//        log.info("Add statistic: {}", statisticDTO)

        try {
            Thread.sleep(10000)
        } catch (exception: InterruptedException) {
            exception.printStackTrace()
        }

        statisticService.add(statisticDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(statisticDTO)
    }

    @GetMapping("/statistics")
    fun getAll(): List<StatisticDTO> {
        return statisticService.getAll()
    }

}
