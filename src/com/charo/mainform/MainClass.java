package com.charo.mainform;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.charo.exceptionhandler.ApparelInputFormatException;
import com.charo.services.ShopInventory;

public class MainClass {
	
	
	public static void main(String args[])
	{
		ShopInventory shop1=new ShopInventory();
		Scanner sc=new Scanner(System.in);
		String[][] shop_items;
		String [][] customer_choice;
		double[] total_dis_price;
		try{
			System.out.println("Enter Items in the shop"+"\n"+
					"(Seperated by comma and without any spaces in between - "+"Eg: 2,VeroModa,Dresses,140 )");
			int items_count=sc.nextInt();
			int column_count=4;
			shop_items=new String[items_count][column_count];
			for(int i=0;i<items_count;i++)
			{
				//nextLine is not working here, so don't use any spaces in the input
				String temp=sc.next();
				shop_items[i]=temp.split(",");
				if(shop_items[i].length!=column_count)
					throw new InputMismatchException();
			}
			shop1.setShopInventory(shop_items);
			System.out.println("Enter Customer choices");
			int choice_count=sc.nextInt();
			customer_choice=new String[choice_count][];
			for(int i=0;i<choice_count;i++)
			{
				customer_choice[i]=sc.next().split(",");
				if(customer_choice[i].length<1)
					throw new InputMismatchException();
			}
			shop1.setUserChoice(customer_choice);
			shop1.initiateDiscountProcess();
			total_dis_price=shop1.getTotalAmount();
			for(int i=0;i<total_dis_price.length;i++)
			{
				System.out.println(total_dis_price[i]);
			}
		}catch(Exception e)
		{
			new ApparelInputFormatException(e);
		}
		
		
	}

}
