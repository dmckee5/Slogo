package slogo.commands;

import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;

public class PenDown extends TurtleCommand {

	private final int CHILDREN_REQUIRED = 0;
	
//	@Override
//	public double doCommand(List<NodeObject> params, EngineController controller) {
//		return controller.getMainCharacter().setPenDown(true);
//	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

	@Override
	public double doTurtling(MainCharacter turtle, EngineController controller) {
		return turtle.setPenDown(true);
	}

}
