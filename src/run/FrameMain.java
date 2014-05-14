package run;

import gui.GameFrame;
import gui.GameSelectorPanel;
import gui.listeners.GameSelectorListeners;

public class FrameMain {


    public static void main(String[] args){

        GameFrame theFrame = new GameFrame();
        theFrame.setTitle("Gameboard project");

        GameSelectorPanel selectorPanel = new GameSelectorPanel();
        GameSelectorListeners listener = new GameSelectorListeners(selectorPanel, theFrame);

        theFrame.setContentPane(selectorPanel);
    }
}