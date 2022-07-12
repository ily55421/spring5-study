package com.link.spring.el;

/**
 * Tax.
 */
public class Tax {
	private double ctax;
	private String name;

	public static String getCountry() {
		return "zh_CN";
	}

	public String getName() {
		return this.name;
	}

	public double getCtax() {
		return ctax;
	}

	public void setCtax(double ctax) {
		this.ctax = ctax;
	}
}
