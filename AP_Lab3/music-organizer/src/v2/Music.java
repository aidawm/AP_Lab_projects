package v2;

import java.util.TreeMap;

/**
 * this class hold information of a music
 */
public class Music {
    ///music address
    private String musicAddress;
    ///music's singer name
    private String singer;
    ///music's release year
    private String release;

    /**
     * make a instance of music
     * @param musicAddress music address
     * @param singer music's singer name
     * @param release music's release year
     */
    Music(String musicAddress, String singer, String release){
        this.musicAddress = musicAddress;
        this.singer=singer;
        if(checkRelease(release))
            this.release=release;
    }

    /**
     * get music's address
     * @return musicAddress field
     */
    public String getMusicAddress() {
        return musicAddress;
    }
    public void setMusicAddress(String musicAddress) {
        this.musicAddress = musicAddress;
    }
    /**
     * get music's singer
     * @return singer field
     */
    public String getSinger() {
        return singer;
    }

    /**
     * set music's singer name
     * @param singer singer name
     */
    public void setSinger(String singer) {
        this.singer = singer;
    }
    /**
     * get music's release
     * @return release field
     */
    public String getRelease() {
        return release;
    }

    /**
     * get music's release year
     * @param release release year
     */
    public void setRelease(String release) {
        this.release = release;
    }

    /**
     * print the music information
     */
    public void print(){
        System.out.println("music: "+musicAddress+"     singer: "+singer+"     release year: "+release);
    }

    /**
     * check the release year is valid or not
     * @param release release year
     * @return true if is valid
     */
    private boolean checkRelease(String release){
        if(release.length()>=2 && release.length()<=4){
            Integer i=Integer.valueOf(release);
            if(i>=1950 && i<2022){
                return true;
            }
        }
        System.out.println("invalid release year");
        return false;
    }
    
}
