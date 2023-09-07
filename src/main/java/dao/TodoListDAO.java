package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TodoListDAO {
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	
	public void connect() throws NamingException,SQLException{
		Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/mariadb");
		con = ds.getConnection();
	}
	
	private void disconnect() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 接続確認
	public void connectCheck() {
		try {
			this.connect();
			System.out.println("OK");
		}catch(NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
	
	// カテゴリ一覧取得
	public List<String> findCategory(){
		List<String> list = new ArrayList<String>();
		try {
			this.connect();
			stmt = con.prepareStatement("SELECT category FROM todolist GROUP BY category");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String category = rs.getString("category");
				list.add(category);
			}
		}catch(NamingException | SQLException e) {
			
		}finally {
			this.disconnect();
		}
		return list;
	}
}
