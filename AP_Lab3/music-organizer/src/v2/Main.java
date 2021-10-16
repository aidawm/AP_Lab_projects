package v2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MusicCollection pop = new MusicCollection();
        MusicCollection jazz = new MusicCollection();
        MusicCollection rock = new MusicCollection();
        MusicCollection country = new MusicCollection();

        ArrayList<Favourites> favouriteLists = new ArrayList<>();

        Music m1 = new Music("whatever it takes","imagine dragons","2010");
        Music m2 = new Music("believer","imagine dragons","2010");
        Music m3 = new Music("in the end","linkin park","2012");
        Music m4 = new Music("heavy","linkin park","2015");
        Music m5 = new Music("lovely","billie eilish","2017");
        Music m6 = new Music("demons","imagine dragons","2018");

        pop.addFile(m1);
        pop.addFile(m2);
        pop.addFile(m3);

        pop.listAllFiles();

        pop.removeFile(1);

        pop.listAllFiles();

        pop.search("imagine");


        favouriteLists.add(new Favourites());
        Favourites f1= favouriteLists.get(0);
        f1.addMusic(m1);
        f1.showFavouriteMusics();

        f1.addMusic(m4);
        f1.showFavouriteMusics();

        f1.removeMusic(m1);
        f1.showFavouriteMusics();
    }
}
