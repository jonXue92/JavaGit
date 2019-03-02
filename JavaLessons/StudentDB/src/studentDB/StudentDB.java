package studentDB;

import java.util.Map;
import java.util.HashMap;

public class StudentDB {
    
    private Map<Integer,String> courseList = new HashMap<>();
    private Map<String,HashMap<String,Integer>> studentList = new HashMap<>();
    //Prototype: studentList<studenName,scoreList<courseName,score>>
     
    public void insertStudent (String newName) {
        HashMap<String,Integer> defaultData = new HashMap<>();
        studentList.put(newName, defaultData);
    }
     
    public void insertScore (String name, int courseId, int score) {
        String course = courseList.get(courseId);
        studentList.get(name).put(course, score);
    }
     
    public void addCourse (int courseId, String newCourse) {
        courseList.put(courseId, newCourse);
    }
     
    public Map<String, Integer> listScoreByStudent (String name) {
    	Map<String, Integer> res = studentList.get(name);
        return res;
    }
    
    public Map<String, Integer> listScoreByCourse (String course) {
    	Map<String, Integer> res = new HashMap<>();
    	for (String name: studentList.keySet()) {
    		if (studentList.get(name).containsKey(course)) {
    			res.put(name, studentList.get(name).get(course));
    		}
    	}
    	return res;
    }
    public static void main ( String [] args ) {
        StudentDB database = new StudentDB();
        database.insertStudent("ZhangSan");
        database.insertStudent("LiSi");
        database.insertStudent("WangWu");
        database.addCourse(666,"论装逼技巧");
        database.addCourse(233, "逗逼理论");
        database.insertScore("ZhangSan",666,77);
        database.insertScore("LiSi",233,50);
        database.insertScore("WangWu",233,60);
        database.insertScore("WangWu",666,23);
        for (String i : database.listScoreByStudent("WangWu").keySet()) {
            System.out.println(i+":"+database.listScoreByStudent("WangWu").get(i));
        }
        for (String j : database.listScoreByCourse("逗逼理论").keySet()) {
            System.out.println(j+":"+database.listScoreByCourse("逗逼理论").get(j));
        }
    }
}