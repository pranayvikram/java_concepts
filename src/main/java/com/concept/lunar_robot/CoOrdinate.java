package com.concept.lunar_robot;

public class CoOrdinate {

	int xc = 0;
	int yc = 0;
	char dir = 'N';
	
	public CoOrdinate(int x, int y, char dir) {
		this.xc = x;
		this.yc = y;
		this.dir = dir;
	}
	
	public final int getXc() {
		return xc;
	}
	public final void setXc(int xc) {
		this.xc = xc;
	}
	public final int getYc() {
		return yc;
	}
	public final void setYc(int yc) {
		this.yc = yc;
	}

	public char getDir() {
		return dir;
	}

	public void setDir(char dir) {
		this.dir = dir;
	}
}
