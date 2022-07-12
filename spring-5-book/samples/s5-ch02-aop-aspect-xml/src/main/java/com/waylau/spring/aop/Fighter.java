
package com.link.spring.aop;

/**
 * Fighter.
 */
public class Fighter {

	public void foundBefore() {
		System.out.println("Fighter wait for tiger...");
	}

	public void foundAfter() {
		System.out.println("Fighter fight with tiger...");
	}

}
