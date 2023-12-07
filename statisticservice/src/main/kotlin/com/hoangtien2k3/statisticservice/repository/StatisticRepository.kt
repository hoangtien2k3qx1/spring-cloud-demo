package com.hoangtien2k3.statisticservice.repository

import com.hoangtien2k3.statisticservice.model.entity.Statistic
import org.springframework.data.jpa.repository.JpaRepository

interface StatisticRepository : JpaRepository<Statistic, Long>