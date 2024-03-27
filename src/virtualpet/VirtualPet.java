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
        }
        
        else {
            System.out.println("not welcome here!!! byebye!!"); 
            System.exit(0); 
        }
        
        // prints menu
        System.out.println("\n"); 
        System.out.println("menu: "); 
        System.out.println("1. start "); 
        System.out.println("2. instructions "); 
        System.out.println("3. exit "); 
        System.out.println("");
        
        // gets choice 
        System.out.print("enter choice: ");
        String choice = kb.next(); 
        kb.nextLine(); 
        
        choice = choice.toLowerCase(); 
        
        // part 2! 
        // switch case for their choice
        switch (choice){
            
                // if they choose to start 
                case ("1"): 
                case ("start"): 
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
                            System.exit(0); 
                            break; 
                    }
                    
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
                        int nameLength = r.nextInt(9); 
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
                    
                    
                    break; 
                
                // if they choose to read the instructions
                case ("2"): 
                case ("instructions"): 
                    System.out.println("\n\ninstructions: "); 
                    break; 
                    
                // if they choose to exit
                case ("3"): 
                case ("exit"): 
                    System.out.println("\n\nsee you next time!!");
                    System.exit(0);
                    break; 
                
                // all other inputs
                default: 
                    System.out.println("not an option, invalid input"); 
                    break; 
        }
        
        
    }
    
}
