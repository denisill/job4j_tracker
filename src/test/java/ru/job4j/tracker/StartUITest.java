package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = Tracker.getInstance();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Exit Program ===" + System.lineSeparator()
        ));
    }

   @Test
    public void whenShowAll() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "1"});
        Tracker tracker = Tracker.newTestTracker();
        Item item0 = new Item();
        item0.setName("New Item");
        Item item = tracker.add(item0);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Show all items ===" + System.lineSeparator()
                        + "1. === Exit Program ===" + System.lineSeparator()
                        + "Item{id=1, name='New Item'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Show all items ===" + System.lineSeparator()
                        + "1. === Exit Program ===" + System.lineSeparator()

        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        String findName = "New Item1";
        Input in = new StubInput(new String[]{"0", findName, "1"});
        Tracker tracker = Tracker.newTestTracker();
        Item item1 = new Item();
        item1.setName("New Item1");
        tracker.add(item1);
        Item item2 = new Item();
        item2.setName("New Item2");
        tracker.add(item2);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Find items by name ===" + System.lineSeparator()
                        + "1. === Exit Program ===" + System.lineSeparator()
                        + "Item{id=1, name='New Item1'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Find items by name ===" + System.lineSeparator()
                        + "1. === Exit Program ===" + System.lineSeparator()

        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        Item item1 = new Item();
        item1.setName("New Item1");
        tracker.add(item1);
        Item item2 = new Item();
        item2.setName("New Item2");
        tracker.add(item2);
        Input in = new StubInput(new String[]{"0", String.valueOf(item2.getId()), "1"});
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Find item by Id ===" + System.lineSeparator()
                        + "1. === Exit Program ===" + System.lineSeparator()
                        + "Item{id=2, name='New Item2'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Find item by Id ===" + System.lineSeparator()
                        + "1. === Exit Program ===" + System.lineSeparator()

        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = Tracker.getInstance();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. === Exit Program ===%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. === Exit Program ===%n"
                )
        ));
    }

}