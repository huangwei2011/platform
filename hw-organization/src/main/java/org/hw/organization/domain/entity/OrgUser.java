package org.hw.organization.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hw.common.BasicEntity;
@Entity
@Table(name="organization")
public class OrgUser extends BasicEntity{
	@Column(length=10)
	private String userName;
	@Column(length=1)
	private String userSex;
	@Column
	private int userAge;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	

}
