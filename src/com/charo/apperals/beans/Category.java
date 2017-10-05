package com.charo.apperals.beans;

public class Category {

	private String name;
	private int discount_percent;
	private Category parent;
	public Category(String name,int discount_percent,Category parent)
	{
		this.name=name;
		this.discount_percent=discount_percent;
		this.parent=parent;
	}
	public String getName()
	{
		return this.name;
	}
	public int getDiscountPercent()
	{
		return this.discount_percent;
	}
	public Category getParent()
	{
		return this.parent;
	}
}
