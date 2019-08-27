package tw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tw.commands.GuessInputCommand;

public class Main {
	private static final int RUN_TIMES = 6;

	public static void main(String[] args) throws Exception {
		GuessInputCommand guessInputCommand = new GuessInputCommand();
		List<String> answer = guessInputCommand.getAnswer();
		answer.forEach(p -> System.out.print(p + " "));
		for (int i = 0; i < RUN_TIMES; i++) {
			String input = guessInputCommand.input();
			List<String> inputList = Arrays.asList(input.split(" "));
			List<String> numA = guessInputCommand.getANum(inputList, answer);
			List<String> numB = guessInputCommand.getBNum(inputList, answer, numA);
			String result = guessInputCommand.printResult(inputList, numA, numB);
			System.out.println(result);
			if (result.equals("4A0B 胜利，一切正确")) {
				break;
			}
		}
		System.out.println("游戏结束！");
	}
}
