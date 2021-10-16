package v1;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MusicCollection pop = new MusicCollection();
        MusicCollection rock = new MusicCollection();
        MusicCollection jazz = new MusicCollection();
        MusicCollection country = new MusicCollection();

        pop.addFile("whatever it takes");
        pop.addFile("believer");
        pop.addFile("lovely");
        pop.addFile("in the end");

        System.out.println(pop.getNumberOfFiles());
        pop.listAllFiles();

        pop.removeFile(4);
        System.out.println(pop.getNumberOfFiles());
        pop.removeFile(2);
        System.out.println(pop.getNumberOfFiles());
        pop.listAllFiles();

        pop.startPlaying(2);
        pop.stopPlaying();

    }


}
