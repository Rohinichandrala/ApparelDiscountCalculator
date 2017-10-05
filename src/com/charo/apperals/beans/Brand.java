package com.charo.apperals.beans;

import static com.charo.apperals.constants.DataConstants.*;

import java.util.HashMap;
import java.util.Map;

public class Brand {
	private String name;
	private int discount_percent;
	private static Map<String,Brand> brands=new HashMap<String, Brand>(); 
	
	public Brand(String name,int discount_percent)
	{
		this.name=name;
		this.discount_percent=discount_percent;
	}
	public String getName() {
		return name;
	}
	public int getDiscount_percent() {
		return discount_percent;
	}
	
	public static void initializeBrands()
	{
		brands.put(WRANGLER, new Brand(WRANGLER,BRAND_WRANGLER_DISCOUNT_PERCENT));
		brands.put(ARROW, new Brand(ARROW,BRAND_ARROW_DISCOUNT_PERCENT));
		brands.put(VEROMODA, new Brand(VEROMODA,BRAND_VEROMODA_DISCOUNT_PERCENT));
		brands.put(UCB, new Brand(UCB,BRAND_UCB_DISCOUNT_PERCENT));
		brands.put(ADIDAS, new Brand(ADIDAS,BRAND_ADIDAS_DISCOUNT_PERCENT));
		brands.put(PROVOGUE, new Brand(UCB,BRAND_PROVOGUE_DISCOUNT_PERCENT));		
	}
	
	public static Map<String,Brand> getBrands()
	{
		return brands;
	}

}
