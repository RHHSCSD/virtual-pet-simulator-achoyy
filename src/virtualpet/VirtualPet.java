/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package virtualpet;
import java.util.*;
/**
 *
 * @author michael.roy-diclemen
 */
public class VirtualPet {

    /**
     * @param args the command line arguments
     */
    public static int numberGuessingGame(int coins) 
    { 
        Random r = new Random(); 
        final int number = r.nextInt(100) + 1; 
        int guessedNumber = -1; 
        Scanner s = new Scanner(System.in); 
        boolean RUNNING = true; 
        int tries = 0; 
        int earnedCoins = 0; 

        while (RUNNING) 
        { 
            System.out.print("enter your guess: "); 
            guessedNumber = s.nextInt(); 
            
            while (guessedNumber > 100 || guessedNumber < 0) 
            { 
                System.out.print("enter your guess: "); 
                guessedNumber = s.nextInt(); 
            }

            tries += 1; 

            if (guessedNumber == number) 
            { 
                RUNNING = false; 
                earnedCoins = 500; 
                System.out.println("you have won the game!"); 
            }

            else if (guessedNumber < number) 
            { 
                System.out.println("too low...."); 
            }

            else 
            { 
                System.out.println("too high...."); 
            }

            if (tries == 5) 
            { 
                RUNNING = false; 
                System.out.println("the number was " + number); 
            }

        }

        earnedCoins += 500 - (tries * 100); 
        System.out.println("you earned " + earnedCoins + " coins."); 

        coins += earnedCoins; 

        return coins; 
    }
    
    public static String scrambler(String initialLetters) 
    { 
        String scrambledLetters = ""; 
        Random r = new Random(); 
        int randomPos = 0; 
        String reference = ""; 

        while (initialLetters.length() > 0) 
        { 
            randomPos = r.nextInt(initialLetters.length()); 
            scrambledLetters += initialLetters.charAt(randomPos); 

            for (int i = 0; i < initialLetters.length(); i++) 
            { 
                if (i != randomPos) 
                    reference += initialLetters.charAt(i); 

                else 
                    continue; 
            }
            initialLetters = reference; 
            reference = ""; 
        }
        return scrambledLetters; 
    }

    public static int letterMatchingGame(int coins) 
    { 
        String correctLetters = scrambler("aabbccddee"); 

        Scanner s = new Scanner(System.in); 
        boolean GUESSING = true; 
        int position1; 
        int position2; 
        String displayedString = "##########"; 
        String displayedStringReference = ""; 
        int earnedCoins = 0; 
        int attempts = 0; 

        while (GUESSING) 
        { 
            System.out.print("enter your first guess: "); 
            position1 = s.nextInt(); 
            s.nextLine(); 
            System.out.print("enter your second guess: "); 
            position2 = s.nextInt(); 
            s.nextLine(); 
            
            if (position1 >= 0 && position1 <= correctLetters.length()-1 && position2 >= 0 && position2 <= correctLetters.length()-1) 
            { 
                attempts += 1; 
                for (int i = 0; i <= correctLetters.length()-1; i++)
                { 
                    if (i == position1) 
                        displayedStringReference += correctLetters.charAt(i); 
                    else if (i == position2) 
                        displayedStringReference += correctLetters.charAt(i); 
                    else 
                        displayedStringReference += displayedString.charAt(i); 
                }

                System.out.println(displayedStringReference + "\n"); 

                if (correctLetters.charAt(position1) == correctLetters.charAt(position2)) 
                { 
                    System.out.println("it's a match!"); 
                    displayedString = displayedStringReference; 
                    earnedCoins += 100; 
                    
                }
                else 
                { 
                    System.out.println("does not match :("); 
                }
                displayedStringReference = ""; 
            }

            else 
            { 
                System.out.println("invalid input, try again"); 
            }

            if (attempts >= 5) 
            { 
                GUESSING = false; 
            }

        }

        System.out.println("you have earned " + earnedCoins + " coins. "); 
        System.out.println("the hidden string was " + correctLetters); 
        coins += earnedCoins; 

        return coins; 
    }
    
    public static void main(String[] args) {
        
        // part 1! 
        // set up scanner & random 
        Scanner kb = new Scanner(System.in); 
        Random r = new Random(); 
        
        // welcome screen 
        System.out.println("\n\n\\( ^. .^)"); 
        System.out.println("\nabigotchi");
        
        // part 3! login time baby!! 
        final String USER = "snoopy"; 
        final String PASSWORD = "toto"; 
        
        for (int i = 0; i < 3; i++) {
            System.out.print("\n\nname: "); 
            String name = kb.next(); 
            kb.nextLine(); 
            System.out.print("password: "); 
            String pass = kb.next(); 
            kb.nextLine(); 

            name = name.toLowerCase(); 
            pass = pass.toLowerCase(); 

            if ((name.equals(USER)) && (pass.equals(PASSWORD))) 
            {
                System.out.println("welcome to abigotchi, " + name); 
                i = 20; 
            }

            else if (i != 2) 
            {
                System.out.println("try again!!!"); 
            }
            
            else 
            { 
                System.out.println("not welcome here!!! byebye!!"); 
                System.exit(0); 
            }
        } 
        
        String option1 = "1. start "; 
        String choice = "0"; 
        Boolean running = true; 
        
        int coins = 100; 
        
        while (running) 
        { 
            // prints menu 
            System.out.println("\n"); 
            System.out.println("menu: "); 
            System.out.println(option1); 
            System.out.println("2. instructions "); 
            System.out.println("3. exit "); 
            System.out.println("");

            // gets choice 
            System.out.print("enter choice: ");
            choice = kb.next(); 
            kb.nextLine(); 

            choice = choice.toLowerCase(); 
        
            // part 2! 
            // switch case for their choice
            switch (choice){
                    // if they choose to start 
                    case ("1"): 
                    case ("start"): 
                    case ("play"): 
                    case ("interact"): 
                    case ("play/interact"): 
                        if (option1 == "1. start ") { 
                            option1 = "1. play/interact"; 
                            System.out.println("\n\npets: "); 
                            System.out.println("1. duck "); 
                            System.out.println("2. cat "); 
                            System.out.println("3. frog "); 

                            // gets input
                            System.out.print("\nenter your choice: "); 
                            String pet = kb.next(); 
                            kb.nextLine(); 

                            pet = pet.toLowerCase(); 

                            switch (pet) {

                                // if they chose the duck 
                                case ("1"): 
                                case ("duck"): 
                                    System.out.println("duck has been selected!");
                                    break; 

                                // if they chose the cat 
                                case ("2"): 
                                case ("cat"): 
                                    System.out.println("cat has been selected!");
                                    break; 

                                // if they chose the frog
                                case ("3"): 
                                case ("frog"): 
                                    System.out.println("frog has been selected!");
                                    break; 

                                // other inputs 
                                default: 
                                    System.out.println("not an option, invalid input"); 
                                    pet = "-1"; 
                                    break; 
                            }

                            if (pet != "-1") 
                            { 
                                                        // pet naming menu 
                                System.out.println("\n\nit's time to name your pet! \n"); 
                                System.out.println("would you like to... "); 
                                System.out.println("1. enter a name yourself"); 
                                System.out.println("2. randomly generate a name for your pet"); 

                                // reads the choice 
                                System.out.print("\nenter your choice (just the number please): "); 
                                int naming = kb.nextInt(); 
                                kb.nextLine(); 

                                if (naming == 1) 
                                { 
                                    // lets user enter a name 
                                    System.out.print("\n\nenter your pet's name: "); 
                                    String petName = kb.next(); 
                                    kb.nextLine(); 
                                    System.out.println("\nyour pet is named " + petName); 
                                }

                                else if (naming == 2) 
                                { 
                                    // generates a name 
                                    int nameLength = r.nextInt(5) + 4; 
                                    int vowelCheck = 0; 
                                    int letterIndex; 
                                    char letter; 
                                    int doubleletter = 0; 
                                    String randomPetName = ""; 

                                    String vowels = "aeiou"; 
                                    String consonants = "bcdfghjklmnpqrstvwxyz"; 

                                    for (int i = 0; i < nameLength; i++) 
                                    { 
                                        if (vowelCheck == 1)
                                        { 
                                            vowelCheck = 0; 
                                            letterIndex = r.nextInt(5); 
                                            letter = vowels.charAt(letterIndex); 

                                            randomPetName += letter; 

                                            doubleletter = r.nextInt(5); 

                                            if (doubleletter == 4) 
                                            { 
                                                randomPetName += letter; 
                                                i += 1; 
                                            }
                                        }

                                        else 
                                        { 
                                            vowelCheck = 1; 
                                            letterIndex = r.nextInt(21); 
                                            letter = consonants.charAt(letterIndex); 

                                            randomPetName += letter; 
                                        }
                                    }
                                    System.out.println("your pet is named " + randomPetName); 
                                }
                                else { 
                                    System.out.println("not an option. sending you back to the menu! \n"); 
                                }
                            }
                        } 
                        
                        else 
                        { 
                            System.out.println("you currently have " + coins + " coins\n\n"); 
                            
                            System.out.println("game menu"); 
                            System.out.println("1. number guessing game"); 
                            System.out.println("2. letter matching game"); 
                            
                            System.out.println("\nenter your choice: "); 
                            choice = kb.next(); 
                            kb.nextLine(); 
                            choice = choice.toLowerCase(); 
                            
                            System.out.print("\n\n\n"); 
                            switch (choice) 
                            { 
                                case "1": 
                                case "number guessing game": 
                                   coins = numberGuessingGame(coins); 
                                   System.out.println("you have " + coins + " coins"); 
                                   break; 
                                   
                                case "2": 
                                case "letter matching game": 
                                    coins = letterMatchingGame(coins); 
                                    System.out.println("you have " + coins + " coins"); 
                                    break; 
                                    
                                default: 
                                    System.out.println("invalid input... sending you back to the main menu..."); 
                            }
                        }
                        break; 
                        
                    // if they choose to read the instructions
                    case ("2"): 
                    case ("instructions"): 
                        System.out.println("\n\ninstructions: "); 
                        break; 
                        
                    case ("3"): 
                    case ("exit"): 
                        running = false; 
                        break; 
                        
                        
                    // all other inputs
                    default: 
                        System.out.println("not an option, invalid input"); 
                        break; 
            }
        }
        System.out.println("\n\nsee you next time!!");
        System.exit(0);
    }
}
