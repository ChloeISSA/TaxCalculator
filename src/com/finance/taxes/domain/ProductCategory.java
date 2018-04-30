package com.finance.taxes.domain;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public enum ProductCategory {

    BOOK {
        @Override
        public BigDecimal getVATRate() {
            return Taxe._0_Percent;
        }
    },
    FOOD {
        @Override
        public BigDecimal getVATRate() {
            return Taxe._0_Percent;
        }
    },
    DRUG {
        @Override
        public BigDecimal getVATRate() {
            return Taxe._0_Percent;
        }
    },

    OTHER;

    public BigDecimal getVATRate() {
        return Taxe._10_Percent;
    }
}
