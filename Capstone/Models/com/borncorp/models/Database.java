package com.borncorp.models;

public class Database {

	private static String ip = "23.95.38.197";
	private static String database="db";
	private static String user="test";
	private static String password="test";
	public static String connection = "jdbc:mysql://" + ip + "/" + database + "?user="+ user + "&password=" + password;
}

