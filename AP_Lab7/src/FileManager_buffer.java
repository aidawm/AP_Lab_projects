import java.io.*;
import java.util.ArrayList;

public class FileManager_buffer extends FileManager{

    /**
     * add new note
     * @param stringName file name
     * @param notes notes streams
     */
    @Override
    public void addNewNote(String stringName , ArrayList<String> notes){
        BufferedWriter out=null;
        try {
             out= new BufferedWriter(new FileWriter(path.toFile().getAbsoluteFile()+"\\"+stringName));
            for (String note:notes){
                note+="\n";
                out.write(note);
            }
        }catch (IOException e){

        }
        finally {
            if(out!=null){
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

        try (BufferedReader reader = new BufferedReader(new FileReader(path+"\\"+stringName))) {

            String strCurrentLine;
            int count,i=0;
            char[] buffer = new char[20];
            String summary="";
            while (reader.ready()&&i<2){
                count=reader.read(buffer);
                summary+= new String(buffer,0,count);
                i++;
            }
            System.out.println(summary);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * show the whole of the note text
     * @param stringName file name
     */
    @Override
    public void showDetail(String stringName){

        try (BufferedReader reader = new BufferedReader(new FileReader(path+"\\"+stringName))) {

            String strCurrentLine;
            int count;
            char[] buffer = new char[20];
            while (reader.ready()){
                count=reader.read(buffer);
                System.out.print(new String(buffer,0,count));
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
