package example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import tw.commands.GuessInputCommand;

class GuessInputCommandTest {

	@Test
	void should_return_1A0B_1正确_when_get_answer_given_answer_1_2_3_4_and_input_1_5_6_7() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		String input = "1 5 6 7";
		List<String> answer =Arrays.asList("1","2","3","4");
		List<String> inputList = Arrays.asList(input.split(" "));
		
		//when
		List<String> numA = guessInputCommand.getANum(inputList,answer);
		List<String> numB = guessInputCommand.getBNum(inputList,answer,numA);	
		String result = guessInputCommand.printResult(inputList,numA,numB);
		
		//then
		assertEquals("1A0B 1正确", result);
	}
	
	@Test
	void should_return_0A2B_2和4位置错误_when_get_answer_given_answer_1_2_3_4_and_input_2_4_7_8() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		String input = "2 4 7 8";
		List<String> answer =Arrays.asList("1","2","3","4");
		List<String> inputList = Arrays.asList(input.split(" "));
		
		//when
		List<String> numA = guessInputCommand.getANum(inputList,answer);
		List<String> numB = guessInputCommand.getBNum(inputList,answer,numA);	
		String result = guessInputCommand.printResult(inputList,numA,numB);
		
		//then
		assertEquals("0A2B 2和4位置错误", result);
	}
	
	@Test
	void should_return_1A2B_4正确_2和3错误的位置_when_get_answer_given_answer_1_2_3_4_and_input_0_3_2_4() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		String input = "0 3 2 4";
		List<String> answer =Arrays.asList("1","2","3","4");
		List<String> inputList = Arrays.asList(input.split(" "));
		
		//when
		List<String> numA = guessInputCommand.getANum(inputList,answer);
		List<String> numB = guessInputCommand.getBNum(inputList,answer,numA);	
		String result = guessInputCommand.printResult(inputList,numA,numB);
		
		//then
		assertEquals("1A2B 4正确，2和3位置错误", result);
	}
	
	@Test
	void should_return_0A0B_都错了_when_get_answer_given_answer_1_2_3_4_and_input_5_6_7_8() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		String input = "5 6 7 8";
		List<String> answer =Arrays.asList("1","2","3","4");
		List<String> inputList = Arrays.asList(input.split(" "));
		
		//when
		List<String> numA = guessInputCommand.getANum(inputList,answer);
		List<String> numB = guessInputCommand.getBNum(inputList,answer,numA);	
		String result = guessInputCommand.printResult(inputList,numA,numB);
		
		//then
		assertEquals("0A0B 都错了", result);
	}
	
	@Test
	void should_return_0A4B_4个数字位置错误_when_get_answer_given_answer_1_2_3_4_and_input_4_3_2_1_() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		String input = "4 3 2 1";
		List<String> answer =Arrays.asList("1","2","3","4");
		List<String> inputList = Arrays.asList(input.split(" "));
		
		//when
		List<String> numA = guessInputCommand.getANum(inputList,answer);
		List<String> numB = guessInputCommand.getBNum(inputList,answer,numA);	
		String result = guessInputCommand.printResult(inputList,numA,numB);
		
		//then
		assertEquals("0A4B 4个数字位置错误", result);
	}
	
	@Test
	void should_return_4A0B_胜利_一切正确_when_get_answer_given_answer_1_2_3_4_and_input_1_2_3_4() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		String input = "1 2 3 4";
		List<String> answer =Arrays.asList("1","2","3","4");
		List<String> inputList = Arrays.asList(input.split(" "));
		
		//when
		List<String> numA = guessInputCommand.getANum(inputList,answer);
		List<String> numB = guessInputCommand.getBNum(inputList,answer,numA);	
		String result = guessInputCommand.printResult(inputList,numA,numB);
		
		//then
		assertEquals("4A0B 胜利，一切正确", result);
	}
	
	@Test
	void should_return_输入错误_再次输入_when_get_answer_given_given_answer_1_2_3_4_and_repeat_input_example_4_3_2_1_() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		String input = "1 1 2 3";
		List<String> answer =Arrays.asList("1","2","3","4");
		List<String> inputList = Arrays.asList(input.split(" "));
		
		//when
		List<String> numA = guessInputCommand.getANum(inputList,answer);
		List<String> numB = guessInputCommand.getBNum(inputList,answer,numA);	
		String result = guessInputCommand.printResult(inputList,numA,numB);
		
		//then
		assertEquals("输入错误，再次输入", result);
	}
	
	@Test
	void should_return_输入错误_再次输入_when_get_answer_given_answer_1_2_3_4_and_less_input_example_1_2() {
		//given
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		String input = "1 2";
		List<String> answer =Arrays.asList("1","2","3","4");
		List<String> inputList = Arrays.asList(input.split(" "));
		
		//when
		List<String> numA = guessInputCommand.getANum(inputList,answer);
		List<String> numB = guessInputCommand.getBNum(inputList,answer,numA);	
		String result = guessInputCommand.printResult(inputList,numA,numB);
		
		//then
		assertEquals("输入错误，再次输入", result);
	}
}
