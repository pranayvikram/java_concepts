package com.concept.allClasses;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Cross Bridge Game
 * @author Pranay Vikram
 * @since 17 November 2013
 */

public class CrossBridge {
	
	int actionCounter = 0;
	int sourcePosition = 0;
	int targetPosition = 0;
	
	JButton leftObject1 = null;
	JButton leftObject2 = null;
	JButton leftObject3 = null;
	JButton leftObject4 = null;
	JButton centerObject = null;
	JButton rightObject1 = null;
	JButton rightObject2 = null;
	JButton rightObject3 = null;
	JButton rightObject4 = null;
	JButton emptyObject1 = null;
	JButton emptyObject2 = null;
	
	JDialog baseDialogBox = null;
	List<JButton> objectList = null;
	
	SolutionRunner solutionRunner;
	
	public static void main(String... str) {
		
		CrossBridge crossBridge = new CrossBridge();
		crossBridge.createBaseDialogBox();
	}
	
	private void createBaseDialogBox(){
		
		baseDialogBox = new JDialog(new JDialog(), "Cross Bridge");
		baseDialogBox.setLayout(new GridBagLayout());
		
		JPanel basePanel = new JPanel();
		basePanel.setLayout(new GridBagLayout());
		
		JPanel playPanel = new JPanel();
		playPanel.setLayout(new GridBagLayout());
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridBagLayout());
		
		leftObject1 = new JButton();
		leftObject2 = new JButton();
		leftObject3 = new JButton();
		leftObject4 = new JButton();
		
		centerObject  = new JButton();
		
		rightObject1 = new JButton();
		rightObject2 = new JButton();
		rightObject3 = new JButton();
		rightObject4 = new JButton();	
		
		emptyObject1 = new JButton();
		emptyObject2 = new JButton();	
		
		resetGame();
		
		JButton reset = new JButton("Reset");
		JButton solve = new JButton("Solve");
		JButton close = new JButton("Close");
		
		objectList = new ArrayList<JButton>();
		objectList.add(emptyObject1);
		objectList.add(leftObject1);
		objectList.add(leftObject2);
		objectList.add(leftObject3);
		objectList.add(leftObject4);
		objectList.add(centerObject);
		objectList.add(rightObject1);
		objectList.add(rightObject2);
		objectList.add(rightObject3);
		objectList.add(rightObject4);
		objectList.add(emptyObject2);
		
		playPanel.add(emptyObject1, new GridBagConstraints(0, 0, 1, 1, 0.1, 0.1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 2, 0, 2), 0, 0));
		
		playPanel.add(leftObject1, new GridBagConstraints(1, 0, 1, 1, 0.1, 0.1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 2, 0, 2), 0, 0));
		
		playPanel.add(leftObject2, new GridBagConstraints(2, 0, 1, 1, 0.1, 0.1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 2, 0, 2), 0, 0));
		
		playPanel.add(leftObject3, new GridBagConstraints(3, 0, 1, 1, 0.1, 0.1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 2, 0, 2), 0, 0));
		
		playPanel.add(leftObject4, new GridBagConstraints(4, 0, 1, 1, 0.1, 0.1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 2, 0, 2), 0, 0));
		
		playPanel.add(centerObject, new GridBagConstraints(5, 0, 1, 1, 0.1, 0.1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 2, 0, 2), 0, 0));
		
		playPanel.add(rightObject1, new GridBagConstraints(6, 0, 1, 1, 0.1, 0.1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 2, 0, 2), 0, 0));
		
		playPanel.add(rightObject2, new GridBagConstraints(7, 0, 1, 1, 0.1, 0.1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 2, 0, 2), 0, 0));
		
		playPanel.add(rightObject3, new GridBagConstraints(8, 0, 1, 1, 0.1, 0.1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 2, 0, 2), 0, 0));
		
		playPanel.add(rightObject4, new GridBagConstraints(9, 0, 1, 1, 0.1, 0.1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 2, 0, 2), 0, 0));
		
		playPanel.add(emptyObject2, new GridBagConstraints(10, 0, 1, 1, 0.1, 0.1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 2, 0, 2), 0, 0));
		
		controlPanel.add(reset, new GridBagConstraints(0, 0, 1, 1, 0.1, 0.1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 2, 0, 2), 0, 0));
		controlPanel.add(solve, new GridBagConstraints(1, 0, 1, 1, 0.1, 0.1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 2, 0, 2), 0, 0));
		controlPanel.add(close, new GridBagConstraints(2, 0, 1, 1, 0.1, 0.1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 2, 0, 2), 0, 0));
		
		basePanel.add(playPanel, new GridBagConstraints(0, 0, 1, 1, 0.1, 0.1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 2, 0, 2), 0, 0));
		basePanel.add(controlPanel, new GridBagConstraints(0, 1, 1, 1, 0.1, 0.1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 2, 0, 2), 0, 0));
		
		baseDialogBox.add(basePanel);
		baseDialogBox.setSize(700, 200);
		baseDialogBox.setVisible(true);
		
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				resetGame();				
			}
		});
		
		solve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				solveGame();				
			}
		});
		
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				closeGame();				
			}
		});
		
		leftObject1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				readInstruction(leftObject1);				
			}
		});
		
		leftObject2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				readInstruction(leftObject2);			
			}
		});
		
		leftObject3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				readInstruction(leftObject3);				
			}
		});
		
		leftObject4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				readInstruction(leftObject4);				
			}
		});
		
		centerObject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				readInstruction(centerObject);				
			}
		});
		
		rightObject1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				readInstruction(rightObject1);				
			}
		});
		
		rightObject2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				readInstruction(rightObject2);				
			}
		});
		
		rightObject3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				readInstruction(rightObject3);				
			}
		});
		
		rightObject4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				readInstruction(rightObject4);				
			}
		});
		
		emptyObject1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				readInstruction(emptyObject1);				
			}
		});
		
		emptyObject2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				readInstruction(emptyObject2);				
			}
		});
	}
	
	/**
	 * Reset objects to original position
	 */
	private void resetGame() {
		
		actionCounter = 0;
		sourcePosition = 0;
		targetPosition = 0;

		//Image img = Toolkit.getDefaultToolkit().getImage("src/main/java/com/concept/allClasses/blue_car.png");
		//ImageIcon blueCar = new ImageIcon(img);
		//leftObject1.setIcon(blueCar);

		emptyObject1.setText(". .");
		leftObject1.setText("=>");
		leftObject2.setText("=>");
		leftObject3.setText("=>");
		leftObject4.setText("=>");
		
		centerObject.setText("[ ]");
		
		rightObject1.setText("<=");
		rightObject2.setText("<=");
		rightObject3.setText("<=");
		rightObject4.setText("<=");
		emptyObject2.setText(". .");		
	}
	
	/**
	 * Trigger auto solution
	 */
	private void solveGame() {
		solutionRunner = new SolutionRunner();
	}

	/**
	 * Close the game window
	 */
	@SuppressWarnings("deprecation")
	private void closeGame() {
		baseDialogBox.dispose();
		solutionRunner.thread.stop();
	}
	
	/**
	 * Is moving the object is possible
	 * @return isPossible
	 */
	private boolean isPossibleMove() {
		boolean isPossible = true;
		JButton sourceObject = objectList.get(sourcePosition - 1);
		JButton targetObject = objectList.get(targetPosition - 1);
		String sourceText = sourceObject.getText();
		String targetText = targetObject.getText();
		int jumpCount = targetPosition - sourcePosition;
		
		if(jumpCount == 0 || sourceText.equals(". .") || sourceText.equals("[ ]")
				|| !(targetText.equals(". .") || targetText.equals("[ ]"))) {
			isPossible = false;
		}
		else if(sourceText.equals("=>") && (jumpCount < 1 || jumpCount > 2)) {
			isPossible = false;
		}
		else if(sourceText.equals("<=") && (jumpCount > -1 || jumpCount < -2)) {
			isPossible = false;
		}
		return isPossible;
	}
	
	/**
	 * Read mouse instruction for from button
	 * @param selectedObject
	 */
	private void readInstruction(JButton selectedObject) {
		
		actionCounter++;
		readPosition(selectedObject);
		if(actionCounter == 2) {
			actionCounter = 0;
			if(isPossibleMove()) {
				moveSelectedObject();
			}
			else {
				JOptionPane.showMessageDialog(null, "This is an invalid move.");
			}
		}
	}
	
	/**
	 * Move the object from one position to another
	 */
	private void moveSelectedObject() {
		
		JButton sourceObject = objectList.get(sourcePosition - 1);
		JButton targetObject = objectList.get(targetPosition - 1);
		
		String sourceText = sourceObject.getText();
		String targetText = targetObject.getText();
		
		sourceObject.setText(targetText);
		targetObject.setText(sourceText);
		
		if(targetPosition == 6) {
			sourceObject.setText(". .");
		}
		else if (sourcePosition == 6) {
			sourceObject.setText("[ ]");
		}
	}
	
	/**
	 * Read the current position of selected object
	 * @param selectedObject
	 */
	private void readPosition(JButton selectedObject) {
		
		if(actionCounter == 1) {
			if(selectedObject == leftObject1) {
				sourcePosition = 2;
			}
			else if(selectedObject == leftObject2) {
				sourcePosition = 3;
			}
			else if(selectedObject == leftObject3) {
				sourcePosition = 4;
			}
			else if(selectedObject == leftObject4) {
				sourcePosition = 5;
			}
			else if(selectedObject == centerObject) {
				sourcePosition = 6;
			}
			else if(selectedObject == rightObject1) {
				sourcePosition = 7;
			}
			else if(selectedObject == rightObject2) {
				sourcePosition = 8;
			}
			else if(selectedObject == rightObject3) {
				sourcePosition = 9;
			}
			else if(selectedObject == rightObject4) {
				sourcePosition = 10;
			}
			else if(selectedObject == emptyObject1) {
				sourcePosition = 1;
			}
			else if(selectedObject == emptyObject2) {
				sourcePosition = 11;
			}
		}
		else if(actionCounter == 2) {
			if(selectedObject == leftObject1) {
				targetPosition = 2;
			}
			else if(selectedObject == leftObject2) {
				targetPosition = 3;
			}
			else if(selectedObject == leftObject3) {
				targetPosition = 4;
			}
			else if(selectedObject == leftObject4) {
				targetPosition = 5;
			}
			else if(selectedObject == centerObject) {
				targetPosition = 6;
			}
			else if(selectedObject == rightObject1) {
				targetPosition = 7;
			}
			else if(selectedObject == rightObject2) {
				targetPosition = 8;
			}
			else if(selectedObject == rightObject3) {
				targetPosition = 9;
			}
			else if(selectedObject == rightObject4) {
				targetPosition = 10;
			}
			else if(selectedObject == emptyObject1) {
				targetPosition = 1;
			}
			else if(selectedObject == emptyObject2) {
				targetPosition = 11;
			}
		}
	}

	private void automateMove(int source, int target, int block) {
		
		JButton originalColorObj = new JButton();
		Color originalColor = originalColorObj.getBackground();
		
		JButton sourceObject = objectList.get(source);
		JButton targetObject = objectList.get(target);
		
		if(block == 1) {
			sourceObject.setBackground(Color.ORANGE);
		}
		else if(block == 2) {
			sourceObject.setBackground(originalColor);
			String sourceText = sourceObject.getText();
			String targetText = targetObject.getText();
			
			if(target == 5) {
				sourceObject.setText(". .");
				targetObject.setText(sourceText);
			}
			else if (source == 5) {
				sourceObject.setText("[ ]");
				targetObject.setText(sourceText);
			}
			else {
				sourceObject.setText(targetText);
				targetObject.setText(sourceText);
			}
			targetObject.setBackground(Color.ORANGE);
		}
		else if(block == 3) {
			targetObject.setBackground(originalColor);
		}		
	}
	
	class SolutionRunner implements Runnable {

		Thread thread;
		SolutionRunner() {
			thread = new Thread(this);
			thread.start();
		}

		public void run() {
			try {
				cycleAutomatedMove(4, 5);
				cycleAutomatedMove(6, 4);
				cycleAutomatedMove(7, 6);
				cycleAutomatedMove(5, 7);
				cycleAutomatedMove(3, 5);
				cycleAutomatedMove(2, 3);
				cycleAutomatedMove(4, 2);
				cycleAutomatedMove(6, 4);
				cycleAutomatedMove(8, 6);
				cycleAutomatedMove(7, 8);
				cycleAutomatedMove(8, 10);
				cycleAutomatedMove(5, 7);				
				cycleAutomatedMove(9, 8);
				cycleAutomatedMove(7, 9);
				cycleAutomatedMove(2, 0);
				cycleAutomatedMove(4, 2);
				cycleAutomatedMove(3, 5);
				cycleAutomatedMove(1, 3);
				cycleAutomatedMove(2, 1);
				cycleAutomatedMove(6, 4);
				cycleAutomatedMove(4, 2);
				cycleAutomatedMove(8, 6);
				cycleAutomatedMove(5, 7);
				cycleAutomatedMove(7, 8);
				cycleAutomatedMove(3, 5);
				cycleAutomatedMove(6, 4);
				cycleAutomatedMove(4, 3);
				cycleAutomatedMove(5, 7);
			}
			catch (InterruptedException e) {
				System.out.println("Interrupted");
			}
			System.out.println("Exiting.");
		}
		
		private void cycleAutomatedMove(int source, int target) throws InterruptedException {
			automateMove(source, target, 1);
			Thread.sleep(1200);
			automateMove(source, target, 2);
			Thread.sleep(1200);
			automateMove(source, target, 3);
			Thread.sleep(1200);
		}
	}
}

