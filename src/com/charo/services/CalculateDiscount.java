package com.charo.services;

import static com.charo.apperals.beans.Brand.*;
import static com.charo.apperals.beans.Products.*;

import java.util.Iterator;
import java.util.Map.Entry;

import com.charo.apperals.beans.Brand;
import com.charo.apperals.beans.Category;
import com.charo.apperals.beans.Products;
public class CalculateDiscount {
	
	static
	{
		initializeMensWear();
		initializeWomensWear();
		initializeBrands();
	}
	// gets brand discount, if band is not present in the list then return 0...
	private int getBrandDiscount(String brand)
	{
		if(getBrands().get(brand.toUpperCase())!=null)
			 return getBrands().get(brand.toUpperCase()).getDiscount_percent();
			else
				return 0;
	}
	// gets discount on the category/subcatergory/parent
	private int getItemDiscount(String item)
	{
		Iterator<Products> ite=getProducts().iterator();
		while(ite.hasNext())
		{
			Products prod=ite.next();
			int prod_disc=prod.getProductDiscountPercent();
			int cat_disc=0;		
			if(prod.getCategories().get(item.toUpperCase())!=null)
			{
			cat_disc=prod.getCategories().get(item.toUpperCase()).getDiscountPercent();
			Category parent=prod.getCategories().get(item.toUpperCase()).getParent();
				while(parent!=null)
				{
					if(cat_disc<parent.getDiscountPercent())
						cat_disc=parent.getDiscountPercent();
					parent=parent.getParent();
				}
				if(prod_disc>cat_disc)
					return prod_disc;
				else
					return cat_disc;
			}
		}
		return 0;
	}
	public double calculateDiscount(String[] items)
	{
		int brand_disc=getBrandDiscount(items[1]);
		int item_disc=getItemDiscount(items[2]);
			if(brand_disc>item_disc)
			{
				if(brand_disc>0)
					return Integer.parseInt(items[3])-(brand_disc*Integer.parseInt(items[3])/100);
				else
					return (Integer.parseInt(items[3]));
			}
			else
			{		
				if(item_disc>0)
					return Integer.parseInt(items[3])-(item_disc*Integer.parseInt(items[3])/100);
				else
					return (Integer.parseInt(items[3]));	
			}
	}

}
