package com.hoangtien2k3.accountservice.service.impl

import com.hoangtien2k3.accountservice.entity.Account
import com.hoangtien2k3.accountservice.model.AccountDTO
import com.hoangtien2k3.accountservice.repository.AccountRepository
import com.hoangtien2k3.accountservice.service.AccountService
import jakarta.transaction.Transactional
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Transactional
@Service
class AccountServiceImpl @Autowired constructor(
    private val accountRepository: AccountRepository,
    private val modelMapper: ModelMapper,
//    private val passwordEncoder: BCryptPasswordEncoder
) : AccountService {

    override fun add(accountDTO: AccountDTO) {
        val account: Account = modelMapper.map(accountDTO, Account::class.java)
//        account.password = passwordEncoder.encode(accountDTO.password)
        accountRepository.save(account)
        accountDTO.id = account.id
    }

    override fun update(accountDTO: AccountDTO) {
        try {
            val account: Account = accountRepository.getById(accountDTO.id)

            account.let {
//                modelMapper.typeMap(AccountDTO::class.java, Account::class.java)
//                    .addMappings {
//                        mapper -> mapper.skip(Account::password)
//                    }

                modelMapper.map(accountDTO, it)
                accountRepository.save(it)
            }
        } catch (e: Exception) {
            throw RuntimeException("Failed to update account", e)
        }
    }

    override fun updatePassword(accountDTO: AccountDTO) {
        val account: Account = accountRepository.getById(accountDTO.id)
//        account.password = passwordEncoder.encode(accountDTO.password)
        accountRepository.save(account)
    }


    override fun delete(id: Long) {
        val account: Account = accountRepository.getById(id)
        accountRepository.delete(account)
    }

    override fun getAll(): List<AccountDTO> {
//        val accountDTOs: MutableList<AccountDTO> = mutableListOf()
//        accountRepository.findAll().forEach {
//            account -> accountDTOs.add(modelMapper.map(account, AccountDTO::class.java))
//        }
//        return accountDTOs

        return accountRepository.findAll()
            .map {
                account -> modelMapper.map(account, AccountDTO::class.java)
            }
    }

    override fun getOne(id: Long): AccountDTO = accountRepository.getById(id)
        .let {
            modelMapper.map(it, AccountDTO::class.java)
        }

}