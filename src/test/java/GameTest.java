import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(1, "Vasya", 50);
    Player player2 = new Player(2, "Olga", 25);
    Player player3 = new Player(3, "Vadim", 30);
    Player player4 = new Player(4, "Andrey", 30);


    @Test
    public void whenWinsTheFirstPlayer () {

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        int actual = game.round(player1.getName(), player2.getName());
        int expected = 1;

        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void whenWinsTheSecondPlayer() {

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        int actual = game.round(player2.getName(), player3.getName());
        int expected = 2;

        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void whenTheStrengthOfThePlayersAreEqual() {

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int actual = game.round(player3.getName(), player4.getName());
        int expected = 0;

        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void whenTheSecondPlayerNotRegistered() {

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round(player1.getName(), "Sonya");
        });

    }

    @Test
    public void whenTheFirstPlayerNotRegistered() {

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Sonya", player1.getName());
        });

    }


}
