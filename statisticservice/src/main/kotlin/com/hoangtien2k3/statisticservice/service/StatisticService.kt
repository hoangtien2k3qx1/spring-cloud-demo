package com.hoangtien2k3.statisticservice.service

import com.hoangtien2k3.statisticservice.model.dto.StatisticDTO

interface StatisticService {
    fun add(statisticDTO: StatisticDTO)
    fun getAll(): List<StatisticDTO>
}