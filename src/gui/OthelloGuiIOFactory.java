package gui;

import game.io.InputUnit;
import game.io.IoFactory;
import game.io.OutputUnit;

public class OthelloGuiIOFactory implements IoFactory{
	private InputUnit inputUnit = new OthelloGuiInputUnit();
	private OutputUnit outputUnit = new OthelloGameFrame();

	@Override
	public InputUnit getInputUnit() {
		return inputUnit;
	}

	@Override
	public OutputUnit getOutputUnit() {
		return outputUnit;
	}
}