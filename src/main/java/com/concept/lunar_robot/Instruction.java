package com.concept.lunar_robot;

import java.util.ArrayList;
import java.util.List;

public class Instruction {

	// input  -  LLMMRMMRMLMRMMML
	private List<String> stepPoints = new ArrayList<>();
	private CoOrdinate startCord = new CoOrdinate(0, 0, 'N');
	private CoOrdinate presentCord = new CoOrdinate(0, 0, 'N');
	private CoOrdinate borderCord = new CoOrdinate(0, 0, 'N');
	private CoOrdinate baseCord = new CoOrdinate(0, 0, 'N');
	private CoOrdinate targetCord = new CoOrdinate(0, 0, 'N');
	private CoOrdinate cordGap = new CoOrdinate(0, 0, 'N');
	
	public List<String> getStepPoints() {
		return stepPoints;
	}
	public void setStepPoints(List<String> stepPoints) {
		this.stepPoints = stepPoints;
	}
	public CoOrdinate getStartCord() {
		return startCord;
	}
	public void setStartCord(CoOrdinate startCord) {
		this.startCord = startCord;
	}
	public CoOrdinate getPresentCord() {
		return presentCord;
	}
	public void setPresentCord(CoOrdinate presentCord) {
		this.presentCord = presentCord;
	}
	public CoOrdinate getBorderCord() {
		return borderCord;
	}
	public void setBorderCord(CoOrdinate borderCord) {
		this.borderCord = borderCord;
	}
	public CoOrdinate getBaseCord() {
		return baseCord;
	}
	public void setBaseCord(CoOrdinate baseCord) {
		this.baseCord = baseCord;
	}
	public CoOrdinate getTargetCord() {
		return targetCord;
	}
	public void setTargetCord(CoOrdinate targetCord) {
		this.targetCord = targetCord;
	}
	public CoOrdinate getCordGap() {
		return cordGap;
	}
	public void setCordGap(CoOrdinate cordGap) {
		this.cordGap = cordGap;
	}
}
