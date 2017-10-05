package com.charo.services;

public class ShopInventory {
	String[][] shop_inventory;
	String[][] user_choice;
	double[] total_amount;
	CalculateDiscount discount=new CalculateDiscount();
	
	public void setShopInventory(String[][] shop_inventory)
	{
		this.shop_inventory=shop_inventory;
	}
	public void setUserChoice(String[][] user_choice) {
		this.user_choice = user_choice;
	}
	public double[] getTotalAmount()
	{
		return total_amount;
	}
	public void initiateDiscountProcess()
	{
		total_amount=new double[user_choice.length];
		for(int i=0;i<user_choice.length;i++)
		{
			int temp_amount=0;
			for(int j=0;j<user_choice[i].length;j++)
			{
				temp_amount+=discount.calculateDiscount(shop_inventory[Integer.parseInt(user_choice[i][j])-1]);				
			}
			total_amount[i]=temp_amount;
		}
	}
	

}
