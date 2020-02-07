package com.t3h.bigproject.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import okhttp3.Interceptor;

public class base {
	public static void main(String[] args) {
		List<String> arr = new ArrayList<>();
		arr.add("12/2/1999");
		arr.add("11/2/2999");
		arr.add("10/2/2100");
		arr.add("9/10/3000");
		arr.add("8/9/1999");
		arr.add("7/5/5642");
		arr.add("6/2/1999");
		arr.add("5/3/2222");
		arr.add("4/12/1999");
		arr.add("3/4/1999");
		List<String> aftercredit = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			for (int j = i + 1; j < arr.size(); j++) {
				int year = arr.get(i).lastIndexOf("/");
				int year1 = arr.get(j).lastIndexOf("/");
				String strYear = arr.get(i).substring(year + 1);
				String strYearAfter = arr.get(j).substring(year1 + 1);
				int year2 = Integer.parseInt(strYear);
				int year3 = Integer.parseInt(strYearAfter);
				if (year3 < year2) {
					String strYear2 = arr.get(j);
					arr.set(j, arr.get(i));
					arr.set(i, strYear2);
				}
			}
		}

		for (int i = 0; i < arr.size(); i++) {
			for (int j = i + 1; j < arr.size(); j++) {
				int year = arr.get(i).lastIndexOf("/");
				int year1 = arr.get(j).lastIndexOf("/");
				String strYear = arr.get(i).substring(year + 1);
				String strYearAfter = arr.get(j).substring(year1 + 1);
				int year2 = Integer.parseInt(strYear);
				int year3 = Integer.parseInt(strYearAfter);
				if (year3 == year2) {
					int month = arr.get(i).indexOf("/");
					String strMonth = arr.get(i).substring(month + 1, year);
					int month1 = arr.get(j).indexOf("/");
					String strMoth1 = arr.get(j).substring(month1 + 1, year1);
					int month2 = Integer.parseInt(strMonth);
					int month3 = Integer.parseInt(strMoth1);
					if (month2 < month3) {
						String strMoth2 = arr.get(i);
						arr.set(i, arr.get(j));
						arr.set(j, strMoth2);
					} else if (month2 == month3) {
						int day = Integer.parseInt(arr.get(i).substring(0, month));
						int day1 = Integer.parseInt(arr.get(j).substring(0, month1));
						if (day < day1) {
							String strDay = arr.get(j);
							arr.set(j, arr.get(i));
							arr.set(i, strDay);
						}
					}
				}
			}

		}
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
}
