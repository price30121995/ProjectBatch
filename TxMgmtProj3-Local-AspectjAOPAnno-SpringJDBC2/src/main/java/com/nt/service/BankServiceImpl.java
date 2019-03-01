package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.BankDAO;
@Service("bankService")
public class BankServiceImpl implements BankService {
	@Autowired
	private BankDAO dao;



	
	@Transactional (isolation=Isolation.SERIALIZABLE,propagation=Propagation.REQUIRED,timeout=300,rollbackFor=IllegalAccessException.class)
	public String transferMoney(int srcAcno, int destAcno, int amt) throws IllegalAccessException{
	     int result1=0,result2=0;
	   /*  try{
	    	 Thread.sleep(15000);
	     }
	     catch(Exception e){
	    	 e.printStackTrace();
	     }*/
	     //use DAO
	     result1=dao.withdraw(srcAcno, amt);
	     result2=dao.deposite(destAcno, amt);
	     if(result1==0 || result2==0)
	    	 throw new IllegalAccessException("TransferMoney Failed");
	     else
	    	 return "Money Transfered";
	}

}
