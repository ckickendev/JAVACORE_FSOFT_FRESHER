package JPL.java.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import JPL.java.dao.CandidateDaoImpl;
import JPL.java.entities.Candidate;
import JPL.java.entities.Experience;
import JPL.java.entities.Fresher;
import JPL.java.entities.Intern;
import JPL.java.exception.BirthdayException;
import JPL.java.exception.EmailException;
import JPL.java.exception.InputException;
import JPL.java.util.DBUtils;
import JPL.java.util.Validator;

public class CandidateService {
	private static CandidateDaoImpl canDAO = new CandidateDaoImpl();
	private static Validator validator = new Validator();


	public static void main(String[] args) throws BirthdayException, EmailException, SQLException, InputException {
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			getMenu();
			System.out.print("Enter your choice: ");
			choice = validator.checkInputIntLimit(1, 7);
			switch (choice) {
				case 1: {
					createNewCandidate();
					break;
				}
				case 2: {
					showAll();
					break;
				}
				case 3: {
					update();
					break;
				}
			}
		} while (choice != 4);
	}

	public static void getMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1. Create new candidate");
		System.out.println("2. Show all candidate");
		System.out.println("3. Update candidate");
		System.out.println("4. Exit");
	}

	public static void createNewCandidate() throws BirthdayException, EmailException, SQLException, InputException {
		System.out.println("====Create new candidate====");
		Candidate candidate = new Candidate();
		System.out.print("Enter candidate id: ");
		String id = validator.checkInputString();
		candidate.setCandidateID(id);
		System.out.print("Enter fullname: ");
		String fullname = validator.checkInputString();
		candidate.setFullName(fullname);
		
		
		int isCheck = 0;
		do {
			try {
				System.out.print("Enter birthday: ");
				String birthday = validator.checkInputString();
				candidate.setBirthDay(birthday);
			}catch (Exception e) {
				isCheck = 1;
			}
		}while(isCheck == 1);
	

		System.out.print("Enter phone: ");
		String phone = validator.checkInputString();
		candidate.setPhone(phone);

		System.out.print("Enter email: ");
		String email = validator.checkInputString();
		candidate.setEmail(email);

		System.out.println("Enter candidate type: 1-Experience, 2-Fresher, 3-Intern: ");
		int type = validator.checkInputIntLimit(1, 3);
		
		candidate.setCandidate_Type(type);
		switch (type) {
			case 1: {
				System.out.print("Enter year of experience: ");
				int year = validator.checkInputTypeInt();
				System.out.print("Enter proskill: ");
				String ps = validator.checkInputString();
				Experience ex = new Experience(candidate.getCandidateID(), candidate.getFullName(), candidate.getBirthDay(), candidate.getPhone(), candidate.getEmail(), candidate.getCandidate_Type(), year , ps);
				canDAO.save(candidate);
				canDAO.saveExperience(ex);
				break;
			}
			case 2: {
				System.out.print("Enter graduation date: ");
				String day = validator.checkInputString();
				System.out.print("Enter graduation rank: ");
				String rank = validator.checkInputString();
				System.out.print("Enter education: ");
				String edu = validator.checkInputString();
				Fresher fr = new Fresher(candidate.getCandidateID(), candidate.getFullName(), candidate.getBirthDay(), candidate.getPhone(), candidate.getEmail(), candidate.getCandidate_Type(), day, rank, edu);
				canDAO.save(candidate);
				canDAO.saveFresher(fr);
				break;
			}
			case 3: {
				System.out.print("Enter major: ");
				String major = validator.checkInputString();
				System.out.print("Enter semester: ");
				String semester = validator.checkInputString();
				System.out.print("Enter university name: ");
				String uname = validator.checkInputString();
				Intern intern = new Intern(candidate.getCandidateID(), candidate.getFullName(), candidate.getBirthDay(), candidate.getPhone(), candidate.getEmail(), candidate.getCandidate_Type(), major, semester, uname);
				canDAO.save(candidate);
				canDAO.saveIntern(intern);
				break;
			}
		}
		System.out.println("You have enter "+ Candidate.getCanidate_count() + " candidate");
	}
	
	public static void showAll() {
		List<Candidate> cans = canDAO.getAllCandidate();
		Map<String, Candidate> candidateMap = new HashMap<String, Candidate>();
		List<Candidate> candidates = new ArrayList<>();
		
		
		for(Candidate x: cans) {
			candidateMap.put(x.getCandidateID(), x);
		}
		
		Set<String> set = candidateMap.keySet();
        for (String key : set) {
            candidates.add(candidateMap.get(key));
        }
//        for (Candidate candidate : candidates) {
//            candidate.showInfo();
//        }
        
        System.out.println("=================List candidate==================");
        
        Collections.sort(candidates);
        for (Candidate candidate : candidates) {
            candidate.showInfo();
        }
	}

	public static void update() throws SQLException, BirthdayException, EmailException, InputException {
		System.out.println("==Update==");
		Candidate candidateUpdate = null;
		do {
			System.out.println("Enter candidate id you want to update: ");
			String idUpdate = validator.checkInputString();
			candidateUpdate = canDAO.getInfo(idUpdate);
			if(candidateUpdate == null){
				System.out.println("Candidate not exist! please enter again!");
				continue;
			}else{
				System.out.println("Candidate find!");
				System.out.print("Enter fullname: ");
				String fullname = validator.checkInputString();
				candidateUpdate.setFullName(fullname);

				System.out.print("Enter birthday: ");
				String birthday = validator.checkInputString();
				candidateUpdate.setBirthDay(birthday);

				System.out.print("Enter phone: ");
				String phone = validator.checkInputString();
				candidateUpdate.setPhone(phone);

				System.out.print("Enter email: ");
				String email = validator.checkInputString();
				candidateUpdate.setEmail(email);

				System.out.print("Enter candidate type: 1-Experience, 2-Fresher, 3-Intern: ");
				int type = validator.checkInputIntLimit(1, 3);
				switch (type) {
					case 1: {
						System.out.print("Enter year of experience: ");
						int year = validator.checkInputTypeInt();
						System.out.print("Enter proskill: ");
						String ps = validator.checkInputString();
						Experience ex = new Experience(candidateUpdate.getCandidateID(), candidateUpdate.getFullName(), candidateUpdate.getBirthDay(), candidateUpdate.getPhone(), candidateUpdate.getEmail(), candidateUpdate.getCandidate_Type(), year , ps);
						canDAO.update(ex);
						System.out.println("Success!");
						break;
					}
					case 2: {
						System.out.print("Enter graduation date: ");
						String day = validator.checkInputString();
						System.out.print("Enter graduation rank: ");
						String rank = validator.checkInputString();
						System.out.print("Enter education: ");
						String edu = validator.checkInputString();
						Fresher fr = new Fresher(candidateUpdate.getCandidateID(), candidateUpdate.getFullName(), candidateUpdate.getBirthDay(), candidateUpdate.getPhone(), candidateUpdate.getEmail(), candidateUpdate.getCandidate_Type(), day, rank, edu);
						canDAO.update(fr);
						System.out.println("Success!");
						break;
					}
					case 3: {
						System.out.print("Enter major: ");
						String major = validator.checkInputString();
						System.out.print("Enter semester: ");
						String semester = validator.checkInputString();
						System.out.print("Enter university name: ");
						String uname = validator.checkInputString();
						Intern intern = new Intern(candidateUpdate.getCandidateID(), candidateUpdate.getFullName(), candidateUpdate.getBirthDay(), candidateUpdate.getPhone(), candidateUpdate.getEmail(), candidateUpdate.getCandidate_Type(), major, semester, uname);
						canDAO.update(intern);
						System.out.println("Success!");
						break;
					}
				}
			}
		}while(candidateUpdate == null);
		
	}
}
