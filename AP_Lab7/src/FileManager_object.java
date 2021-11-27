import javax.tools.FileObject;
import java.io.*;
        import java.util.ArrayList;

/**
 * file manager with object
 */
public class FileManager_object extends FileManager{

    ///// list of notes
    private ArrayList<Note> notes ;

    /**
     * add new note
     * @param stringName file name
     * @param notes notes streams
     */
    @Override
    public void addNewNote(String stringName , ArrayList<String> notes){

        try (ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(path.toFile().getAbsoluteFile()+"\\"+stringName))){
            Note note=new Note(stringName,notes);
            read_File(stringName);
            this.notes.add(note);

            out.writeObject(note);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * show a summary of note
     * @param stringName file name
     */
    @Override
    public void showSummaryNote(String stringName){
        read_File(stringName);
        for (Note note:notes){
            if (note.getFileName().equals(stringName))
                if(note.getNotes().get(0)!=null)
                    System.out.println(note.getNotes().get(0));
        }
    }
    /**
     * show the whole of the note text
     * @param stringName file name
     */
    @Override
    public void showDetail(String stringName){
        read_File(stringName);
        for (Note note:notes){
            if (note.getFileName().equals(stringName))
                for (String str :note.getNotes()){
                    System.out.println(str);
                }
        }
    }

    /**
     * read file
     * @param stringName file name
     */
    private void read_File(String stringName){
        notes=new ArrayList<>();
        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream(new FileInputStream(path.toFile().getAbsoluteFile()+"\\"+stringName));

            for (;;){
                try {
                    Note note= (Note)in.readObject();
                    notes.add(note);
                }catch (ClassNotFoundException | IOException e){

                    break;
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(in!=null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
