package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void winTwo() {
        Player kolya = new Player(1, "Kolya", 150);
        Player misha = new Player(2, "Misha", 300);
        Game game = new Game();
        game.register(kolya);
        game.register(misha);
        int actual = game.round("Kolya", "Misha");
        int expected = 2;
        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void winOne() {
        Player kolya = new Player(1, "Kolya", 150);
        Player misha = new Player(2, "Misha", 100);
        Game game = new Game();
        game.register(kolya);
        game.register(misha);
        int actual = game.round("Kolya", "Misha");
        int expected = 1;
        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void draw() {
        Player kolya = new Player(1, "Kolya", 350);
        Player misha = new Player(2, "Misha", 350);
        Game game = new Game();
        game.register(kolya);
        game.register(misha);
        int actual = game.round("Kolya", "Misha");
        int expected = 0;
        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void exceptionOnePlayer() {
        Player kolya = new Player(1, "Kolya", 150);
        Player misha = new Player(2, "Misha", 300);
        Game game = new Game();
        game.register(kolya);
        game.register(misha);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Masha", "Misha")
        );

    }
    @Test
    public void exceptionTwoPlayer() {
        Player kolya = new Player(1, "Kolya", 150);
        Player misha = new Player(2, "Misha", 300);
        Game game = new Game();
        game.register(kolya);
        game.register(misha);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Kolya", "Masha")
        );

    }
}
