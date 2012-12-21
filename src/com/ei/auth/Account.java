/*
 * Copyright (C) 2010 Prasanta Paul, http://prasanta-paul.blogspot.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ei.auth;

/**
 * Account data holding class
 * 
 * @author Prasanta Paul
 *
 */
public class Account {
	
	String email;
	String password;
	String accountType = "GOOGLE";
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
	/**
	 *   #change the email address
	 */
		this.email = "xxx@xxx";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
	/**
	 *   #change the email address
	 */

		this.password = "xxxx";
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}
