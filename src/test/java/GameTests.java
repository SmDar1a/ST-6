package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameTests {

    static Game game;

    @BeforeAll
    static void setup() {
        game = new Game();
    }

    @Test
    @DisplayName("Initial game state is PLAYING")
    public void testInitialGameState() {
        assertEquals(State.PLAYING, game.state);
    }

    @Test
    @DisplayName("Check win for X on the first row")
    public void testXWinFirstRow() {
        game.board[0] = 'X';
        game.board[1] = 'X';
        game.board[2] = 'X';
        game.symbol = 'X';
        assertEquals(State.XWIN, game.checkState(game.board));
    }

    @Test
    @DisplayName("Check win for O on the diagonal")
    public void testOWinDiagonal() {
        game.board[0] = 'O';
        game.board[4] = 'O';
        game.board[8] = 'O';
        game.symbol = 'O';
        assertEquals(State.OWIN, game.checkState(game.board));
    }

    @Test
    @DisplayName("Check draw state")
    public void testDrawState() {
        char[] drawBoard = {'X', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'X'};
        System.arraycopy(drawBoard, 0, game.board, 0, 9);
        game.symbol = 'X';
        assertEquals(State.DRAW, game.checkState(game.board));
    }

    @Test
    @DisplayName("Evaluate position: X winning")
    public void testEvaluatePositionXWin() {
        game.board[0] = 'X';
        game.board[1] = 'X';
        game.board[2] = 'X';
        game.symbol = 'X';
        assertEquals(Game.INF, game.evaluatePosition(game.board, game.player1));
    }

    @Test
    @DisplayName("MiniMax: Best move for player O")
    public void testMiniMaxMove() {
        game.board[0] = 'X';
        game.board[1] = 'O';
        game.board[2] = 'X';
        game.board[3] = 'X';
        game.board[4] = 'O';
        game.board[5] = ' ';
        game.board[6] = ' ';
        game.board[7] = ' ';
        game.board[8] = ' ';
        int move = game.MiniMax(game.board, game.player2);
        assertTrue(move > 0);
    }

    @Test
    @DisplayName("MaxMove returns a valid position")
    public void testMaxMove() {
        game.board[0] = 'X';
        game.board[1] = 'O';
        game.board[2] = 'X';
        game.symbol = 'O';
        int moveValue = game.MaxMove(game.board, game.player1);
        assertTrue(moveValue <= Game.INF);
    }
}
