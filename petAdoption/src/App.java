import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


public class App{
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        ArrayList<Animal> animals = new ArrayList<Animal>();

        boolean switchFlag = false;
        int choice = 0;
        int menuMin = 1;
        int menuMax = 6; 

        do {

            System.out.println("Please choose an option\n" +
            "1: Input new animal(s)\n" +
            "2: View all animals\n" + 
            "3: Filter animals by type(Ex. Dog)\n" +
            "4: Filter animals by zip\n" +
            "5: Filter animals by zipcode and type\n" +
            "6: Exit");
            
            String intake = input.next();

            //This try catch will properly loop with the menu until the user inputs an int
            boolean catchFlag = true;
            do{            
                try {
                    choice = Integer.parseInt(intake);
                    if(choice >= menuMin && choice <= menuMax) {
                        catchFlag = false;
                    }
                    else {
                        System.out.println("Input is not valid.");
                        intake = input.nextLine();
                    }
                } catch(NumberFormatException e) {
                    System.out.println("Input is not valid.");
                }
            }while(catchFlag);


            switch(choice) {

                case 1: {
                    System.out.println("Please enter animal information in the format of: ID, Name, Type, Gender, ZipCode");
                    

                    BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

                    String[] s = bi.readLine().split(",");
                    while(s.length != 5) {
                        System.out.println("Not enough information or incorrect format. Try again:");
                        s = bi.readLine().split(",");
                    }
                    if(isLong(s[0].replaceAll("\\s+", "")) && isLong(s[4].replaceAll("\\s+", ""))){
                        Animal animal = new Animal(Long.parseLong(s[0].replaceAll("\\s+", "")), s[1].replaceAll("\\s+", ""),
                        s[2].replaceAll("\\s+", ""), s[3].replaceAll("\\s+", ""), Long.parseLong(s[4].replaceAll("\\s+", "")));
                        animals.add(animal);
                        break;
                    }
                    else {
                        System.out.println("Incorrect format, try again.");
                        s = bi.readLine().split(",");
                    }
                }

                case 2: {
                    for(Animal a : animals) {
                        System.out.println(a);
                    }
                    break;
                }

                case 3: {
                    BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

                    String s = bi.readLine();
                    for(Animal a : animals) {
                        if(a.getType().equals(s)) {
                            System.out.println(a);
                        }
                    }
                    break;

                }

                case 4: {

                    BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
                    int zip = 0;
                    String s = bi.readLine();
                    if(isLong(s)) {
                        zip = Integer.parseInt(s);
                    }
                    for(Animal a : animals) {
                        if(a.getZip() == zip) {
                            System.out.println(a);
                        }
                    }
                    break;
                }

                case 5: {
                    System.out.println("Please enter type of animal and zip code:");
                    
                    BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
                    int zip = -1;
                    String type = "";
                    String[] s = bi.readLine().split(",");
                    while(s.length != 2) {
                        System.out.println("Not enough information or incorrect format. Try again:");
                        s = bi.readLine().split(",");
                    }
                    if(isInt(s[1].replaceAll("\\s+", ""))) {
                        zip = Integer.parseInt(s[1].replaceAll("\\s+", ""));
                        type = s[0];
                    }
                    else {
                        System.out.println("Incorrect format, try again.");
                        s = bi.readLine().split(",");
                    }

                    for(Animal a : animals) {
                        if(a.getType().equals(type) && a.getZip() == zip) {
                            System.out.println(a);
                        }
                    }
                    break;
                }


                case 6: {
                    switchFlag = true;
                    return;
                }

                default: {
                    break;
                }

            }
        } while (!switchFlag && choice != 4);

        input.close();
    }



    //These were just added to clean up some of the code in the cases and make it more readable.
    public static boolean isLong(String str) {

        try {
            Long.parseLong(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInt(String str) {

        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
