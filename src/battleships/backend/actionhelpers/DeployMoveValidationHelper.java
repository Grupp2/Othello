package battleships.backend.actionhelpers;

import battleships.backend.State;
import battleships.backend.classhelpers.DeployMoveHelper;
import battleships.backend.classhelpers.DeployPieceHelper;
import game.impl.Move;

public class DeployMoveValidationHelper implements MoveValidatable {
	private State state;
    private DeployMoveHelper moveHelper;
    private DeployPieceHelper pieceHelper;
	
	public DeployMoveValidationHelper(State state, DeployMoveHelper moveHelper, DeployPieceHelper pieceHelper){
        this.state = state;
        this.moveHelper = moveHelper;
        this.pieceHelper = pieceHelper;
    }
	
	public DeployMoveValidationHelper(State state){
        this(state, new DeployMoveHelper(state), new DeployPieceHelper());
    }

	@Override
	public boolean makeMoveValidation(Move move) {
		if(isRequestForRepublish(move)){
            state.setMessage("");
            return false;
        }

        if(!isPlayersTurnToMove(move)){
            state.setMessage("It's not your turn!");
            return false;
        }

//        if(!doesDestinationExist(move)){
//            state.setMessage("Invalid location!");
//            return false;
//        }

        if(!isDestinationEmpty(move)){
            state.setMessage("There is already a piece in that location!");
            return false;
        }

        if(isTryingToMovePieceAlreadyPlaced(move)){
            state.setMessage("You cannot move a piece already placed on the board.");
            return false;
        }

//        if(!isValidOthelloMove(move)){
//            state.setMessage("You have to put your piece at a valid location!");
//            return false;
//        }

        state.setMessage("");
        return true;
	}

	public boolean isRequestForRepublish(Move move){
        return move == null;
    }

    public boolean isPlayersTurnToMove(Move move){
        return move.getPlayer() == state.getCurrentPlayer();
    }

//    public boolean doesDestinationExist(Move move){
//        return move.getDestination() != null && boardHelper.doesLocationExistOnBoard(move.getDestination());
//    }

    public boolean isDestinationEmpty(Move move){
        return move.getDestination().getPiece() == null;
    }

    public boolean isTryingToMovePieceAlreadyPlaced(Move move){
        return move.getSource() != null;
    }

//    public boolean isValidOthelloMove(Move move){
//        return moveHelper.isLocationValidForDeployForPlayer(move.getDestination(), move.getPlayer());
//    }
}
