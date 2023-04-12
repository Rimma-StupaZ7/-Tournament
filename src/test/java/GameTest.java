import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testWhenFirstPlayerWin() {
        Game game = new Game();
        Player vania = new Player(1, "Ваня", 10);
        Player kati = new Player(4, "Катя", 9);
        Player mark13 = new Player(18, "Марк", 20);

        game.register(vania);
        game.register(kati);
        game.register(mark13);
        int actual = game.round("Марк", "Ваня");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testWhenSecondPlayerWin() {
        Game game = new Game();
        Player vania = new Player(1, "Ваня", 10);
        Player kati = new Player(4, "Катя", 9);
        Player mark13 = new Player(18, "Марк", 20);

        game.register(vania);
        game.register(kati);
        game.register(mark13);
        int actual = game.round("Ваня", "Марк");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenDrawPlayerWin() {
        Game game = new Game();
        Player vania = new Player(1, "vania", 20);
        Player mark13 = new Player(18, "mark13", 20);

        game.register(vania);
        game.register(mark13);
        int actual = game.round("vania", "mark13");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testWhenPlayerOneNotExist() {
        Game game = new Game();
        Player vania = new Player(1, "vania", 20);
        Player kati = new Player(4, "kati", 9);
        Player mark13 = new Player(18, "mark13", 20);

        game.register(vania);
        game.register(kati);
        game.register(mark13);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Nik", null);
        });
    }
    @Test
    public void testWhenPlayerTwoNotExist() {
        Game game = new Game();
        Player vania = new Player(1, "vania", 20);
        Player kati = new Player(4, "kati", 9);
        Player mark13 = new Player(18, "mark13", 20);

        game.register(vania);
        game.register(kati);
        game.register(mark13);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(null, "kati");
        });
    }
    @Test
    public void testWhenPlayerNotRegisteredExist() {
        Game game = new Game();
        Player vania = new Player(1, "vania", 20);
        Player kati = new Player(4, "kati", 9);
        Player mark13 = new Player(18, "mark13", 20);

        game.register(vania);
        game.register(kati);
        game.register(mark13);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(null, null);
        });
    }
    @Test
    public void testWhenPlayerNotExist() {
        Game game = new Game();
        Player vania = new Player(1, "vania", 20);
        Player kati = new Player(4, "kati", 9);
        Player mark13 = new Player(18, "mark13", 20);

        game.register(vania);
        game.register(kati);
        game.register(mark13);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Nik", "kati");
        });
    }
    @Test
    public void testNotRegisteredPlayerTwo() {
        Game game = new Game();
        Player vania = new Player(1, "vania", 20);
        Player mark13 = new Player(18, "mark13", 20);

        game.register(vania);
        game.register(mark13);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("vania", null);
        });
    }
}
