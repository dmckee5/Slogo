package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Sine extends Command {
	
	private final int CHILDREN_REQUIRED = 1;

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		List<Double> parameters = recurseToGetParameters(params, controller);
		double angleInRadians = parameters.get(0)*(Math.PI/180.00);
		return Math.sin(angleInRadians);
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

}
