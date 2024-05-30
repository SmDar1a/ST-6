package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameTests {

    private static Game game;

    @BeforeAll
    public static void setUp() {
        game = new Game();
    }

    @Test
    public void testGameStateChangeAfterPlayerMove() {
        game.board[0] = 'X';
        game.symbol = 'X';
        assertNotEquals(State.PLAYING, game.checkState(game.board));
    }

    @Test
    public void testBoardNotEmptyAfterPlayerMove() {
        game.board[4] = 'O';
        assertNotEquals(' ', game.board[4]);
    }

    @Test
    public void testPlayerMoveOutOfBounds() {
        game.player1.move = 10;
        assertEquals(State.PLAYING, game.checkState(game.board));
    }

    @Test
    public void testCurrentPlayerChangeAfterMove() {
        game.symbol = 'O';
        game.nmove = 2;
        game.player2.move = 2;
        assertNotEquals(game.player2, game.cplayer);
    }

    @Test
    public void testGameEndAfterPlayerWin() {
        game.state = State.XWIN;
        assertNotEquals(State.PLAYING, game.state);
    }

    @Test
    public void testGameEndAfterDraw() {
        game.state = State.DRAW;
        assertNotEquals(State.PLAYING, game.state);
    }

    @Test
    public void testCellStateChangeAfterMarkerSet() {
        TicTacToeCell cell = new TicTacToeCell(2, 0, 1);
        cell.setMarker("X");
        assertFalse(cell.isEnabled());
    }

    @Test
    public void testWinningCombinationDetection() {
        game.board[0] = 'X';
        game.board[1] = 'X';
        game.board[2] = 'X';
        game.symbol = 'X';
        assertEquals(State.XWIN, game.checkState(game.board));
    }
}