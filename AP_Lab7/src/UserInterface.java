import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private FileManager fileManager;

    /**
     * create a new object from user interface
     */
    public UserInterface(){
//        fileManager=new FileManager_stream();
//        fileManager=new FileManager_buffer();
        fileManager=new FileManager_object();

    }

    /**
     * run the program
     */
    public void Run(){
        boolean exit=false;
        Scanner scan=new Scanner(System.in);
        while (!exit){
            printWelcome();
            String command = scan.next();
            try {
                exit=analyzer(command);
            }catch (Exception e){
                System.out.println("invalid command");
            }
        }

    }

    /**
     * print list of program abilities
     */
    private void printWelcome(){
        System.out.println("1. add new note");
        System.out.println("2. show note lists");
        System.out.println("3. remove note");
        System.out.println("4. show note's summary");
        System.out.println("5. show note's description");
        System.out.println("6. exit");
    }

    /**
     * analyze input command
     * @param command input command
     * @return true if want to exit program
     */
    private boolean analyzer(String command){
        int index = Integer.parseInt(command);
        switch (index){
            case 1:
                addNewNote();
                break;
            case 2:
                showFileLists();
                break;
            case 3:
                removeNote();
                break;
            case 4:
                showSummary();
                break;
            case 5:
                showNoteDescription();
                break;
            case 6:
                return true;
        }
        return false;
    }

    /**
     * show a list of files
     */
    private void showFileLists(){
        System.out.println("list of notes: ");
        fileManager.showCurrentFiles();

    }

    /**
     * add new note
     */
    private void addNewNote(){
        Scanner scan =new Scanner(System.in);
        System.out.println("enter your note name:");
        String name = scan.nextLine(),textLine;
        System.out.println("enter your note text and enter \"SAVE\" to finish process");
        ArrayList<String> notes = new ArrayList<>();
        while (!(textLine= scan.nextLine()).contains("SAVE")){
            notes.add(textLine);
        }
        try {
            fileManager.addNewNote(name,notes);

        }catch (Exception e){

        }

    }

    /**
     * show a summary of selected note
     */
    private void showSummary(){
        Scanner scan =new Scanner(System.in);
        System.out.println("enter the note name that want to see the summary of it :");
        String file = scan.nextLine();
        fileManager.showSummaryNote(file);
    }

    /**
     * remove a note
     */
    private void removeNote(){
        Scanner scan =new Scanner(System.in);
        System.out.println("enter the note name that want to remove it :");
        String file = scan.nextLine();
        fileManager.removeFile(file);
    }

    /**
     * show a whole of texts in selected file
     */
    private void showNoteDescription(){
        Scanner scan =new Scanner(System.in);
        System.out.println("enter the note name that want to see the detail of it :");
        String file = scan.nextLine();
        fileManager.showDetail(file);
    }
}
