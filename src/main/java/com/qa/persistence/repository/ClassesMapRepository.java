package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Classes;
import com.qa.util.JSONUtil;

@Alternative 
public class ClassesMapRepository implements ClassesRepository{
	
	private Map<Integer,Classes> classMap = new HashMap<Integer,Classes>();
	JSONUtil j1 = new JSONUtil();
	
	public Map<Integer, Classes> getclassMap(){
		return classMap;
	}
	public String createClass(String Classes) {
		Classes c1 = j1.getObjectForJSON(Classes, Classes.class);
		classMap.put(c1.getClassid(), c1);
			return "Class successfully created";	
		}
	
	public String getAllClasses() {
		return j1.getJSONForObject(classMap.values());
	}
	
	public String findClass(int classid) {
		return j1.getJSONForObject(classMap.get(classid));
	}
	
	
	public String updateClass(int classid, String Class) {
		Classes c2 = j1.getObjectForJSON(Class, Classes.class);

		if (classMap.containsKey(classid)) {
			classMap.replace(classid, c2);
			return "Class updated" + j1.getJSONForObject(classMap.get(classid));
		}

		return "Class failed to update";
	}
	
	public String deleteClass(int classid) {
		classMap.remove(classid);
		return "Class successfully deleted" + j1.getJSONForObject(classMap.get(classid));
	}

}
