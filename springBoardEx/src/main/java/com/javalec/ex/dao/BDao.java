package com.javalec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.javalec.ex.dto.BDto;

public class BDao {
	// 실제 데이터베이스에 접근해서 실제적인 작업을 수행
	
	// 다같이 이용해야한다. 
	DataSource dataSource;
	
	public BDao() {
		try {
			
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// 클라이언트가 글의 리스트를 보기위해 요청하는 메소드
	public ArrayList<BDto> list() {
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try{
			// 커넥션 객체
			connection = dataSource.getConnection();
			
			// 쿼리문 작성
			String query = "SELECT bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bstep asc";
			// 위의 내용에서 그룹넘버는 내림차순으로 (그룹넘버 : 원글의 번호) 따라서 최근의 글이 맨 위로 올라갈 수 있다.
			// bStep은 높은 글이 먼저 올라올 수 있게, 처음 작성한 글이 위로 올라갈 수 있도록
			
			// DB에 접속하고 해당 쿼리문을 파라미터로 삽입
			preparedStatement = connection.prepareStatement(query);
			
			// resultSet 결과물
			resultSet = preparedStatement.executeQuery();
			
			// 데이터를 가져왔으면, result 을 분리해야 한다.
			while(resultSet.next()){
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if (resultSet != null)
					resultSet.close();
				
				if(preparedStatement != null)
					preparedStatement.close();
				
				if(connection != null)
					connection.close();
			}
			catch(Exception e){}
		}
		/**
		 * DAO에서 실제 데이터베이스에 접근하기 위해서 데이터베이스 커넥션도 설정
		 * 
		 **/

		return dtos;
	}
	
	public void write(String bName, String bTitle, String bContent){
		// 데이터베이스에 값을 저장하는 형태 (글을 입력)
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try{
			connection = dataSource.getConnection();
			String query = "INSERT INTO mvc_board(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) "
					+ "VALUES (mvc_board_seq.nextVal, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
			
			System.out.println(query);
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			
			int rn = preparedStatement.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public BDto contentView(String strID){

		updateHit();
		
		BDto dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try{
			connection = dataSource.getConnection();
			
			String query = "SELECT * FROM mvc_board WHERE bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,  Integer.parseInt(strID));
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				
				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(connection != null)
					connection.close();
				if(resultSet != null)
					resultSet.close();
				if(preparedStatement != null)
					preparedStatement.close();
			}
			catch(Exception e){
				
			}
		}
		
		return dto;
	}
	
	public void updateHit(){}
}
