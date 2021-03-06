package slogo.interpreter;

public class InputObject {
	private String myType;
	private String myValue;
	private String myRawRepresentation;
	
	public InputObject(String type, String expr, String raw) {
		myType = type;
		myValue = expr;
		myRawRepresentation = raw;
	}

	public String getValue(){
		return myValue;
	}
	
	public String getType(){
		return myType;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if (! (obj instanceof InputObject)) return false;
		return myType.equals(((InputObject) obj).getType()) && myValue.equals(((InputObject) obj).getValue()); 
	}

	public void changeType(String type) {
		myType = type;
		
	}
	
	@Override
	public String toString() {
		return myType + " " + myValue;
	}
	
	public String getRawString(){
		return myRawRepresentation;
	}

}
