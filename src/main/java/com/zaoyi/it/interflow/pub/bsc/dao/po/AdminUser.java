package com.zaoyi.it.interflow.pub.bsc.dao.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zaoyi.it.interflow.core.PO;

@Entity
@Table
public class AdminUser extends PO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true,nullable=false)
	private Long adminUserId;
	private String name;
	private String password;
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return adminUserId;
	}
	public Long getAdminUserId() {
		return adminUserId;
	}
	public void setAdminUserId(Long adminUserId) {
		this.adminUserId = adminUserId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
