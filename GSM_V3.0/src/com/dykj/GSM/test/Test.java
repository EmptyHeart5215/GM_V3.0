package com.dykj.GSM.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] a) throws IOException {
		getDLL("E:\\TS_GSM\\GSM_V3.0\\src\\com\\dykj\\GSM\\imessage\\IMessage.java");
	}

	public static void getDLL(String url) throws IOException {
		String tableName = "";
		FileReader reader = new FileReader(url);

		BufferedReader br = new BufferedReader(reader);
		String str = null;
		// 正则初始化
		Pattern p = Pattern.compile("[A-Z]");
		StringBuffer result = new StringBuffer();
		String comment = "";
		StringBuffer cb = new StringBuffer();
		while ((str = br.readLine()) != null) {
			if (str.contains("public class ")) {
				tableName = str.substring(13, str.indexOf(" extends"));
				System.out.println(tableName+"--------------------");
				tableName = tableName.substring(0, 1).toLowerCase() + tableName.substring(1);
				System.out.println(tableName+"--------------------");
				Matcher m = p.matcher(tableName);
				while (m.find()) {
					String a = m.group();
					tableName = tableName.replaceAll(a, "_" + a.toLowerCase());
					m = p.matcher(tableName);
				}
				tableName = tableName.toUpperCase();
				System.out.println("drop table \"GSM\".\"" + tableName + "\";");
				System.out.println("CREATE TABLE \"GSM\".\"" + tableName + "\"");
				System.out.println(" (	\"CODE\" NVARCHAR2(255) PRIMARY KEY, ");
				System.out.println("	\"CREATE_DATE\" NVARCHAR2(255) not null, ");
				System.out.println("	\"CREATE_BY\" NVARCHAR2(255) not null, ");
				System.out.println("	\"FLAG_DEL\" CHAR(1 BYTE) DEFAULT 0  not null, ");
				System.out.println("	\"FLAG_DISPLAY\" CHAR(1 BYTE) DEFAULT 0 not null , ");
				System.out.println("	\"SORT\" NUMBER, ");
				System.out.println("	\"REMARK\" NVARCHAR2(255),");
				cb.append("comment on column " + tableName + ".CODE is'主键';\n");
				cb.append("comment on column " + tableName + ".CREATE_DATE is'创建时间';\n");
				cb.append("comment on column " + tableName + ".CREATE_BY is'创建人';\n");
				cb.append("comment on column " + tableName + ".FLAG_DEL is'删除标识';\n");
				cb.append("comment on column " + tableName + ".FLAG_DISPLAY is'显示标识';\n");
				cb.append("comment on column " + tableName + ".SORT is'排序';\n");
				cb.append("comment on column " + tableName + ".REMARK is'备注';\n");
			} else if (str.contains("/**")) {
				str = str + br.readLine() + br.readLine();
				comment = str.substring("/**	 * ".length() + 1, str.indexOf("\t */"));
			} else if (str.contains("@Transient")) {
				br.readLine();
				continue;
			} else if (str.contains("\tprivate Integer ")) {
				String column = turnColumn("private Integer", str, p, comment, cb, tableName);
				result.append("	\"" + column + "\" NUMBER(4,0),\n");
			} else if (str.contains("\tprivate String ")) {
				String column = turnColumn("private String", str, p, comment, cb, tableName);
				result.append("	\"" + column + "\" NVARCHAR2(255),\n");
			} else if (str.contains("\tprivate Date ")) {
				String column = turnColumn("private Date", str, p, comment, cb, tableName);
				result.append("	\"" + column + "\" NUMBER(4,0),\n");
			} else if (str.contains("\tprivate Boolean ")) {
				String column = turnColumn("private Boolean", str, p, comment, cb, tableName);
				result.append("	\"" + column + "\" CHAR(1 BYTE) DEFAULT 0 not null,\n");
			} else if (str.contains("\tprivate BigDecimal ")) {
				String column = turnColumn("private BigDecimal", str, p, comment, cb, tableName);
				result.append("	\"" + column + "\" NUMBER(4,0),\n");
			}
		}
		String pp = result.toString().substring(0, result.toString().lastIndexOf(","));
		System.out.println(pp + ");");
		System.out.println(cb.toString());
	}

	public static String turnColumn(String type, String str, Pattern p, String comment, StringBuffer cb,
			String tableName) {
		String column = str.substring((type + " ").length() + 1, str.indexOf(";"));
		Matcher m = p.matcher(column);
		while (m.find()) {
			String a = m.group();
			column = column.replaceAll(a, "_" + a.toLowerCase());
			m = p.matcher(column);
		}
		cb.append("comment on column " + tableName + "." + column + " is'" + comment + "';\n");
		return column.toUpperCase();
	}

}
