package slogo.interpreter;

import java.util.HashMap;
import java.util.Map;

import slogo.commands.Command;
import slogo.commands.Forward;

public class CommandLibrary {
	Map<String, Command> commandMap; 
	
	// need to add MainCharacter as a parameter to constructor
	// once interface is up and running
	public CommandLibrary() {
		commandMap = new HashMap<>();
		// TODO add all default command objects to command map using 
		// reflection with names in properties doc
		Command forward = new Forward();
		commandMap.put("Forward", forward);
	}

	public static Command getAction(String next) {
		// TODO Auto-generated method stub
		return null;
	}

}