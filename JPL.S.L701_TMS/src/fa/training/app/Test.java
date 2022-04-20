package fa.training.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Team;
import fa.training.service.TeamService;

public class Test {
	public static List<Team> teams = new ArrayList<>();  
    static TeamService teamService = new TeamService();  
    static Scanner scanner = new Scanner(System.in);  
  
    public static void main(String[] args) {  
        Team team = null;  
        String key = "3";  
        Loop: do {  
            showMenu();  
            key = scanner.nextLine();  
            switch (key) {  
            case "1":  
                try {  
                    team = teamService.createNewTeam(scanner);  
                    teams.add(team);  
                    System.out.println("Create team success!");  
                    continue Loop;  
                } catch (Exception e) {  
                    System.err.println("Create team fail!");  
                    break Loop;  
                }  
            case "2":  
                teamService.displayTeam(teams);  
                break;  
            default:  
                break Loop;  
              }  
        } while (true);  
    }  
  
    public static void showMenu() {  
        System.out.println(">> Menu");  
        System.out.println("1. Create new team");  
        System.out.println("2. Display list of team");  
        System.out.println("3. Exit");  
        System.out.print(">> Enter your choice: ");  
    } 

}
