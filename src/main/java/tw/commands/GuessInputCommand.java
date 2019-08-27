package tw.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class GuessInputCommand {
	private BufferedReader bufferedReader;

	public GuessInputCommand() {
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}

	public String input() throws IOException {
		System.out.println("------Please input your answer as x x x x , x <10 ------");
		return bufferedReader.readLine();
	}

	public List<String> getAnswer() {
		Set<String> list1 = new HashSet<>();
		while (list1.size() < 4) {
			list1.add(String.valueOf(new Random().nextInt(9)));
		}
		return new ArrayList<String>(list1);
	}

	public List<String> getANum(List<String> inputList, List<String> answer) {
		return inputList.stream()
				.filter(p -> answer.contains(p)&&inputList.indexOf(p)==answer.indexOf(p))
				.collect(Collectors.toList());
	}
	
	public List<String> getBNum(List<String> inputList, List<String> answer,List<String> numA) {
		return inputList.stream()
				.filter(p -> answer.contains(p)&&(!numA.contains(p)))
				.collect(Collectors.toList());
	}

	public String printResult(List<String> inputList,List<String> numA, List<String> numB) {
		if(inputList.stream().distinct().count()<4) {
			return "输入错误，再次输入";
		}
		StringBuilder result =new StringBuilder();
		int numASize=numA.size();
		int numBSize=numB.size();
		if(numASize==4) {
			return numASize+"A"+numBSize+"B"+" 胜利，一切正确";
		}
		if(numASize==0) {
			if(numBSize==0) {
				return numASize+"A"+numBSize+"B"+" 都错了";
			}else if(numBSize==4) {
				return numASize+"A"+numBSize+"B"+" 4个数字位置错误";
			}
		}
		result.append(numASize+"A"+numBSize+"B ");
		if(numASize>0) {	
			
			numA.forEach(p -> result.append(p+"和"));
			result.deleteCharAt(result.length()-1);
			result.append("正确");
			if(numBSize>0) {	
				result.append("，");
			}
		}
		if(numBSize>0) {
			Collections.sort(numB);
			numB.forEach(p -> result.append(p+"和"));
			result.deleteCharAt(result.length()-1);
			result.append("位置错误");
		}
		
		return result.toString();
	}
}
