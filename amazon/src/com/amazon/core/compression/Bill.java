package com.amazon.core.compression;

import java.io.Serializable;

public class Bill implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2010594004533775304L;
	private String billNo;
	private String buyerName;
	
	public Bill(String billNo, String buyerName) {
		this.setBillNo(billNo);
		this.setBuyerName(buyerName);
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
}
