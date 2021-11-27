import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * it simulate file manager
 */
public abstract class FileManager {
    ///// local path of directory
    public static Path path = Paths.get("F:\\University\\term 5\\advanced programming Lab\\AP_Lab_projects\\AP_Lab7\\src\\notes");

    /**
     * add new note
     * @param stringName file name
     * @param notes notes streams
     */
    abstract void addNewNote(String stringName , ArrayList<String> notes);

    /**
     * show a summary of note
     * @param fileName file name
     */
    abstract void showSummaryNote(String fileName);

    /**
     * show the whole of the note text
     * @param stringName file name
     */
    abstract void showDetail(String stringName);

    /**
     * show the directory's files
     */
    public void showCurrentFiles(){
        if(Files.isDirectory(path)){
            try {
                DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
                for (Path p: directoryStream){
                    System.out.println(p.getFileName());
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * remove a file
     * @param stringName file name
     */
    public void removeFile(String stringName){
        try
        {
            File file = new File(path.toFile().getAbsoluteFile()+"\\"+stringName);
            if(file.delete())
            {
                System.out.println(file.getName() + " deleted");
            }
            else
            {
                System.out.println("failed");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
