package com.cn.bike;

public class BikesVo {
	private int id;//���
	private String bikenumber;//����
	private String biketype;//�ͺ�
	private String color;//��ɫ
	private double price;//��ֵ
	private double rentprice;//���
	private double deposit;//Ѻ��
	private int isrenting;//�������
	private String description;//���
	public String getBikenumber() {
		return bikenumber;
	}
	public void setBikenumber(String bikenumber) {
		this.bikenumber = bikenumber;
	}
	public String getBiketype() {
		return biketype;
	}
	public void setBiketype(String biketype) {
		this.biketype = biketype;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setIsrenting(int isrenting) {
		this.isrenting = isrenting;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRentprice() {
		return rentprice;
	}
	public void setRentprice(double rentprice) {
		this.rentprice = rentprice;
	}
	public int getIsrenting() {
		return isrenting;
	}
	


}
