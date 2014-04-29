package backend.undoableactions;


import backend.State;
import backend.actions.LocationsToFlipCalculation;
import backend.util.GameRules;
import game.impl.BoardLocation;
import game.impl.Player;

import java.util.List;

public class TurnIncrementAction implements UndoableAction{

    private State state;

    private Player oldCurrentPlayer;
    private Player oldLastPlayer;

    public TurnIncrementAction(State state){
        this.state = state;
    }


    public void execute(){

        oldCurrentPlayer = state.getCurrentPlayer();
        oldLastPlayer = state.getLastPlayer();

        if(!isLastPlayerSet()) {
            List<Player> players = state.getPlayers();

            if (players.indexOf(state.getCurrentPlayer()) == 0)
                state.setLastPlayer(players.get(1));
            else
                state.setLastPlayer(players.get(0));
        }

        swapCurrentAndLastPlayer();

        if(!GameRules.doesCurrentPlayerHaveAnyValidMovesLeft(state))
            swapCurrentAndLastPlayer();

    }

    public void undo(){
        state.setLastPlayer(oldLastPlayer);
        state.setCurrentPlayer(oldCurrentPlayer);
    }

    public String getName(){
        return "Change of Turn";
    }


    private boolean isLastPlayerSet(){
        return state.getLastPlayer() != null;
    }

    private void swapCurrentAndLastPlayer(){
        Player newCurrentPlayer = state.getLastPlayer();
        state.setLastPlayer(state.getCurrentPlayer());
        state.setCurrentPlayer(newCurrentPlayer);
    }


}
