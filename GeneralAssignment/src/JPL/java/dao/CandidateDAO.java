package JPL.java.dao;

import java.sql.SQLException;
import java.util.List;

import JPL.java.entities.Candidate;

public interface CandidateDAO {
	List<Candidate> getAll() throws SQLException;

	boolean saveCandidate(Candidate candidate) throws SQLException;

	Candidate findCandidatebyId(String id) throws SQLException;

}
