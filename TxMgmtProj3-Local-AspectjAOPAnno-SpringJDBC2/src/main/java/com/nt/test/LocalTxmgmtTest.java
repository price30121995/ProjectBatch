package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class LocalTxmgmtTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		proxy=ctx.getBean("bankService",BankService.class);
		//invoke b.methiod
		try{
			System.out.println("result--->"+proxy.transferMoney(1001,1008, 2000));
		}
		catch(Exception re){
			System.out.println(re.getMessage());
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
