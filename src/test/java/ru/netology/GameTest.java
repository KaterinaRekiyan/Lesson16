package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void FirstPlayerStrengther() {
        Game game = new Game();
        Player player1 = new Player(1, "Vasiliy", 100);
        Player player2 = new Player(2, "Mihail", 50);

        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("Vasiliy", "Mihail");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SecondPlayerStrengther() {
        Game game = new Game();
        Player player1 = new Player(1, "Vasiliy", 100);
        Player player2 = new Player(2, "Mihail", 150);

        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("Vasiliy", "Mihail");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void AreEqualPlayersStrengther() {
        Game game = new Game();
        Player player1 = new Player(1, "Vasiliy", 100);
        Player player2 = new Player(2, "Mihail", 100);

        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round("Vasiliy", "Mihail");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NotFirstPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "Vasiliy", 80);
        Player player2 = new Player(2, "Mihail", 100);

        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Victor", "Mihail"));
    }

    @Test
    public void NotSecondPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "Vasiliy", 100);
        Player player2 = new Player(2, "Mihail", 80);

        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Mihail", "Victor"));
    }

    @Test
    public void NotPlayers() {
        Game game = new Game();
        Player player1 = new Player(1, "Vasiliy", 100);
        Player player2 = new Player(2, "Mihail", 80);

        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Nika", "Victor"));
    }
}
