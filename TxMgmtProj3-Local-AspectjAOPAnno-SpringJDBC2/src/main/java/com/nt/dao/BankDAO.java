package com.nt.dao;

public interface BankDAO {
	public int  withdraw(int acno,int amt);
	public int  deposite(int acno,int amt);
}
