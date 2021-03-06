package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Instructors;
import com.qa.util.JSONUtil;

@Alternative
public class InstructorMapRepository implements InstructorRepository{

		private Map<Integer,Instructors> instructorsMap = new HashMap<>();
		JSONUtil j1 = new JSONUtil();
		
		public Map<Integer, Instructors> getinstructorsMap(){
			return instructorsMap;
		}
		public String createInstructor(String instructors) {
			Instructors i1 = j1.getObjectForJSON(instructors, Instructors.class);
			instructorsMap.put(i1.getInstructorid(), i1);
				return "Instructor successfully created";	
			}
		
		public String getAllInstructors() {
			return j1.getJSONForObject(instructorsMap.values());
		}
		
		public String findInstructor(int instructorid) {
			return j1.getJSONForObject(instructorsMap.get(instructorid));
		}
		
		
		public String updateInstructor(int instructorid, String instructors) {
		 Instructors i2 = j1.getObjectForJSON(instructors, Instructors.class);

			if (instructorsMap.containsKey(instructorid)) {
				instructorsMap.replace(instructorid, i2);
				return "Instructor updated" + j1.getJSONForObject(instructorsMap.get(instructorid));
			}

			return "Instructor failed to update";
		}
		
		public String deleteInstructor(int instructorid) {
			instructorsMap.remove(instructorid);
			return "Instructor successfully deleted" + j1.getJSONForObject(instructorsMap.get(instructorid));
		}
	}

