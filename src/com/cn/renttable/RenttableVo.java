package com.cn.renttable;

import java.sql.Date;

import com.cn.bike.BikesVo;
import com.cn.customers.customersVo;
import com.cn.users.UsersVo;

public class RenttableVo {
	private int id;
	private String tableid;//���ⵥ���
	private Double imprest;//Ԥ����
	private Double  shouldpayprice;//Ӧ����
	private Double	price;//ʵ�ʽ������
	private Date begindate;//��������
	private Date shouldretumdate;//Ӧ�黹����
	private Date rerumdate;//�黹����
	private int rentflag;//���ⵥ״̬
	private UsersVo usersVo;
	private BikesVo bikesVo;
	private customersVo customerVo;
	public Date getBegindate() {
		return begindate;
	}
	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}
	public BikesVo getBikesVo() {
		return bikesVo;
	}
	public void setBikesVo(BikesVo bikesVo) {
		this.bikesVo = bikesVo;
	}
	public customersVo getCustomerVo() {
		return customerVo;
	}
	public void setCustomerVo(customersVo customerVo) {
		this.customerVo = customerVo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getImprest() {
		return imprest;
	}
	public void setImprest(Double imprest) {
		this.imprest = imprest;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getRentflag() {
		return rentflag;
	}
	public void setRentflag(int rentflag) {
		this.rentflag = rentflag;
	}
	public Date getRerumdate() {
		return rerumdate;
	}
	public void setRerumdate(Date rerumdate) {
		this.rerumdate = rerumdate;
	}
	public Double getShouldpayprice() {
		return shouldpayprice;
	}
	public void setShouldpayprice(Double shouldpayprice) {
		this.shouldpayprice = shouldpayprice;
	}
	public Date getShouldretumdate() {
		return shouldretumdate;
	}
	public void setShouldretumdate(Date shouldretumdate) {
		this.shouldretumdate = shouldretumdate;
	}
	public String getTableid() {
		return tableid;
	}
	public void setTableid(String tableid) {
		this.tableid = tableid;
	}
	public UsersVo getUsersVo() {
		return usersVo;
	}
	public void setUsersVo(UsersVo usersVo) {
		this.usersVo = usersVo;
	}
	

}
