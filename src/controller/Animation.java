package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Animation {

	public String[] animate(int speed, String init) {
		String[] totalArray = null;
		if (validateParameters(speed, init)) {
			System.out.println("is Valid");
			String[] items = init.split("(?!^)");
			String totalString = "";
			List<Integer> keys = new ArrayList<Integer>();
			List<String> values = new ArrayList<String>();
			int lengthInit = items.length;
			Map<List<Integer>, List<String>> eachPosition = new HashMap<List<Integer>, List<String>>();
			boolean exitCycle = false;
			String[] newItems = initArray(lengthInit);
			for (int i = 0; i < lengthInit; i++) {
				keys.add(i);
				values.add(items[i]);
			}
			while (!exitCycle) {
				eachPosition.put(keys, values);
				newItems = initArray(lengthInit);
				for (int i = 0; i < lengthInit; i++) {
					if (keys.get(i) >= 0 && keys.get(i) < lengthInit && !values.get(i).equals(".")) {
						newItems[keys.get(i)] = "X";
					}
				}
				totalString += Arrays.toString(newItems) + "\n";
				List<Integer> keysCopy = new ArrayList<Integer>();
				List<String> valuesCopy = new ArrayList<String>();
				for (int i = 0; i < lengthInit; i++) {
					keysCopy.add(i);
					valuesCopy.add(".");
				}
				for (int i = 0; i < lengthInit; i++) {
					if (values.get(i).equals("R")) {
						keysCopy.set(i, keys.get(i) + speed);
						valuesCopy.set(i, "R");
					} else if (values.get(i).equals("L")) {
						keysCopy.set(i, keys.get(i) - speed);
						valuesCopy.set(i, "L");
					}
				}

				keys = new ArrayList<Integer>(keysCopy);
				values = new ArrayList<String>(valuesCopy);
				if (Arrays.stream(newItems).parallel().allMatch(("."::contains))) {
					exitCycle = true;
				}
			}
			totalArray = totalString.split("(?!^)");
		} else {
			System.out.println("is Not Valid");
		}
		return totalArray;
	}

	private String[] initArray(int sizeInit) {
		String[] array = new String[sizeInit];
		Arrays.fill(array, ".");
		return array;
	}

	private boolean validateParameters(int speed, String init) {
		boolean isValidSpeed = false;
		boolean isValidInit = false;

		if (speed >= 1 && speed <= 10) {
			isValidSpeed = true;
		}
		if (init.length() >= 1 && init.length() <= 50) {
			if (init.matches("[RL.]+")) {
				isValidInit = true;
			}
		}
		if (isValidSpeed && isValidInit) {
			return true;
		} else {
			return false;
		}
	}
}
