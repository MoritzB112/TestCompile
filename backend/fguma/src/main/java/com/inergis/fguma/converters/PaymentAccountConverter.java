package com.inergis.fguma.converters;

import com.inergis.fguma.entities.PaymentAccount;

public class PaymentAccountConverter {

    public static PaymentAccount toExternal(PaymentAccount entity) {
        if (entity == null) {
            return null;
        }

        return PaymentAccount.builder()
                .id(entity.getId())
                .nominalName(entity.getNominalName())
                .build();
    }

}