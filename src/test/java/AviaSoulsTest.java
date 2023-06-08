import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    AviaSouls aviaSouls = new AviaSouls();
    Ticket t1 = new Ticket("Москва", "Краснодар", 15_000, 12, 14);
    Ticket t2 = new Ticket("Казань", "Москва", 7_500, 7, 13);
    Ticket t3 = new Ticket("Ростов", "Екатеринбург", 10_000, 13, 18);
    Ticket t4 = new Ticket("Москва", "Краснодар", 12_000, 10, 13);
    Ticket t5 = new Ticket("Москва", "Краснодар", 25_000, 12, 13);
    Ticket t6 = new Ticket("Пермь", "Ростов", 25_000, 9, 15);

    @BeforeEach
    public void setup() {
        aviaSouls.add(t1);
        aviaSouls.add(t2);
        aviaSouls.add(t3);
        aviaSouls.add(t4);
        aviaSouls.add(t5);
        aviaSouls.add(t6);
    }

    @Test
    public void shouldCompareIfLess() {

        int expected = -1;
        int actual = t2.compareTo(t1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldСompareIfMore() {

        int expected = 1;
        int actual = t4.compareTo(t3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareIfEqual() {

        int expected = 0;
        int actual = t5.compareTo(t6);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByPrice() {

        Ticket[] expected = {t4, t1, t5};
        Ticket[] actual = aviaSouls.search("Москва", "Краснодар");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOne() {
        Ticket[] expected = {t3};
        Ticket[] actual = aviaSouls.search("Ростов", "Екатеринбург");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMoreOne() {
        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Ростов", "Анапа");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSortByTime() {
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {t5, t1, t4};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Краснодар", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}
