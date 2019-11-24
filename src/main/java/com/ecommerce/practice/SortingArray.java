package com.ecommerce.practice;

import java.util.List;
import java.util.ArrayList;

class SortingArray {
	/*
	 * Complete the 'sort' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * INTEGER_ARRAY toSortArray as parameter.
	 */
	public static List<Integer> sort(List<Integer> toSortArray) {
		
		Integer arr[] = new Integer[toSortArray.size()];

		for (int i = 0; i < toSortArray.size(); i++) {
			arr[i] = toSortArray.get(i);
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					Integer tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}
			}
		}

		List<Integer> list = new ArrayList<>();

		for (Integer test : arr) {
			list.add(test);
		}

		return list;
	}
	
	public static void main(String[] args) {
		List<Integer> toSortArray = new ArrayList<>();
		toSortArray.add(4);
		toSortArray.add(10);
		toSortArray.add(1);
		toSortArray.add(2);
		toSortArray.add(3);
		
		List<Integer> sortedArray = sort(toSortArray);
		for(Integer temp : sortedArray) {
			System.out.println(temp);
		}
	}

}
