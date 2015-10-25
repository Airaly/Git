package com.briup.thread;

public class Account {
	private long accountId;
	private double balance;
	public Account(long accountId,double balance){
		this.accountId = accountId;
		this.balance = balance;
	}
	public long getAccountId() {
		return accountId;
	}
	public double getBalance() {
		return balance;
	}
	//取钱
	/*synchronized*/ public double withdraw(double atm){
			if(atm<=0){
				return 0.0;
			}
		synchronized (this) {
			double temp = this.balance;
			if(atm>temp){
				return 0.0;
			}
			temp-=atm;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.balance = temp;
		}
			return atm;
	}
	//存钱
	/*synchronized*/ public double deposit(double atm){
		if(atm<=0){
			return 0.0;
		}
		synchronized (this) {
			double temp = this.balance;
			temp+=atm;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.balance = temp;
		}
		return atm;
	}
}






