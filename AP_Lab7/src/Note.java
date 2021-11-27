import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;

/**
 * holds note information
 */
public class Note implements Serializable {
    private static final long serialVersionUID =12364745745767L;
    /// file name
    private String fileName;
    ///notes list
    private ArrayList<String> notes;
    /// date
    private LocalDate date;

    /**
     * create a object from note
     * @param fileName file name
     * @param notes notes list
     */
    public Note(String fileName,ArrayList<String> notes){
        this.fileName=fileName;
        this.notes=notes;
        date= LocalDate.now();
    }


    /**
     * get file name
     * @return fileName field
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * get file's notes
     * @return notes field
     */
    public ArrayList<String> getNotes() {
        return notes;
    }
}
