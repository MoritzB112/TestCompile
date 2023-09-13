package com.inergis.fguma.repositories.paymentAccount;

import com.inergis.fguma.entities.PaymentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentAccountRepository extends JpaRepository<PaymentAccount, Long> {

}