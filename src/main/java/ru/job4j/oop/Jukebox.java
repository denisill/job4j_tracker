package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        int song1 = 1;
        jukebox.music(song1);
        int song2 = 2;
        jukebox.music(song2);
        int noSong = 3;
        jukebox.music(noSong);
    }
}
