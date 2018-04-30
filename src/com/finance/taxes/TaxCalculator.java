package com.finance.taxes;

import static com.finance.taxes.domain.Type.DOMESTIC;
import static com.finance.taxes.domain.Type.IMPORTED;
import static com.finance.taxes.domain.ProductCategory.*;

import java.math.BigDecimal;

import com.finance.taxes.domain.Order;
import com.finance.taxes.domain.Product;

public class TaxCalculator {

	public static void main (String[] s) throws Exception {
		
		Order iv = new Order();		
		iv.add(new Product("livre", BOOK, DOMESTIC, new BigDecimal("12.49")));
		iv.add(new Product("CD musical", OTHER, DOMESTIC, new BigDecimal("14.99")));
		iv.add(new Product("barre de chocolat", FOOD, DOMESTIC, new BigDecimal("0.85")));
		
		System.out.println("Output 1\n" + iv.toString());
		
		Order iv2 = new Order();		
		iv2.add(new Product("boite de chocolats importée", FOOD, IMPORTED, new BigDecimal("10.00")));
		iv2.add(new Product("flacon de parfum importé", OTHER, IMPORTED, new BigDecimal("47.50")));
		
		System.out.println("Output 2\n" + iv2.toString());
		
		Order iv3 = new Order();		
		iv3.add(new Product("flacon de parfum importé", OTHER, IMPORTED, new BigDecimal("27.99")));
		iv3.add(new Product("flacon de parfum", OTHER, DOMESTIC, new BigDecimal("18.99")));
		iv3.add(new Product("boîte de pilules contre la migraine", DRUG, DOMESTIC, new BigDecimal("9.75")));
		iv3.add(new Product("boîte de chocolats importés", FOOD, IMPORTED, new BigDecimal("11.25")));
		
		System.out.println("Output 3\n" + iv3.toString());
	}

}