package com.hoangtien2k3.accountservice.service

import com.hoangtien2k3.accountservice.model.AccountDTO

interface AccountService {
    fun add(accountDTO: AccountDTO)
    fun update(accountDTO: AccountDTO)
    fun updatePassword(accountDTO: AccountDTO)
    fun delete(id: Long)
    fun getAll(): List<AccountDTO>
    fun getOne(id : Long): AccountDTO
}