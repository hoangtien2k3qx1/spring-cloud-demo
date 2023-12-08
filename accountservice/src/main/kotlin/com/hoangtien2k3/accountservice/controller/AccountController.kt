package com.hoangtien2k3.accountservice.controller

import com.hoangtien2k3.accountservice.model.dto.AccountDTO
import com.hoangtien2k3.accountservice.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@Controller
@RestController
class AccountController @Autowired constructor(val accountService: AccountService) {

    @PostMapping("/account")
    fun addAccount(@RequestBody accountDTO: AccountDTO): ResponseEntity<AccountDTO> {
        accountService.add(accountDTO)
        return ResponseEntity.ok(accountDTO)
    }

    @GetMapping("/accounts")
    fun getAll(): List<AccountDTO> {
        return accountService.getAll()
    }

    @GetMapping("account/{id}")
    fun get(@PathVariable(name = "id") id: Long): ResponseEntity<AccountDTO> {
        return Optional.of(ResponseEntity<AccountDTO>(accountService.getOne(id), HttpStatus.OK))
            .orElse(ResponseEntity<AccountDTO>(HttpStatus.NOT_FOUND))
    }

    @PutMapping("/account")
    fun update(@RequestBody accountDTO: AccountDTO) {
        accountService.update(accountDTO)
    }

    @DeleteMapping("/account/{id}")
    fun delete(@PathVariable(name = "id") id: Long) {
        accountService.delete(id)
    }

}