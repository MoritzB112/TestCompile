package com.inergis.fguma.services;

import com.inergis.fguma.entities.PaymentAccount;
import com.inergis.fguma.repositories.paymentAccount.PaymentAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentAccountService {

    @Autowired
    private PaymentAccountRepository paymentAccountRepository;

    public List<PaymentAccount> getAll() {
        return paymentAccountRepository.findAll();
    }

    public PaymentAccount getById(Long id) {
        return paymentAccountRepository.findById(id).orElse(null);
    }

    public PaymentAccount save(PaymentAccount paymentAccount) {
        return paymentAccountRepository.save(paymentAccount);
    }

    public void deleteById(Long id) {
        paymentAccountRepository.deleteById(id);
    }

    public void delete(PaymentAccount paymentAccount) {
        paymentAccountRepository.delete(paymentAccount);
    }

}