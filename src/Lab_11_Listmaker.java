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
        int count = 12;

        do {
            displayList();
            //Get the user input for the option
            //Display the menu/options

            opt = SafeInput.getRegExString(pipe, menu, "[AaDdPpQq]" );
            opt = opt.toUpperCase();

            //Runs options

            switch (opt) {
                //adds to the list
                case "A":

                    data = SafeInput.getNonZeroLengthString(pipe, "Enter information here: ");
                    list.add(data);  // Always adds an item to the list
                    break;

                //removes items from the list
                case "D":
                    if(list.size() > 0)
                    {
                        int indexToDelete = SafeInput.getRangedInt(pipe, "Enter number", 0, list.size() - 1);
                        list.remove(indexToDelete);
                    }
                    else
                    {
                        System.out.println("List is empty, nothing to delete.");
                    }
                    break;
                //Prints the list
                case "P":
                    if (list.size() > 0) {
                        System.out.println("-------------------------------------------------------------------------------------");
                        for (int i = 0; i < list.size(); i++) {
                            System.out.printf("%3d%40s\n", i + 1, list.get(i));

                        }
                    } else {
                        System.out.println("---                               List is currently empty                         ---");
                        System.out.println("-------------------------------------------------------------------------------------");
                        break;
                    }
                    //Quits the program
                case "Q":
                    System.exit(0);
                    break;
            }
            System.out.println("Your option is " + opt);
        } while (!done);
    }


    private static void displayList()
    {
        System.out.println("-------------------------------------------------------------------------------------");
        if(list.size() != 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.printf("%3d%40s", i + 1, list.get(i));
            }
        }
        else
            System.out.println("---                               List is currently empty                         ---");
        System.out.println("-------------------------------------------------------------------------------------");
    }
}