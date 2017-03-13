package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.Animation;
import controller.MissingLetters;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("GAP TEST");
		System.out.print("Please enter 1 to Problem Statement 1 or 2 to Problem Statement 2: ");
		String optionSelected = reader.readLine();
		if (optionSelected.equals("1")) {
			System.out.print("Enter de sentence: ");
			MissingLetters missingLetters = new MissingLetters();
			String strMissingLetters = missingLetters.getMissingLetters(reader.readLine());
			System.out.print("'" + strMissingLetters + "'");
		} else if (optionSelected.equals("2")) {
			Animation animation = new Animation();
			System.out.print("Enter a speed: ");
			int speed = Integer.parseInt(reader.readLine());
			System.out.print("Enter a init: ");
			String init = reader.readLine();
			String[] totalArray = animation.animate(speed, init);
			if (totalArray != null) {
				for (String str : totalArray) {
					System.out.print(str);
				}
			}

		}

	}

}
