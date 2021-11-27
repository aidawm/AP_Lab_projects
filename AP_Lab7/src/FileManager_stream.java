
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager_stream extends FileManager{

    /**
     * add new note
     * @param stringName file name
     * @param notes notes streams
     */
    @Override
    public void addNewNote(String stringName , ArrayList<String> notes){
        FileOutputStream out=null;
        try {
            out = new FileOutputStream(path.toFile().getAbsoluteFile()+"\\"+stringName);
            for (String note:notes){
                note+="\n";
                byte[] bytes=note.getBytes();
                out.write(bytes);
            }
        }catch (IOException e){

        }
        finally {
            if(out!=null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * show a summary of note
     * @param stringName file name
     */
    @Override
    public void showSummaryNote(String stringName){

        try {
            FileInputStream in = new FileInputStream(path.toFile().getAbsoluteFile()+"\\"+stringName);
            int c, max_byte=50,i=0;
            String summary="";

            while((c=in.read())!=-1 && i<max_byte){
                summary+=Character.toString(c);
                i++;
            }
            System.out.println(summary);
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    /**
     * show the whole of the note text
     * @param stringName file name
     */
    @Override
    public void showDetail(String stringName){

        try {
            FileInputStream in = new FileInputStream(path.toFile().getAbsoluteFile()+"\\"+stringName);
            int c;
            String summary="";

            while((c=in.read())!=-1){
                summary+=Character.toString(c);
            }
            System.out.println(summary);
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
