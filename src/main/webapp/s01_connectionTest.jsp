<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.SQLException"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC Connect</title>
</head>
<body>
	<%
		String drivername = "oracle.jdbc.OracleDriver";
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "wlstjr";
		String dbPw = "123123";

		Connection conn = null;
		try {
			//JDBC 수행 1단계 : 드라이버 로드
			Class.forName(drivername);

			//JDBC 수행 2단계 : Connection 객체 생성
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);

			out.println("정상적으로 연결되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) try {conn.close();} catch (Exception e) {}
		}
	%>
</body>
</html>