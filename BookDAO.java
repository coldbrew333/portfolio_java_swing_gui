package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.domain.BookVO;


public class BookDAO {

	// DB접속정보
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "myuser";
	private final String passwd = "1234";

	// DB접속 후 커넥션 객체 가져오는 메소드
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;

		// 1단계. JDBC 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2단계. DB연결
		con = DriverManager.getConnection(url, user, passwd);

		return con;
	} // getConnection

	private void close(Connection con, PreparedStatement pstmt) {
		close(con, pstmt, null);
	}

	private void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		// JDBC 자원 닫기 (사용의 역순으로 닫음)
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // close

	// 책등록하기
	public void insertBook(BookVO bookVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "";
			sql += "INSERT INTO Book (name,writer,publisher, kategorie, count, reg_date) ";
			sql += "VALUES (seq_friend.nextval, ?, ?, ?, ?, ?,?) ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bookVO.getName());
			pstmt.setString(2, bookVO.getWriter());
			pstmt.setString(3, bookVO.getPublisher());
			pstmt.setString(4, bookVO.getKategorie());
			pstmt.setString(5, bookVO.getCount());
			pstmt.setTimestamp(6, bookVO.getRegdate());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

	}// insertBook()

	// 콤보박스 검색하기

	public List<BookVO> search(String field, String word) {// <-여기 부분 왜 오류가 날까?
		List<BookVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "";
			sql += "SELECT * ";
			sql += "FROM friend ";
			sql += "WHERE " + field + " LIKE ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + word + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookVO bookVO = new BookVO();
				bookVO.setNum(rs.getInt("num"));
				bookVO.setName(rs.getString("name"));
				bookVO.setWriter(rs.getString("writer"));
				bookVO.setPublisher(rs.getString("publisher"));
				bookVO.setKategorie(rs.getString("kategorie"));
				bookVO.setCount(rs.getString("count"));
				bookVO.setRegdate(rs.getTimestamp("reg_date"));

				list.add(bookVO);

			} // while

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

	}// list<>

//톺아보기
	public List<BookVO> getBooks(){//여기는 왜 오류가 나는 것일까?
		List<BookVO>list= new ArrayList<>();
		
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		try {
			con = getConnection();
			
			String sql = "SELECT * FROM friend ORDER BY kategorie,Name ASC";
			
			pstmt=con.prepareStatement(sql);
			
			while(rs.next()) {
				BookVO bookVO= new BookVO();
				bookVO.setNum(rs.getInt("num"));
				bookVO.setName(rs.getString("name"));
				bookVO.setWriter(rs.getString("writer"));
				bookVO.setPublisher(rs.getString("publisher"));
				bookVO.setKategorie(rs.getString("kategorie"));
				bookVO.setCount(rs.getString("count"));
				bookVO.setRegdate(rs.getTimestamp("reg_date"));
				
				list.add(bookVO);
				
				
				
				
			}//while
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con,pstmt,rs);
		}
		
	}
	
	//수정하기
	public void updateBooks(BookVO bookVO) {
		
		Connection con =null;
		PreparedStatement pstmt= null;
		
		try {
			con = getConnection();
			
			String sql="UPDATE book";
			sql+="SET name=?,writer=?,publisher=?,"
					+ "kategorie=?,count=?,reg_date=?";
			sql+="WHERE num=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,bookVO.getName());
			pstmt.setString(2,bookVO.getWriter());
			pstmt.setString(3,bookVO.getPublisher());
			pstmt.setString(4,bookVO.getKategorie());
			pstmt.setString(5,bookVO.getCount());
			pstmt.setTimestamp(6, bookVO.getRegdate());
			pstmt.setInt(6,bookVO.getNum());
			
			pstmt.executeUpdate();
			
			} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con,pstmt);
		}
		
		
	}//updateBooks
	
	
	//삭제하기
	
	public void removeByNum(int num) {
		
		Connection con= null;
		PreparedStatement pstmt =null;
		
		try {
			con = getConnection();
			
			String sql="";
			sql+="DELETE FROM book";
			sql+="WHERE num";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con,pstmt);
		}
		
		
	}//removeBynum
	
	
	//main에 이미지 넣기
	
	
	
	
	

}// public class BookDAO
