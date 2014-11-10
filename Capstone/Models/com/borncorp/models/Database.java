package com.borncorp.models;

public class Database {

	private static String ip = "23.95.38.197";
	private static String database="mydb";
	private static String user="myuser";
	private static String password="password";
	public static String connection = "jdbc:mysql://" + ip + "/" + database + "?user="+ user + "&password=" + password;
}

