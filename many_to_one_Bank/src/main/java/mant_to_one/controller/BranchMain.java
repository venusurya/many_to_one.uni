package mant_to_one.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.many_to_one.dao.BankCRUD;
import com.ty.many_to_one.dao.BranchCRUD;

import many_to_one_Bank.dto.Bank;
import many_to_one_Bank.dto.Branch;

public class BranchMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Bank bank=new Bank();
		Branch b1=new Branch();
		BranchCRUD crud=new BranchCRUD();
		BankCRUD bankcrud=new BankCRUD();
		boolean flag=true;
		do {
			System.out.println("enter ur choice   \n 1 save Branch \n 2 update branch \n 3 delete branch  "
					+ "\n 4 get details based id  \n 5 to get all details of branch  \n 6 to Exit"
					+"");
			int choice=sc.nextInt();
			switch ( choice){
			case 1:{
				System.out.println("enter Bank Id");
				int id=sc.nextInt();
				System.out.println("enter name");
				String name=sc.next();
				System.out.println("Enter manger name");
				String manager=sc.next();
				System.out.println("Enter Address");
				String address=sc.next();
				System.out.println("Enter phone");
				long phone=sc.nextLong();
				
				b1.setName(name);
				b1.setManager(manager);
				b1.setAddress( address);
				b1.setPhone( phone);
				crud.savebranch(id,b1);
			}
				break;
				case 2:{
					System.out.println("enter Bank Id");
					int id=sc.nextInt();
					System.out.println("enter Bank name");
					String bname=sc.next();
					System.out.println("Enter manger name");
					String Mmanager=sc.next();
					System.out.println("Enter Address");
					String ceo=sc.next();
					
					bank.setName(bname);
					bank.setManager(Mmanager);
					bank.setCeo(ceo);
					bankcrud.saveBank(bank);
					}
				break;
			case 3:
			{
				System.out.println("Enter id ");
				int id=sc.nextInt();
				System.out.println("enter name");
				String name=sc.next();
				System.out.println("Enter manger name");
				String manager=sc.next();
				System.out.println("Enter Address");
				String address=sc.next();
				System.out.println("Enter phone");
				long phone=sc.nextLong();
				b1.setName(name);
				b1.setManager(manager);
				b1.setAddress( address);
				b1.setPhone( phone);
				crud.updateBranch(id, b1);
			}
			break;
			case 4:{
				System.out.println("Enter id ");
				int id=sc.nextInt();
				System.out.println("enter name");
				String name=sc.next();
				System.out.println("Enter manger name");
				String manager=sc.next();
				System.out.println("Enter CEO");
				String ceo=sc.next();
				bank.setName(name);
				bank.setManager(manager);
				bank.setCeo(ceo);
				bankcrud.updateBank(id, bank);
			}
			case 5:
			{
				System.out.println("Enter id ");
				int id=sc.nextInt();
				bankcrud.deleteBank(id);
			}
			break;
			case 6:{
				System.out.println("Enter id ");
				int id=sc.nextInt();
				bankcrud.deleteBank(id);
			}
			break;
			
			case 7:{
				System.out.println("Enter id ");
				int id=sc.nextInt();
				System.out.println(crud.getBranchdetails(id));
			}
			break;
			case 8:{
				System.out.println("Enter id ");
				int id=sc.nextInt();
				System.out.println(bankcrud.getBankdetails(id));
			}
			break;
			case 9:
			{
				System.out.println(crud.getBranch());
			}
			break;
			case 10:
			{
				System.out.println(bankcrud.getAllBankDetails());
			}
			break;
			case 11:{
				flag=false;
			}
			break;
		}
		}while(flag);
	}
}
