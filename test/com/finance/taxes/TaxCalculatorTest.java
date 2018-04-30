/**
 * 
 */
package com.finance.taxes;

import static com.finance.taxes.domain.Type.DOMESTIC;
import static com.finance.taxes.domain.Type.IMPORTED;
import static com.finance.taxes.domain.ProductCategory.BOOK;
import static com.finance.taxes.domain.ProductCategory.DRUG;
import static com.finance.taxes.domain.ProductCategory.FOOD;
import static com.finance.taxes.domain.ProductCategory.OTHER;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.finance.taxes.domain.Order;
import com.finance.taxes.domain.Product;

import junit.framework.TestCase;

/**
 * JUnit tests for our TaxCalculator solution
 * @author Maroua
 * 
 */
public class TaxCalculatorTest extends TestCase {
	

	private Order o1 = new Order();
	private Order o2 = new Order();
	private Order o3 = new Order();
	private Product p1, p2, p3, p4, p5, p6, p7, p8, p9;
	
	public void setUp() {
		// Input 1
	    p1 = new Product("livre", BOOK, DOMESTIC, new BigDecimal("12.49"));
	    p2 = new Product("CD musical", OTHER, DOMESTIC, new BigDecimal("14.99"));
	    p3 = new Product("barre de chocolat", FOOD, DOMESTIC, new BigDecimal("0.85"));
		o1.add(p1);
		o1.add(p2);
		o1.add(p3);
		// Input 2
		p4 = new Product("boite de chocolats importée", FOOD, IMPORTED, new BigDecimal("10.00"));
	    p5 = new Product("flacon de parfum importé", OTHER, IMPORTED, new BigDecimal("47.50"));
		o2.add(p4);
		o2.add(p5);
		// Input 3
		p6 = new Product("flacon de parfum importé", OTHER, IMPORTED, new BigDecimal("27.99"));
	    p7 = new Product("flacon de parfum", OTHER, DOMESTIC, new BigDecimal("18.99"));
	    p8 = new Product("boîte de pilules contre la migraine", DRUG, DOMESTIC, new BigDecimal("9.75"));
	    p9 = new Product("boîte de chocolats importés", FOOD, IMPORTED, new BigDecimal("11.25"));
		o3.add(p6);
		o3.add(p7);
		o3.add(p8);
		o3.add(p9);
	}
	
	@Test
	public void testGetPriceWithVAT() {
		Assert.assertEquals(new BigDecimal("12.49"), p1.getPriceWithVAT());
		Assert.assertEquals(new BigDecimal("16.49"), p2.getPriceWithVAT());
		Assert.assertEquals(new BigDecimal("0.85"), p3.getPriceWithVAT());
		Assert.assertEquals(new BigDecimal("10.50"), p4.getPriceWithVAT());
		Assert.assertEquals(new BigDecimal("54.65"), p5.getPriceWithVAT());
		Assert.assertEquals(new BigDecimal("32.19"), p6.getPriceWithVAT());
		Assert.assertEquals(new BigDecimal("20.89"), p7.getPriceWithVAT());
		Assert.assertEquals(new BigDecimal("9.75"), p8.getPriceWithVAT());
		Assert.assertEquals(new BigDecimal("11.85"), p9.getPriceWithVAT());
	}

	@Test
	public void testTotalVAT() {
		Assert.assertEquals(new BigDecimal("1.50"), o1.getTotalVAT());
		Assert.assertEquals(new BigDecimal("7.65"), o2.getTotalVAT());
		Assert.assertEquals(new BigDecimal("6.70"), o3.getTotalVAT());
	}

	@Test
	public void testGetTotalAmountWithVAT() {
		Assert.assertEquals(new BigDecimal("29.83"), o1.getTotalAmountWithVAT());
		Assert.assertEquals(new BigDecimal("65.15"), o2.getTotalAmountWithVAT());
		Assert.assertEquals(new BigDecimal("74.68"), o3.getTotalAmountWithVAT());
	}

}
