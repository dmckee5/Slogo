package slogo.interpreter;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import slogo.commands.Command;
import slogo.commands.Forward;

public class CommandLibrary {

	private final String DEFAULT_RESOURCE_PACKAGE = "resources/languages/English";
	private Map<String, Command> myCommandMap;
	private ResourceBundle myCommandResources;

	// need to add MainCharacter as a parameter to constructor
	// once interface is up and running
	public CommandLibrary() {
		myCommandResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);
		makeCommandMap(myCommandResources);
	}

	public Command getCommand(String name) {
		return myCommandMap.get(name);
	}

	private void makeCommandMap(ResourceBundle commandResources) {
		myCommandMap = new HashMap<String, Command>();
		Enumeration<String> commandNames = commandResources.getKeys();
		while (commandNames.hasMoreElements()) {
			String commandName = commandNames.nextElement();
			try {
				Class commandClass = Class.forName("slogo.commands." + commandName);
				Command command = (Command) commandClass.newInstance();
				myCommandMap.put(commandName, command);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
