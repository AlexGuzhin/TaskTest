package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(1, "Позвонить домой");

        boolean expected = true;
        boolean actual = task.matches("Позвонить");

        Assertions.assertTrue(actual);
    }
    @Test
    public void testSimpleTaskNotMatches() {
        SimpleTask task = new SimpleTask(1, "Позвонить домой");

        boolean expected = true;
        boolean actual = task.matches("Написать");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testIfMatchEpic() {
        String[] subtask = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(5, subtask);

        boolean expected = true;
        boolean actual = epic.matches("Яйца");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testIfNotMatchEpic() {
        String[] subtask = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(5, subtask);

        boolean expected = false;
        boolean actual = epic.matches("Попить");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testIfMatchByProjectMeeting() {
        Meeting meeting = new Meeting(555,"Выкатка 3й версии приложения","Приложение НетоБанка","Во вторник после обеда");

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIfNotMatchByTopicMeeting() {
        Meeting meeting = new Meeting(555,"Выкатка 3й версии приложения","Приложение НетоБанка","Во вторник после обеда");

        boolean expected = false;
        boolean actual = meeting.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIfNotMatchByProjectMeeting() {
        Meeting meeting = new Meeting(555,"Выкатка 3й версии приложения","Приложение НетоБанка","Во вторник после обеда");

        boolean expected = false;
        boolean actual = meeting.matches("Версия");

        Assertions.assertEquals(expected, actual);
    }

}