package fa.training.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import fa.training.util.Constant;
import fa.training.util.Validator;
import fa.tranning.exception.IncorrectFormatException;

public class Player {
	private String fullName;  
    private String dateOfBirth;  
    private int squadNumber;  
    private String position;  
  
    public Player() {  
        super();  
    }  
  
    public Player(String fullName, String dateOfBirth, int squadNumber, String position){
        super();  
        this.fullName = fullName;  
        this.dateOfBirth = dateOfBirth;  
        this.squadNumber = squadNumber;  
        this.position = position;  
    }  
  
    public String getFullName() {  
        return fullName;  
    }  
  
    public void setFullName(String fullName) {  
        this.fullName = fullName;  
    }  
  
    public String getDateOfBirth() {  
        return dateOfBirth;  
    }  
  
     
    public void setDateOfBirth(String dateOfBirth) 
					throws ParseException, IncorrectFormatException {  
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyy");  
        try {  
            dateOfBirth = dateFormat.format(dateFormat.parse(dateOfBirth));  
            if (Validator.isDate(dateOfBirth)) {  
                this.dateOfBirth = dateOfBirth;  
            } else {  
                throw new IncorrectFormatException(Constant.INCORRECT_DATE_MASSAGE);  
            }  
        } catch (ParseException e) {  
            throw e;  
        }  
    }  
  
    public int getSquadNumber() {  
        return squadNumber;  
    }  
  
    public void setSquadNumber(String squadNumber) throws NumberFormatException {  
        this.squadNumber = Integer.parseInt(squadNumber);  
  
    }  
  
    public String getPosition() {  
        return position;  
    }  
  
    public void setPosition(String position) throws IncorrectFormatException {  
        if (Validator.isPosition(position)) {  
            this.position = position;  
        } else {  
            throw new IncorrectFormatException(Constant.INCORRECT_POSITION_MASSAGE);  
        }  
    }  
  
    @Override  
    public String toString() {  
        return "\n fullName:" + fullName + 	", dateOfBirth:"   	+ dateOfBirth +
		", squadNumber:" + squadNumber  +
		", position:" 	+ position;  
    }  

}
