package v2;

import java.util.ArrayList;

/**
 * hold favourite musics
 */
public class Favourites {
    /// create new collection
    private MusicCollection favList ;

    /**
     * create a instance of Favourite class
     */
    Favourites(){
        favList= new MusicCollection();
    }

    /**
     * added musics to favourite list
     * @param m music that we want to add
     */
    public void addMusic(Music m){
        for(Music music: MusicCollection.musicStorage){
            if(m==music){
                favList.addFile(m);
                return;
            }
        }
        System.out.println("music is not in music storage .");
        MusicCollection.musicStorage.add(m);
        favList.addFile(m);
        System.out.println("music is downloaded and added to your favourite list");
    }

    /**
     * remove a music from favourite list
     * @param m music that we want to remove
     */
    public void removeMusic(Music m){
        ArrayList<Music> musicList = favList.getFiles();
        if(musicList.contains(m)){
            musicList.remove(m);
        }
        else {
            System.out.println("favourite list havent this music!");
        }
    }

    /**
     * show the list of favourite musics
     */
    public void showFavouriteMusics(){
        System.out.println("-------------------------------\n"+"favourite musics:");
        favList.listAllFiles();
        System.out.println("-------------------------------");
    }


    public void search(String str){
        favList.search(str);
    }
    public void startPlaying(int index)
    {
        favList.startPlaying(index);
    }

    public void stopPlaying()
    {
        favList.stopPlaying();
    }

}
