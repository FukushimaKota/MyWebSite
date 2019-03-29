package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comment;
import model.Thread;


public class CommentDao {

	//コメント作成
	public void CreateComment(String id,String id2, String comment) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql = "INSERT INTO comment(comment,thread_id,userid,create_date) VALUES (?,?,?,now());";
			//INSERTを実行
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, comment);
			stmt.setString(2, id2);
			stmt.setString(3, id);
			int result = stmt.executeUpdate();

			// 追加された行数を出力
			System.out.println(result);
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	//開いたスレの全件表示
	public ArrayList<Comment> AllComment(String threadId) {
		Connection conn = null;
		ArrayList<Comment> commentList = new ArrayList<Comment>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			// SELECT文を準備
			//String sql = "SELECT * FROM comment WHERE thread_id=? ORDER BY create_date DESC;";
			String sql = "SELECT * FROM comment WHERE thread_id=?;";
//SELECT * FROM comment WHERE thread_id='13';//ok
			// SELECTを実行し、結果表を取得
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, threadId);

			//Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery();

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String commentt = rs.getString("comment");
				String userId = rs.getString("userid");
				String threadId2 = rs.getString("thread_id");
				String createDate = rs.getString("create_date");

				Comment comment = new Comment(id, commentt, userId,threadId2, createDate);

				commentList.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return commentList;
	}

//	public Comment Commentname(String id) {
//		Connection conn = null;
//		try {
//			// データベースへ接続
//			conn = DBManager.getConnection();
//			String sql = "SELECT * FROM comment WHERE userid = ?";
//			// SELECTを実行し、結果表を取得
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setString(1, id);
//			ResultSet rs = stmt.executeQuery();
//
//			// 結果表に格納されたレコードの内容
//			if (rs.next()) {
//				int ida = rs.getInt("id");
//				String loginId = rs.getString("login_id");
//				String name = rs.getString("name");
//				Date birthDate = rs.getDate("birth_date");
//				String password = rs.getString("password");
//				String createDate = rs.getString("create_date");
//				String updateDate = rs.getString("update_date");
//
//				return new Comment(name);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		} finally {
//			// データベース切断
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//					return null;
//				}
//			}
//		}
//		return null;
//	}


	public Thread CDelete(String id) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql = "DELETE FROM comment WHERE thread_id = ?;";
			// SELECTを実行し、結果表を取得
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			int result = stmt.executeUpdate();
			// 追加された行数を出力
			System.out.println(result);
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}