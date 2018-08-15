package kr.or.connect.mvcexam.dao;

public class GangDaoSqls {
	public static final String SELECT_ALL = "SELECT * FROM moon order by name";
	public static final String SELECT_BY_NAME = "SELECT * FROM moon WHERE name like :name group by name";
	public static final String SELECT_BY_ONLY_NAME = "SELECT * FROM moon WHERE name = :name";
	

}
