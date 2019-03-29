package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Thread;

public class ThreadDao {

	//スレッド作成
	public void CreateThread(String id, String tittle ,String text) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql = "INSERT INTO thread(tittle,text,userid,create_date) VALUES (?,?,?,now());";
			//UPDATEを実行
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, tittle);
			stmt.setString(2, text);
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

	//全件表示
	public ArrayList<Thread> AllThread() {
		Connection conn = null;
		ArrayList<Thread> threadList = new ArrayList<Thread>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備

			String sql = "SELECT * FROM thread WHERE id ORDER BY create_date DESC";

			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String tittle = rs.getString("tittle");
				String text = rs.getString("text");
				String userId = rs.getString("userId");
				String createDate = rs.getString("create_date");

				Thread thread = new Thread(id, tittle, text, userId, createDate);

				threadList.add(thread);
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
		return threadList;
	}

	//記事の本文表示
	public Thread ThreadData(String id) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM thread WHERE id = ?";
			// SELECTを実行し、結果表を取得
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			// 結果表に格納されたレコードの内容
			if (rs.next()) {
				int ida = rs.getInt("id");
				String tittle = rs.getString("tittle");
				String text = rs.getString("text");
				String userId = rs.getString("userId");
				String createDate = rs.getString("create_date");

				return new Thread(ida, tittle,text,userId, createDate);
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
		return null;
	}

	//thread削除。
	public Thread Delete(String id) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql = "DELETE FROM thread WHERE id = ?;";
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
