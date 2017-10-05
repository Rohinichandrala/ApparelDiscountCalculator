package com.charo.apperals.beans;

import static com.charo.apperals.constants.DataConstants.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Products {
	private String name;
	private int discount_percent;
	Map<String,Category> categories=new HashMap<String,Category>();
	private static Products Mens_Wear;
	private static Products Womens_Wear;
	private static List<Products> products_list=new LinkedList<Products>();
	public Products(String name,int discount_percent,Category... category)
	{
		this.name=name;
		this.discount_percent=discount_percent;
		for(int i=0;i<category.length;i++)
		{
			categories.put(category[i].getName(),category[i]);
		}
	}
	public static void initializeMensWear()
	{
		Category shirts=new Category(SHIRTS,MENS_SHIRTS_DISCOUNT_PERCENT,null);
		Category trousers=new Category(TROUSERS,MENS_TROUSERS_DISCOUNT_PERCENT,null);
		Category casuals=new Category(CASUALS,MENS_CASUALS_DISCOUNT_PERCENT,trousers);
		Category jeans=new Category(JEANS,MENS_JEANS_DISCOUNT_PERCENT,trousers);
		Mens_Wear=new Products(MENS_WEAR,MENS_WEAR_DICOUNT_PERCENT,shirts,trousers,casuals,jeans);
		products_list.add(Mens_Wear);
	}
	public static void initializeWomensWear()
	{
		Category dresses=new Category(DRESSES,WOMENS_DRESSES_DISCOUNT_PERCENT,null);
		Category footwear=new Category(FOOTWEAR,WOMENS_FOOTWARE_DISCOUNT_PERCENT,null);
		Womens_Wear=new Products(WOMENS_WEAR,WOMENS_WEAR_DISCOUNT_PERCENT,dresses,footwear);
		products_list.add(Womens_Wear);
	}
	public Map<String,Category> getCategories()
	{
		return this.categories;
	}

	public int getProductDiscountPercent()
	{
		return this.discount_percent;
	}
	public static List<Products> getProducts()
	{
		return products_list;
	}
}
