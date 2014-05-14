package backend.classhelpers;

import backend.State;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MoveHelperTest {

    State state;
    BoardHelper boardHelper;

    MoveHelper moveHelper;

    @Before
    public void setUp() throws Exception {
        state = mock(State.class);
        boardHelper = mock(BoardHelper.class);

        moveHelper = new MoveHelper(state, boardHelper);
    }

    @Test
    public void testDoesPlayerHaveAnyValidMoves() throws Exception {

    }

    @Test
    public void testGetLocationsToFlipFromMove() throws Exception {

    }

    @Test
    public void testIsLocationValidOthelloMoveForPlayer() throws Exception {

    }
}
