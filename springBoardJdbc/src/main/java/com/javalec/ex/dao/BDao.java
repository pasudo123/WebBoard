package com.javalec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javale.ex.util.Constant;
import com.javalec.ex.dto.BDto;

public class BDao {
	// 실제 데이터베이스에 접근해서 실제적인 작업을 수행	
	
	// 다같이 이용해야한다. (Jdbc Template 이용하기 이전 필드)
	DataSource dataSource;
	
	// jdbcTemplate 를 이용하기 위해서 스태틱 필드 삽입
	JdbcTemplate template = null;
	
	
	public BDao() {
//		try {
//			Context context = new InitialContext();
//			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
		
		// 위의 내용은 이제 필요가 없다 자바 빈에서 모두 설정하였기 때문
		template = Constant.template;
	}
	
	// JdbcTemplate 이용
	public ArrayList<BDto> listByTemplate(){
		ArrayList<BDto> dtos = null;
		
		
		String query = "SELECT bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bstep asc";
		
		// 첫번째 파라미터 : 쿼리문
		// 두번째 파라미터 : 데이터를 가져올 커맨드 객체 지정
		dtos = (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
		return dtos;
	}
	
	public void writeByTemplate(final String bName, final String bTitle, final String bContent){
		final String query = "INSERT INTO mvc_board(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) "
				+ "VALUES (mvc_board_seq.nextVal, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
		
//		System.out.println(bName);
//		System.out.println(bTitle);
//		System.out.println(bContent);
		
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement pstmt = connection.prepareStatement(query);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				
				return pstmt;
			}
		});
	}
	
	public BDto contentViewByTemplate(String strID){
		// 조회수 증가
		upHits(strID);
		
		String query = "SELECT * FROM mvc_board WHERE bId = " + strID;
		BDto dto = template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		return dto; 
	}
	
	public void upHits(final String strID){
		String query = "UPDATE mvc_board SET bHit = bHit+1 WHERE bId = ?";
		
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement arg0) throws SQLException {
				arg0.setInt(1, Integer.parseInt(strID));
			}
		}); 
	}
	
	public void modifyByTemplate(final String bId, final String bName, final String bTitle, final String bContent){
		final String query = "UPDATE mvc_board SET bName = ?, bTitle = ?, bContent = ? where bId = ?";
		
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, bName);
				preparedStatement.setString(2, bTitle);
				preparedStatement.setString(3, bContent);
				preparedStatement.setInt(4, Integer.parseInt(bId));
			}
		});
	}
	
	public void deleteByTemplate(final String strID){
		final String query = "DELETE FROM mvc_board WHERE bId = ?";
		
		template.update(query, new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setInt(1, Integer.parseInt(strID));
			}
		});
	}
	
	public BDto replyViewByTemplate(final String strID){
		String query = "SELECT * FROM mvc_board WHERE bId = "  + strID;
		BDto dto = template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
		return dto;
	}
	
	public void replyByTemplate(final String bId, final String bName, final String bTitle, final String bContent, final String bGroup, final String bStep, final String bIndent){
		String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, ? ,? ,?)";
		
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				pstmt.setInt(4, Integer.parseInt(bGroup));
				pstmt.setInt(5, Integer.parseInt(bStep) + 1);
				pstmt.setInt(6, Integer.parseInt(bIndent) + 1);
			}
		});
	}
	
	public void replyShapeByTemplate(final String strGroup, final String strStep){
		String query = "UPDATE mvc_board SET bStep = bStep + 1 WHERE bGroup = ? AND bStep > ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt ) throws SQLException {
				pstmt.setInt(1, Integer.parseInt(strGroup));
				pstmt.setInt(2, Integer.parseInt(strStep));
			}
		});
	}
}
