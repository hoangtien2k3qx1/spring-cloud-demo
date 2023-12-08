package com.hoangtien2k3.statisticservice.service.imp

import com.hoangtien2k3.statisticservice.model.dto.StatisticDTO
import com.hoangtien2k3.statisticservice.model.entity.Statistic
import com.hoangtien2k3.statisticservice.repository.StatisticRepository
import com.hoangtien2k3.statisticservice.service.StatisticService
import jakarta.transaction.Transactional
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@Transactional
class StatisticServiceImpl @Autowired constructor(
    val statisticRepository: StatisticRepository,
    val modelMapper: ModelMapper
) : StatisticService{

    override fun add(statisticDTO: StatisticDTO) {
        val statistic: Statistic = modelMapper.map(statisticDTO, Statistic::class.java)
        statisticRepository.save(statistic)
    }

    override fun getAll(): List<StatisticDTO> {
        return statisticRepository.findAll().let {
            list -> list.map {
                modelMapper.map(it, StatisticDTO::class.java)
            }
        }
    }

}