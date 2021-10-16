package v2;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael Kِlling
 * @version 2011.07.31
 */
public class MusicCollection
{

    // An ArrayList for storing the file names of music files.
    private ArrayList<Music> files;
    // A player for the music files.
    private MusicPlayer player;
    // hold all of the storage musics
    public static HashSet<Music> musicStorage = new HashSet<>();

    /**
     * Create a MusicCollection
     */
    public MusicCollection()
    {
        files = new ArrayList<>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(Music filename)
    {
        files.add(filename);
        musicStorage.add(filename);
    }

    /**
     * get files field
     * @return files
     */
    public ArrayList<Music> getFiles() {
        return files;
    }

    /**
     * set the files list
     * @param files list of musics
     */
    public void setFiles(ArrayList<Music> files) {
        this.files = files;
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if (validIndex(index))
            files.get(index).print();
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        System.out.println("List of music:");
        for (Music m : files){
            m.print();
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if (validIndex(index))
            files.remove(index);
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        if (validIndex(index))
            player.startPlaying(files.get(index));
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }


    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        if(index>0 && index<files.size())
            return true;
        else {
            System.out.println("the index is out of range!");
            return false;
        }

    }

    /**
     * search in music info
     * @param str the string that should be searched
     */
    public void search(String str){
        System.out.println("----------------------------------\n"+"search result:");
        searchAddress(str);
        searchSinger(str);
        searchRelease(str);
        System.out.println("----------------------------------");

    }

    /**
     * search in music's addresses
     * @param str the string that should be searched
     */
    private void searchAddress(String str){
        for (Music m : files){
            if(m.getMusicAddress().contains(str)){
                m.print();
            }
        }
    }
    /**
     * search in music's singer
     * @param str the string that should be searched
     */
    private void searchSinger(String str){
        for (Music m : files){
            if(m.getSinger().contains(str)){
                m.print();
            }
        }
    }
    /**
     * search in music's release years
     * @param str the string that should be searched
     */
    private void searchRelease(String str){
        for (Music m : files){
            if(m.getRelease().contains(str)){
                m.print();
            }
        }
    }

}