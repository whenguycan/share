package com.score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class ScoreTest {
	
	public static void main(String[] args) {
		List<Score> scoreList = Score.init();
		List<String> classList = new ArrayList<>();
		classList.add("3");
		classList.add("4");
		List<String> subjectList = new ArrayList<>();
		subjectList.add("math");
		subjectList.add("en");
		subjectList.add("phy");
		List<String> studentList = new ArrayList<>();
		studentList.add("jim");
		studentList.add("bill");
		studentList.add("alice");
		studentList.add("bob");
		
		SubjectModel smTotal = new SubjectModel("total");
		Map<String, SubjectModel> smSubjectMap = new HashMap<String, SubjectModel>();
		
		Map<String, Map<String, List<Score>>> map = new HashMap<>();
		
		for(String subject : subjectList){
			SubjectModel subjectModel = new SubjectModel(subject);
			smSubjectMap.put(subject, subjectModel);
			for(String clazz : classList){
				List<Score> sList = findByClassAndSubject(scoreList, clazz, subject);
				addToMap(map, sList);
				ScoreModel scoreModel = new ScoreModel(clazz);
				for(Score score : sList){
					scoreModel.addScore(score.score);
				}
				subjectModel.scoreModelList.add(scoreModel);
			}
		}
		
		for(String clazz : map.keySet()){
			Map<String, List<Score>> subMap = map.get(clazz);
			ScoreModel sm = new ScoreModel(clazz);
			for(String student : subMap.keySet()){
				List<Score> sList = subMap.get(student);
				double total = 0;
				for(Score score : sList){
					total += score.score;
				}
				sm.addScore(total);
			}
			smTotal.scoreModelList.add(sm);
		}
		
		System.out.println(new Gson().toJson(smTotal));
		System.out.println(new Gson().toJson(smSubjectMap));
		
	}
	
	public static void addToMap(Map<String, Map<String, List<Score>>> map, List<Score> scoreList){
		if(scoreList != null){
			for(Score score : scoreList){
				if(!map.containsKey(score.clazz)){
					List<Score> list = new ArrayList<>();
					list.add(score);
					Map<String, List<Score>> subMap = new HashMap<>();
					subMap.put(score.name, list);
					map.put(score.clazz, subMap);
				}else{
					Map<String, List<Score>> subMap = map.get(score.clazz);
					if(!subMap.containsKey(score.name)){
						List<Score> list = new ArrayList<>();
						list.add(score);
						subMap.put(score.name, list);
					}else{
						subMap.get(score.name).add(score);
					}
				}
			}
		}
	}
	
	public static List<Score> findByClassAndSubject(List<Score> list, String clazz, String subject){
		List<Score> subList = new ArrayList<>();
		for(Score score : list){
			if(score.clazz.equals(clazz) && score.subject.equals(subject)){
				subList.add(score);
			}
		}
		return subList;
	}
	
}

class SubjectModel{
	String subject;
	List<ScoreModel> scoreModelList = new ArrayList<>();
	public SubjectModel(String subject){
		this.subject = subject;
	}
}

class ScoreModel{
	String clazz;
	Double top;
	Double bottom;
	double avg;
	int studentCount;
	double total;
	public ScoreModel(String clazz){
		this.clazz = clazz;
	}
	public void addScore(double score){
		this.total += score;
		this.studentCount++;
		this.avg = this.total / this.studentCount;
		if(this.top == null || score > this.top)
			this.top = score;
		if(this.bottom == null || score < this.bottom)
			this.bottom = score;
	}
}

class Score{
	String id;
	String name;
	String clazz;
	String subject;
	int score;
	public Score(String id, String name, String clazz, String subject, int score){
		this.id = id;
		this.name = name;
		this.clazz = clazz;
		this.subject = subject;
		this.score = score;
	}
	public static List<Score> init(){
		List<Score> list = new ArrayList<>();
		
		list.add(new Score("1", "jim", "3", "math", 5));
		list.add(new Score("2", "jim", "3", "en", 6));
		list.add(new Score("3", "jim", "3", "phy", 7));
		
		list.add(new Score("4", "bill", "3", "math", 9));
		list.add(new Score("5", "bill", "3", "en", 9));
		list.add(new Score("6", "bill", "3", "phy", 3));
		
		list.add(new Score("7", "alice", "4", "math", 2));
		list.add(new Score("8", "alice", "4", "en", 2));
		list.add(new Score("9", "alice", "4", "phy", 18));
		
		list.add(new Score("10", "bob", "4", "math", 5));
		list.add(new Score("11", "bob", "4", "en", 5));
		
		return list;
	}
}