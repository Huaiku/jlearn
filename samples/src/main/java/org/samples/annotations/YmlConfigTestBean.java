package org.samples.annotations;

public class YmlConfigTestBean {
	private String email;
	private String address;
	
	public YmlConfigTestBean(String email,String address) {
		this.address = address;
		this.email = email;
	}
	
	public void print() {
		System.out.println(String.format("Email:%s,Address:%s", this.email,this.address));
	}
}
