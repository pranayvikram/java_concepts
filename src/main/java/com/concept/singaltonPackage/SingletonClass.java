package com.concept.singaltonPackage;

public class SingletonClass {

	private static SingletonClass instance = null;
	protected SingletonClass() {
		// Exists only to defeat instantiation.
	}
	public static SingletonClass getInstance() {
		if(instance == null) {
			instance = new SingletonClass();
		}
		return instance;
	}
}