package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Pi extends Command {

	private final int CHILDREN_REQUIRED = 0;

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		return Math.PI;
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}
	
}
