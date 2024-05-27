import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class GameTests {

    @Test
    public void TicTacToeGameEvaluatePositionPlayingAfterMoveTest() {
        Game game = new Game();
        char[] moves = {
                'X', ' ', 'X',
                ' ', 'O', ' ',
                'O', 'X', 'O'
        };

        int value = game.evaluatePosition(moves, game.player1);

        assertEquals(value, -1);
    }

    @Test
    public void TicTacToeGameMinimaxBestMoveTest() {
        Game game = new Game();
        char[] moves = {
                'X', ' ', ' ',
                ' ', ' ', ' ',
                ' ', ' ', ' '
        };
        int bestMove = game.MiniMax(moves, game.player2);

        assertTrue(bestMove >= 1 && bestMove <= 9);
    }

    @Test
    public void TicTacToeCellSetMarkerTest() {
        TicTacToeCell cell = new TicTacToeCell(1, 0, 0);
        cell.setMarker("X");

        assertEquals(cell.getMarker(), 'X');
    }

    @Test
    public void TicTacToeCellGetRowAndColTest() {
        TicTacToeCell cell = new TicTacToeCell(1, 2, 0);

        assertEquals(cell.getRow(), 0);
        assertEquals(cell.getCol(), 2);
    }

    @Test
    public void TicTacToeCellGetNumTest() {
        TicTacToeCell cell = new TicTacToeCell(5, 1, 1);

        assertEquals(cell.getNum(), 5);
    }

    @Test
    public void TicTacToePanelPlayerSwitchAfterMoveTest() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3, 3));
        Game game = panel.game;
        panel.actionPerformed(new ActionEvent(panel.cells[0], ActionEvent.ACTION_PERFORMED, null));

        assertNotEquals(game.cplayer, game.player1);
    }

    @Test
    public void TicTacToePanelGameOverAfterWinTest() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3, 3));
        Game game = panel.game;

        panel.cells[0].setMarker("X");
        panel.cells[1].setMarker("X");
        panel.cells[2].setMarker("X");

        assertEquals(game.state, State.XWIN);
    }

    @Test
    public void TicTacToePanelGameOverAfterDrawTest() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3, 3));
        Game game = panel.game;

        panel.cells[0].setMarker("X");
        panel.cells[1].setMarker("O");
        panel.cells[2].setMarker("X");
        panel.cells[3].setMarker("O");
        panel.cells[4].setMarker("X");
        panel.cells[5].setMarker("X");
        panel.cells[6].setMarker("O");
        panel.cells[7].setMarker("X");
        panel.cells[8].setMarker("O");

        assertEquals(game.state, State.DRAW);
    }
}