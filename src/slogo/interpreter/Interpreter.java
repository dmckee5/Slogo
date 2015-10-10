package slogo.interpreter;

import slogo.screen.SlogoScreen;

public class Interpreter {
	private String myLanguage;
	private SlogoScreen myView;
	private CommandTree myTree;

	public Interpreter(String language, SlogoScreen view) {
		myLanguage = language;
		myView = view;
	}

	public void interpret(String input) {
		CommandTree tree = new CommandTree();
		tree.build(input);
		tree.run();
		
	}

}