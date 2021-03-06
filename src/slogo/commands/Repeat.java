package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.interpreter.InterpreterException;
import slogo.nodes.ListStartNode;
import slogo.nodes.NodeObject;

public class Repeat extends Command {

	private static final String VARIABLE_NAME = ":repcount";
	private final int CHILDREN_REQUIRED = 2;
	
	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		double returnVal = 0; 
		// TODO add wrong node type checking
		System.out.println(params);
		int numRepeats = (int)params.get(0).traverseAndExecute(controller);
		System.out.println(numRepeats);
		// body of loop should have start list (open bracket) as parent
		NodeObject body = params.get(1);
		if (! (body instanceof ListStartNode)) {
			throw new InterpreterException("Expected [ for repeat loop");
		}
		for (int i = 1; i <= numRepeats; i ++ ){
			params.get(1).setLocalVariable(VARIABLE_NAME, i);
			returnVal = body.traverseAndExecute(controller);
		}
		
		return returnVal;
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

}
