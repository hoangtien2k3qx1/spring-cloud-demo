package com.hoangtien2k3.accountservice.repository

import com.hoangtien2k3.accountservice.model.entity.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long>