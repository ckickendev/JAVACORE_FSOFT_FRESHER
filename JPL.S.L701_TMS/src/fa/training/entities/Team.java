package fa.training.entities;

import java.util.List;

public class Team {
	private String teamId;  
    private String teamName;  
    private String ground;  
    private List<Player> listOfPlayer;  

    public Team() {  
        super();  
    }  
  
    public Team(String teamId,String teamName, String ground, List<Player> listOfPlayer){
        super();  
        this.teamId = teamId;  
        this.teamName = teamName;  
        this.ground = ground;  
        this.listOfPlayer = listOfPlayer;  
    }  
   
    public String getTeamId() {  
        return teamId;  
    }  
  
    public void setTeamId(String teamId) {  
        this.teamId = teamId;  
    }  
  
 
    public String getTeamName() {  
        return teamName;  
    }  
   
    public void setTeamName(String teamName) {  
        this.teamName = teamName;  
    }  
    
    public String getGround() {  
        return ground;  
    }  
  
    public void setGround(String ground) {  
        this.ground = ground;  
    }  
   
    public List<Player> getListOfPlayer() {  
        return listOfPlayer;  
    }  
  
    public void setListOfPlayer(List<Player> listOfPlayer) {  
        this.listOfPlayer = listOfPlayer;  
    }  
  
    @Override  
    public String toString() {  
        return "teamId:" + teamId + ", teamName:" + teamName + 
		", ground:" + ground +"\n"+ ", listOfPlayer:"  + listOfPlayer;  
    }  

}
