package com.finance.taxes.domain;

import static com.finance.taxes.domain.Taxe._0_Percent;
import static com.finance.taxes.domain.Taxe._5_Percent;

import java.math.BigDecimal;

public enum Type {

    IMPORTED {
        @Override
        public BigDecimal getVATRate() {
            return _5_Percent;
        }
    },
    DOMESTIC {
        @Override
        public BigDecimal getVATRate() {
            return _0_Percent;
        }
    };

    public abstract BigDecimal getVATRate();
}