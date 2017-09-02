import java.util.*;
import static java.lang.System.exit;

/**
 * Created by Reid on 2/7/2017.
 * HW2 Names and Numbers [PROG-1403]
 * NamesAndNumbers.java - A program for calculating manipulating phone directory listings.
 * @author: Reid Nolan
 * @since: 02/07/2017
 * @version: 1.0
 */

/**Allows storage and manipulation of stored data for the purpose of maintaining phone records*/
public class NamesAndNumbers
{
    /**main method*/
    public static void main(String[] args)
    {
        //declare and initialize variable for while loop
        boolean inputGood = false;
        //create a hashMap
        TreeMap<String, String> treeMap = new TreeMap<>();

        //add entries to treeMap
        treeMap.put("Bill Gates", "(111) 222-3333");
        treeMap.put("Larry Ellison", "(444) 555-6666");
        treeMap.put("Steve Jobs", "777-888-9999");

        //create new scanner
        Scanner input = new Scanner(System.in);

        //loop for perpetual iteration (program termination available in switch below)
        while (!inputGood)
        {
            //display main menu
            System.out.println("Names and Numbers");
            System.out.println("1 - List entries");
            System.out.println("2 - Add entry");
            System.out.println("3 - Delete entry");
            System.out.println("4 - Exit");
            System.out.print("\n" + "Enter Menu Number: ");

            try
            {
                //variable declaration for main menu selection
                int number = input.nextInt();
                //switch for main menu selection
                switch (number)
                {
                    case 1:
                        //display entries in list
                        listEntries(treeMap);
                        break;
                    case 2:
                       //allow for adding list entry
                        addEntry(treeMap);
                        break;
                    case 3:
                        //allow for deletion of list entry
                        deleteEntry(treeMap);
                        break;
                    case 4:
                        //allow for program termination
                        System.out.println("exiting program...");
                        exit(1);
                        break;
                    default:
                        //display error message on invalid selection
                        System.out.println("Input error! Try again." + "\n");
                }
            }
            //exception handler for input failure
            catch (InputMismatchException IOE)
            {
                //display warning and clear input stream
                System.out.println("Input error! Try again." + "\n");
                input.reset();
                input.next();
            }
        }
    }

    /**Displays treeMap keys and values in tabular format*/
    private static void listEntries(Map<String, String> treeMap)
    {
        //display tabular header
        System.out.println("Name\t\t\t\tPhone");
        System.out.println("------------------\t------------------");
        //iterate through key-value pairs and display
        for (Map.Entry entry : treeMap.entrySet())
        {
            System.out.print(String.format("%-20s", entry.getKey()));
            System.out.print(String.format("%-14s", entry.getValue()));
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    /**Allows for entry of new key-value into treeMap*/
    private static void addEntry(Map<String, String> treeMap)
    {
        //create new scanner
        Scanner input = new Scanner(System.in);
        //prompt user for input
        System.out.print("Enter name: ");
        //store input to local variable
        String name = input.nextLine();
        //validate input
        if (name.length() == 0)
        {
            //display error message on empty input and retry
            System.out.println("Error! No name was entered." + "\n");
        }
        else
        {
            //prompt user for input
            System.out.print("Enter phone number: ");
            //store input to local variable
            String number = input.nextLine();
            //validate input
            if (number.length() == 0)
            {
                //display error message on empty input
                System.out.println("Error! No number was entered." + "\n");
            }
            else
            {
                //add name and number to treeMap
                treeMap.put(name, number);
                //confirm key-value saved
                System.out.printf("The entry of %s has been saved.%n%n", name);
            }
        }
    }

    /**Allows for deletion of existing key-value into treeMap*/
    private static void deleteEntry(Map<String, String> treeMap)
    {
        //create new scanner
        Scanner input = new Scanner(System.in);
        //prompt user for input
        System.out.print("Enter name to delete: ");
        //store input to local variable
        String name = input.nextLine();
        //validate input
        if (name.length() == 0)
        {
            //display error message on empty input and retry
            System.out.println("Error! No name was entered." + "\n");
        }
        else
        {
            //verify key is present
            if (treeMap.containsKey(name))
            {
                //remove key matching string input by user
                treeMap.remove(name);
                //confirm key-value deletion
                System.out.printf("The entry matching %s has been deleted.%n%n", name);
            }
            else
            {
                //display error on no key matching string input by user
                System.out.printf("The entry matching %s is not present.%n%n", name);
            }
        }
    }
}