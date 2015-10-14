package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;

public class SetPosition extends Command {

	@Override
	public double doCommand(MainCharacter character, List<Double> params) {
		// this still doesn't do the command on the front end, 
		// only gives the correct return value.
		if (getNumChildrenRequired() != params.size()){
			// something has gone wrong
		}
		
		double currentX = myCharacter.getImageView().getX();
		double currentY = myCharacter.getImageView().getY();
		double destinationX = params.get(0);
		double destinationY = params.get(1);
		double distance = Math.sqrt((destinationX - currentX)*(destinationX - currentX)
				+ (destinationY - currentY)*(destinationY - currentY));
		System.out.println("Setting new position: moved " + distance);
		return distance;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 2;
	}

}
