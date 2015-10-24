package com.briup.chap08;

public class StringCalculator {
	// 主计算方法参数为一个混合运算字符串
	public static String cacluteMain(String str) {
		String[] str1 = str.split("[+-]"); // 将字符串用“+-”拆分
		for (int i = 0; i < str1.length; i++) { // 若拆分的子串包含“*/”高级运算，怎调用高级运算函数
			if (str1[i].indexOf("/") > 0 || str1[i].indexOf("*") > 0) {
				str1[i] = caculateUnder(str1[i]);
			}
		}
		char stdfc[] = str.toCharArray(); // 将次字符串转成字符数组
		char stdf[] = new char[50]; // 用于存放字符数组中符号
		int j = 0, count = 1;
		for (int i = 0; i < stdfc.length; i++) { // 记录字符数组中的运算符号及其次序
			if (stdfc[i] == '+') {
				stdf[j] = '+';
				j++;
				count++;
			}c
			if (stdfc[i] == '-') {
				stdf[j] = '-';
				j++;
				count++;
			}
		}
		double stdd[] = new double[50];
		for (int i = 0; i < str1.length; i++)
			// 将子串转换成实数
			stdd[i] = Double.parseDouble(str1[i]);
		for (int i = 1; i < stdf.length; i++) { // 将转换成的实数数组结合记录的符号数组计算结果
			if (stdf[i - 1] == '+')
				stdd[0] += stdd[i];
			if (stdf[i - 1] == '-')
				stdd[0] -= stdd[i];
		}
		Double d = new Double(stdd[0]);
		String result = d.toString();
		return result; // 返回值为计算结果的字符串对象
	}

	// 此方法为私有方法只有主方法caculateMain()能调用；此方法用于计算含有“*/”高级字符串
	private static String caculateUnder(String str) {// 此函数用于计算包含“/*”高级运算
		// String stds[];
		char stdf[] = new char[50]; // 用于记录所传字符串中的运算符号
		double stdd[] = new double[50]; // 用于存放所拆分成的字符串的实数转换
		String stds[] = str.split("[/*]"); // 拆分所传的字符串参数
		for (int i = 0; i < stds.length; i++)
			// 将分开的子串转换成实数
			stdd[i] = Double.parseDouble(stds[i]);
		char stdfc[] = str.toCharArray(); // 将所传字符串转成字符数组
		int j = 0, count = 1;
		for (int i = 0; i < stdfc.length; i++) { // 用数组stdf[]记录字符数组中运算符号的位置
			if (stdfc[i] == '/') {
				stdf[j] = '/';
				j++;
				count++;
			}
			if (stdfc[i] == '*') {
				stdf[j] = '*';
				j++;
				count++;
			}
		}
		for (int i = 1; i < count; i++) { // 根据转换成的实数数组和记录符号的数组来计算
			if (stdf[i - 1] == '/')
				stdd[0] /= stdd[i];
			if (stdf[i - 1] == '*')
				stdd[0] *= stdd[i];
		}
		Double d = new Double(stdd[0]);
		String result = d.toString();
		return result; // 返回值为结果的字符串对象
	}

	// 此函数用于计算包含括号的字符串
	public static String caculateHigh(String str) {
		String[] str1;
		str1 = str.split("[(]"); // 用左括号将所传参数分隔
		String str2;
		str2 = cacluteMain(str1[str1.length - 1]); // 调用住计算方法
		String str3;
		str3 = "(" + str1[str1.length - 1];
		str = str.replace(str3, str2); // 将括号中的结果替换掉原来括号的位置
		return str;
	}

	public static void main(String[] args) {
		System.out.println(cacluteMain("3*4/2+5*4/2+3-4+9*2/4*2"));
	}
}
