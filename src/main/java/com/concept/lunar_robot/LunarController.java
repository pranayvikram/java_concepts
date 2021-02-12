package com.concept.lunar_robot;

public class LunarController {

	private boolean instructionError = false;
	private CoOrdinate borderCord = new CoOrdinate(50, 50, 'N');
	
	public static void main(String...strings) {
		
		String code = "LLLLSSSSR";
		CoOrdinate presentCord = new CoOrdinate(25, 25, 'E');
		LunarController lc = new LunarController();
		
		System.out.println("#############     Enter Instruction      #############");
		System.out.println("Input: ");
		
		
		System.out.println("#############   Enter Start Coordinate   #############");
		System.out.println("Input: ");
		
		lc.startRobot(presentCord, code);
	}
	
	private void startRobot(CoOrdinate presentCord, String code) {
		
		CoOrdinate nextCord = new CoOrdinate(presentCord.xc, presentCord.yc, presentCord.dir);
		for (int charIndex = 0; charIndex < code.length(); charIndex++) {
			char step = code.charAt(charIndex);
			nextCord = findNextCoordinate(nextCord, step);
		}
		this.displayMap(presentCord, nextCord);
	}
	
	private CoOrdinate findNextCoordinate(CoOrdinate presentCord, char step) {
		
		CoOrdinate nextCord = new CoOrdinate(0, 0, 'N');
		switch (step) {
			case 'L': nextCord = moveNextCord(presentCord, -1, 0, 0);
					  break;
					  
			case 'R': nextCord = moveNextCord(presentCord, 1, 0, 0);
					  break;
					  
			case 'S': nextCord = moveNextCord(presentCord, 0, 1, 2);
					  break;
			default:  instructionError = true;
		}
		return nextCord;
	}
	
	private CoOrdinate moveNextCord (CoOrdinate presentCord, int x, int y, int adj) {
		
		switch (presentCord.dir) {
		case 'N': presentCord.xc = presentCord.xc + x;
				  presentCord.yc = presentCord.yc + y;
				  presentCord.dir = (x == 0) ? presentCord.dir : (x == 1 ? 'E' : 'W');
				  break;
				  
		case 'S': presentCord.xc = presentCord.xc - x;
		  		  presentCord.yc = presentCord.yc - y;
		  		  presentCord.dir = (x == 0) ? presentCord.dir : (x == 1 ? 'W' : 'E');
		  		  break;
		  		  
		case 'E': presentCord.xc = presentCord.xc - y + adj;
		    	  presentCord.yc = presentCord.yc - x;
		    	  presentCord.dir = (x == 0) ? presentCord.dir : (x == 1 ? 'S' : 'N');
		    	  break;
		    	  
		case 'W': presentCord.xc = presentCord.xc + y - adj;
		  		  presentCord.yc = presentCord.yc + x;
		  		  presentCord.dir = (x == 0) ? presentCord.dir : (x == 1 ? 'N' : 'S');
		  		  break;
		  		  
		default: 
			System.out.println("#############   Error in next coordinate   #############"
					+"\nX:" + presentCord.xc + "  Y:"+ presentCord.yc);
		}
		return presentCord;
	}
		
	private void displayMap(CoOrdinate startCord, CoOrdinate endCord) {

		System.out.println("Start :- X:" + startCord.xc + "  Y:"+ startCord.yc);
		System.out.println("Start :- X:" + endCord.xc + "  Y:"+ endCord.yc);
		if (instructionError) {
			System.out.println("#############   Instruction Error   #############");
		}
		for (int xCord = 0; xCord < borderCord.xc; xCord++) {
			for (int yCord = 0; yCord < borderCord.xc; yCord++) {
				 if (endCord.xc == xCord && endCord.yc == yCord) {
					System.out.print("E ");
				} else if (startCord.xc == xCord && startCord.yc == yCord) {
					System.out.print("S ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println("");
		}
	}
}
