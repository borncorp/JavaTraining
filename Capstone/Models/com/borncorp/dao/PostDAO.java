package com.borncorp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;

import com.borncorp.models.DBConnection;
import com.borncorp.models.Post;
import com.sun.rowset.CachedRowSetImpl;

public class PostDAO extends DBConnection {

	public void createPost(Post post) {
		// SQL STUFF
		try {
			// INSERT, UPDATE, or DELETE
			PreparedStatement stmt = createStatement("INSERT INTO posts (username, content, title) VALUES (?,?,?)");

			stmt.setString(1, post.getUsername());
			stmt.setString(2, post.getContent());
			stmt.setString(3, post.getTitle());

			stmt.execute();
			stmt.close();

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public Post getPost(Post post) {
		// SQL STUFF
		CachedRowSet results = null;
		ResultSet rs = null;

		try {
			PreparedStatement stmt = createStatement("SELECT * FROM posts WHERE postid = ? LIMIT 1");

			stmt.setInt(1, post.getPostid());
			rs = stmt.executeQuery();

			results = new CachedRowSetImpl();
			results.populate(rs);
			stmt.close();
			rs.close();

			while (results.next()) {
				int postid = results.getInt("postid");
				String username = results.getString("username");
				String title = results.getString("title");
				String content = results.getString("content");
				Timestamp date = results.getTimestamp("date");

				post.setTitle(title);
				post.setContent(content);
				post.setUsername(username);
				post.setPostid(postid);
				post.setDate(date);
			}
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		}
		return post;
	}

	public ArrayList<Post> getPosts(int offset, int howmany) {
		// SQL STUFF
		CachedRowSet results = null;
		ResultSet rs = null;
		ArrayList<Post> allposts = new ArrayList<>();

		// Saves results in a CachedRowSet
		try {
			PreparedStatement stmt = createStatement("SELECT * FROM posts ORDER BY date DESC LIMIT ?, ?");

			stmt.setInt(1, offset);
			stmt.setInt(2, howmany);
			rs = stmt.executeQuery();

			results = new CachedRowSetImpl();
			results.populate(rs);
			stmt.close();
			rs.close();

			try {
				while (results.next()) {
					int postid = results.getInt("postid");
					String username = results.getString("username");
					String title = results.getString("title");
					String content = results.getString("content");
					Timestamp date = results.getTimestamp("date");

					Post aPost = new Post();

					aPost.setTitle(title);
					aPost.setContent(content);
					aPost.setUsername(username);
					aPost.setPostid(postid);
					aPost.setDate(date);

					allposts.add(aPost);
				}
				results.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		}
		return allposts;
	}

	public void updatePost(Post post) {
		// SQL STUFF
		try {
			PreparedStatement stmt = createStatement("UPDATE posts SET content=?,title=? WHERE postid = ? LIMIT 1");

			stmt.setString(1, post.getContent());
			stmt.setString(2, post.getTitle());
			stmt.setInt(3, post.getPostid());
			stmt.executeUpdate();
			stmt.close();
		}

		catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public void deletePost(Post post) {
		// SQL STUFF

		try {
			PreparedStatement stmt = createStatement("DELETE FROM posts WHERE postid = ? LIMIT 1");

			stmt.setInt(1, post.getPostid());
			stmt.execute();
			stmt.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
}
