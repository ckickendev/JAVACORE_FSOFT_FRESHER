package JPL.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JPL.java.entities.Candidate;
import JPL.java.entities.Experience;
import JPL.java.entities.Fresher;
import JPL.java.entities.Intern;
import JPL.java.log4j.LogFile;
import JPL.java.util.DBUtils;

public class CandidateDaoImpl implements CandidateDAO {
	List<Candidate> candidates = new ArrayList<>();
	Connection connection;
	PreparedStatement preparedStatement = null;
	ResultSet results = null;
	LogFile logFile = new LogFile();

	public void getAllFullName() throws SQLException {
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("select * from candidate");
			results = preparedStatement.executeQuery();
			StringBuffer fullname = new StringBuffer();
			logFile.printInfo(preparedStatement.toString());
			while (results.next()) {
				fullname.append(results.getString(2)).append(",");
			}
			if (fullname.length() == 0) {
				System.out.println("No name found");
			} else {
				System.out.println(fullname.deleteCharAt(fullname.length() - 1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int countCandidate() throws SQLException {
		int count = 0;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("select count(candidateID) from candidate");
			results = preparedStatement.executeQuery();
			logFile.printInfo(preparedStatement.toString());
			while (results.next()) {
				count = results.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}


	public void update(Candidate candidate) {
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("update Candidate set fullName = ?, birthDay = ?, phone=?, email=?, candidate_type=? where candidateId=?");
			preparedStatement.setString(1, candidate.getFullName());
			preparedStatement.setString(2, candidate.getBirthDay());
			preparedStatement.setString(3, candidate.getPhone());
			preparedStatement.setString(4, candidate.getEmail());
			preparedStatement.setInt(5, candidate.getCandidate_Type());
			preparedStatement.setString(6, candidate.getCandidateID());
			preparedStatement.executeUpdate();
			logFile.printInfo(preparedStatement.toString());
			if(candidate instanceof Experience) {
				Experience ex = (Experience) candidate;
				PreparedStatement pre1 = connection.prepareStatement("update Experience set ExpInYear =?, ProSkill = ? where CandidateId = ?");
				pre1.setInt(1, ex.getExpInYear());
				pre1.setString(2, ex.getProSkill());
				pre1.setString(3, ex.getCandidateID());
				pre1.executeUpdate();
				logFile.printInfo(preparedStatement.toString());
			}else if(candidate instanceof Fresher) {
				Fresher fr = (Fresher) candidate;
				PreparedStatement pre2 = connection.prepareStatement("update Fresher set Graduation_date =?, Graduation_rank = ?, Education =?  where CandidateId = ?");
				pre2.setString(1, fr.getBirthDay());
				pre2.setString(2, fr.getGraduation_rank());
				pre2.setString(3, fr.getEducation());
				pre2.setString(4, fr.getCandidateID());
				pre2.executeUpdate();
				logFile.printInfo(preparedStatement.toString());
			}else if(candidate instanceof Intern) {
				Intern in = (Intern) candidate;
				PreparedStatement pre3 = connection.prepareStatement("update Intern set Majors =?, Semester = ?, University_name =?  where CandidateId = ?");
				pre3.setString(1, in.getMajors());
				pre3.setString(2, in.getSemester());
				pre3.setString(3, in.getUniversity_name());
				pre3.setString(4, in.getCandidateID());
				pre3.executeUpdate();	
				logFile.printInfo(preparedStatement.toString());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Candidate getInfo(String id) throws SQLException {
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("select * from Candidate where candidateID = ?");
			preparedStatement.setString(1, id);
			results = preparedStatement.executeQuery();
			logFile.printInfo(preparedStatement.toString());
			while (results.next()) {
				if (results.getInt(6) == 1) {
					return getExperience(results);
				} else if (results.getInt(6) == 2) {
					return getFresher(results);
				} else if (results.getInt(6) == 3) {
					return getIntern(results);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Experience getExperience(ResultSet rs) {
		Experience result = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("select * from Experience where CandidateId = ?");
			preparedStatement.setString(1, rs.getString(1));
			results = preparedStatement.executeQuery();
			logFile.printInfo(preparedStatement.toString());
			if (results.next()) {
				result = new Experience(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), results.getInt(3), results.getString(4));
			} else {
				System.out.println("No found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Fresher getFresher(ResultSet rs) {
		Fresher result = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("select * from Fresher where CandidateId = ?");
			preparedStatement.setString(1, rs.getString(1));
			results = preparedStatement.executeQuery();
			logFile.printInfo(preparedStatement.toString());
			if (results.next()) {
				result = new Fresher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), results.getString(2), results.getString(3),
						results.getString(4));
//					ex.showInfo();
			} else {
				System.out.println("Not infor to fresher");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Intern getIntern(ResultSet rs) {
		Intern result = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("select * from Intern where CandidateId = ?");
			preparedStatement.setString(1, rs.getString(1));
			results = preparedStatement.executeQuery();
			logFile.printInfo(preparedStatement.toString());
			if (results.next()) {
				result = new Intern(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), results.getString(2), results.getString(3), results.getString(4));
//					ex.showInfo();
			} else {
//				System.out.println("Not infor to experience");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void save(Candidate candidate) {
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(
					"insert into Candidate(candidateId, fullName, birthDay, phone, email, candidate_type) values(?, ?, ?,?,?,?)");
			preparedStatement.setString(1, candidate.getCandidateID());
			preparedStatement.setString(2, candidate.getFullName());
			preparedStatement.setString(3, candidate.getBirthDay());
			preparedStatement.setString(4, candidate.getPhone());
			preparedStatement.setString(5, candidate.getEmail());
			preparedStatement.setInt(6, candidate.getCandidate_Type());
			preparedStatement.execute();
			logFile.printInfo(preparedStatement.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveExperience(Experience ex) {
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection
					.prepareStatement("insert into Experience(CandidateId, ExpInYear, ProSkill) values(?, ?, ?)");
			preparedStatement.setString(1, ex.getCandidateID());
			preparedStatement.setInt(2, ex.getExpInYear());
			preparedStatement.setString(3, ex.getProSkill());
			preparedStatement.execute();
			logFile.printInfo(preparedStatement.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveFresher(Fresher fs) {
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(
					"insert into Fresher(CandidateId, Graduation_date, Graduation_rank, education) values(?, ?, ?, ?)");
			preparedStatement.setString(1, fs.getCandidateID());
			preparedStatement.setString(2, fs.getGraduation_date());
			preparedStatement.setString(3, fs.getGraduation_rank());
			preparedStatement.setString(4, fs.getEducation());
			preparedStatement.execute();
			logFile.printInfo(preparedStatement.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveIntern(Intern in) {
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(
					"insert into Intern(CandidateId, Majors, Semester, University_name) values(?, ?, ?, ?)");
			preparedStatement.setString(1, in.getCandidateID());
			preparedStatement.setString(2, in.getMajors());
			preparedStatement.setString(3, in.getSemester());
			preparedStatement.setString(4, in.getUniversity_name());
			System.out.println(preparedStatement);
			preparedStatement.execute();
			logFile.printInfo(preparedStatement.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Candidate> getAllCandidate() {
		List<String> listId = new ArrayList<>();
		List<Candidate> candidates = new ArrayList<>();
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("select * from Candidate");
			results = preparedStatement.executeQuery();
			logFile.printInfo(preparedStatement.toString());
			while (results.next()) {
				listId.add(results.getString(1));
			}
			for (String x : listId) {
				candidates.add(getInfo(x));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return candidates;
	}

	public static void main(String[] args) throws SQLException {
		Connection con = DBUtils.getInstance().getConnection();
		System.out.println(con);
	}

	@Override
	public List<Candidate> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveCandidate(Candidate candidate) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Candidate findCandidatebyId(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
