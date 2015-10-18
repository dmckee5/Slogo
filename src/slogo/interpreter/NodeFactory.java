package slogo.interpreter;

import slogo.nodes.CommandDeclarationNode;
import slogo.nodes.CommandNode;
import slogo.nodes.ConstantNode;
import slogo.nodes.ListEndNode;
import slogo.nodes.ListStartNode;
import slogo.nodes.NodeObject;
import slogo.nodes.UserCommandNode;
import slogo.nodes.VariableNode;

public class NodeFactory{

	private CommandLibrary myCommandLibrary;
	private VariableLibrary myVariables;
	private TemporaryCommandLibrary tempActions;

	public NodeFactory(CommandLibrary actions, VariableLibrary variables, TemporaryCommandLibrary temps) {
		myCommandLibrary = actions;
		myVariables = variables;
		tempActions = temps;
	}
	
	public NodeObject create(InputObject input, NodeObject parent) {
		NodeObject new_node = null;
		String type = input.getType();
		String value = input.getValue();
		System.out.println(type + " " + value);
		switch(type){
		case "Command":
			if (myCommandLibrary.getCommand(value) != null) {
			new_node = new CommandNode(value, myCommandLibrary.getCommand(value), parent);
			} else {
				if (tempActions.getNumParameters(value) == null) {
					throw new InterpreterException("User command %s does not exist", value);
				}
				new_node = new UserCommandNode(parent, value, tempActions.getNumParameters(value));
			}
			break;
		case "CommandDeclaration":
			new_node = new CommandDeclarationNode(value, parent);
			break;
		case "Constant": 
			new_node = new ConstantNode(value, parent);
			break;
		case "ListStart":
			new_node = new ListStartNode(value, parent);
			break;
		case "ListEnd":
			new_node = new ListEndNode(value, parent);
			break;
		case "Variable":
			new_node = new VariableNode(value, parent);
			break;
		}
		return new_node;		
	}

}