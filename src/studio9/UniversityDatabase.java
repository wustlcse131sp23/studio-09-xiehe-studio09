package studio9;

import assignment7.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UniversityDatabase {
	private Map<String, Student> data;
	//TODO: Complete this class according to the studio instructions
	public UniversityDatabase(){
		data = new HashMap<String, Student>();
	}

	public void addStudent(String accountName, Student student) {
		data.put(accountName, student);
	}

	public int getStudentCount() {
		// TODO
		return data.size();
	}

	public String lookupFullName(String accountName) {
		// TODO: Complete according to studio instructions
		if(data.get(accountName)!=null) {
		 return data.get(accountName).getFullName();
		}
		else {
			return null;
		}
	}

	public double getTotalBearBucks() {
		double bucks = 0.0;
		for(Entry<String, Student> i : data.entrySet()) {
			Student cur = i.getValue();
			bucks += cur.getBearBucksBalance();
		}
		return bucks;
	}
}
