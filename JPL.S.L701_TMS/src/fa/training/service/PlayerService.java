package fa.training.service;

import java.text.ParseException;
import java.util.Scanner;

import fa.training.entities.Player;
import fa.tranning.exception.IncorrectFormatException;

public class PlayerService {
	Player player = null;  
	    
    public Player inputPlayer(Scanner scanner) 
					throws ParseException, IncorrectFormatException {  
  
        player = new Player();  
        String fullName, dateOfBirth, position, squadNumber;  
        System.out.print("\nEnter full name: ");  
        fullName = scanner.nextLine();  
        player.setFullName(fullName);  
        System.out.print("\nEnter date of birth(dd/mm/yyyy): ");  
        dateOfBirth = scanner.nextLine();  
        player.setDateOfBirth(dateOfBirth);  
        System.out.print("\nEnter squad number: ");  
        squadNumber = scanner.nextLine();  
        player.setSquadNumber(squadNumber);  
        System.out.print("\nEnter position( GK|CB|WB|CM|CF):");  
        position = scanner.nextLine();  
        player.setPosition(position);  
        return player;  
    } 

}
