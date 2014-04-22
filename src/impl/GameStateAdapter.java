package impl;


import game.api.GameState;
import game.impl.Board;
import game.impl.DieRollFactory;
import game.impl.Move;
import game.impl.Player;

import java.util.List;

public class GameStateAdapter implements GameState{

    private State state;
    private ActionHandler actionHandler;

    public GameStateAdapter(State state, ActionHandler actionHandler){
        this.state = state;
        this.actionHandler = actionHandler;
    }

    @Override
    public List<Player> getPlayers() {
        return state.getPlayers();
    }

    @Override
    public Board getBoard() {
        return state.getBoard();
    }

    @Override
    public String getMessage() {
        return state.getMessage();
    }


    @Override
    public Player getLastPlayer() {
        return state.getLastPlayer();
    }

    @Override
    public Player getPlayerInTurn() {
        return state.getCurrentPlayer();
    }

    @Override
    public Boolean hasEnded() {
        return state.hasEnded();
    }

    @Override
    public Player getWinner() {
        return state.getWinner();
    }



    @Override
    public DieRollFactory getDieRollFactory() {
        return null;
    }





    @Override
    public Boolean proposeMove(Move move) {
        if(!actionHandler.validateMove(move))
            return false;

        actionHandler.executeMove(move);
        return true;
    }

    @Override
    public void reset() {
        actionHandler.reset();
    }
}
