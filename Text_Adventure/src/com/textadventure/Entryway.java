package com.textadventure;

public class Entryway extends Room {

	public Entryway() {
		super("Entryway");
		String description = "It is a somewhat narrow entryway. The brown doormat welcomes you with a cursive \"Hello.\"";
		this.setDescription(description);
		setSpecialOption();
	}

	@Override
	public void setSpecialOption() {
		this.addOption("exit");
	}

	@Override
	public Room doSpecialOption() {
		System.out.println("Exiting Premise");
		return null;
		
	}
	
}
