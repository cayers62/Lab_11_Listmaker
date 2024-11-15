import java.util.ArrayList;
import java.util.Scanner;
public class Lab_11_Listmaker
{    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);
        final String menu = "A - Add, D - Delete, P - Print, Q - Quit";
        boolean done = false;
        String opt = "";
        String data = "";

        //initialize the list
        initializeList();


        //displays the list
        displayList();


        //Get the user input for the option
        //Display the menu/options

        do {

            opt = SafeInput.getRegExString(pipe, menu, "[AaDdPpQq]" );
            opt = opt.toUpperCase();

            //Runs options

            switch (opt)
            {

                //adds to the list
                case "A":

                    data = SafeInput.getNonZeroLengthString(pipe, "Enter information here" );
                    list.add(data);
                    displayList();
                    break;

                //removes items from the list
                case "D":
                    if(list.size() > 0)
                    {
                        int indexToDelete = SafeInput.getRangedInt(pipe, "Enter number you wish to be deleted",1, list.size() - 1);
                        list.remove(indexToDelete);
                        System.out.println("Item deleted successfully.");
                    }
                    else
                    {
                        System.out.println("List is empty, nothing to delete.");
                    }
                    break;
                //Prints the list
                case "P":
                   displayList();
                   break;
                    //Quits the program
                case "Q":
                    done = true;
                    break;
            }
            if(!done)
            {
                System.out.println("Your option is " + opt);
            }
        } while (!done);
    }


    private static void displayList()
    {
        System.out.println("-------------------------------------------------------------------------------------");
        if(list.size() != 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.printf("\n%3d%40s", i + 1, list.get(i));

            }
            System.out.println();
        }
        else
            System.out.println("---                               List is currently empty                         ---");
        System.out.println("-------------------------------------------------------------------------------------");
    }
    // Initialize the list with default values
    private static void initializeList() {
        list.add("Curtis Ayers");
        list.add("Amber Vinson");
        list.add("Pam Wheeler");
        list.add("Kelsey Dewitt");
        list.add("David Rohe");

    }
}