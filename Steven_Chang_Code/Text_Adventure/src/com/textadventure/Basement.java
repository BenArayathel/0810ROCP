package com.textadventure;

public class Basement extends Room {

	public Basement() {
		super("Basement");
		String description = "Although dim, and danky, it is not a horror film basement. \nIt has been transformed into what looks to be D&D game room,\nwith an expensive table, a minibar, and a mini projector.";
		this.setDescription(description);
	}
}
