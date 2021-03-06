import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SqlOperations {
	
	public static ArrayList<Movie> getMovie(String Query) {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			con = getConnection();
			statement = con.prepareStatement(Query);
			result = statement.executeQuery();
			
			ResultSetMetaData rsMetaData = result.getMetaData();
			int columnCount = rsMetaData.getColumnCount(); //number of column return from sql query
			
			String[] attr = new String[]{"mTitle", "mDate", "mCountry", "mTime", "mLanguage","mRatingSum",
					"mRatingCount","mNumOfVisit", "mDescription", "mImage", "mUrlLink", "movieId"};
			ArrayList<Movie> array = new ArrayList<Movie>();
			
			while(result.next()){
				Movie a = new Movie();
				if(columnCount == attr.length){
					Movie temp = new Movie(result.getString(attr[0]), result.getString(attr[1]), result.getString(attr[2]),
							result.getString(attr[3]), result.getString(attr[4]), result.getDouble(attr[5]), result.getDouble(attr[6]),
							result.getInt(attr[7]),result.getString(attr[8]), result.getBytes(attr[9]),
							result.getString(attr[10]), result.getString(attr[11]));
					array.add(temp);
				}
				else{
					for(int i = 1; i <= columnCount ; i++){
						String g = rsMetaData.getColumnName(i); //return column name in ResultSet with index (first index is 1) 
						if(g.equals(attr[0])){a.setmTitle(result.getString(attr[0]));}
						if(g.equals(attr[1])){a.setmDate(result.getString(attr[1]));}
						if(g.equals(attr[2])){a.setmCountry(result.getString(attr[2]));}
						if(g.equals(attr[3])){a.setmTime(result.getString(attr[3]));}
						if(g.equals(attr[4])){a.setmLanguage(result.getString(attr[4]));}
						if(g.equals(attr[5])){a.setmRatingSum(result.getDouble(attr[5]));}
						if(g.equals(attr[6])){a.setmRatingCount(result.getDouble(attr[6]));}
						if(g.equals(attr[7])){a.setmNumOfVisit(result.getInt(attr[7]));}
						if(g.equals(attr[8])){a.setmDescription(result.getString(attr[8]));}
						if(g.equals(attr[9])){a.setmImage(result.getBytes(attr[9]));}
						if(g.equals(attr[10])){a.setmUrlLink(result.getString(attr[10]));}
						if(g.equals(attr[11])){a.setMovieId(result.getString(attr[11]));}
					}
					array.add(a);
				}
				
			}
			return array;

		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try { if (result != null) result.close(); } catch (Exception e) {};
			try { if (statement != null) statement.close(); } catch (Exception e) {};
			try { if (con != null) con.close(); } catch (Exception e) {};
		}
		return null;
	}//END OF getMovie

	public static ArrayList<People> getPeople(String Query){
		
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			con = getConnection();
			statement = con.prepareStatement(Query);
			result = statement.executeQuery();
			
			ResultSetMetaData rsMetaData = result.getMetaData();
			int columnCount = rsMetaData.getColumnCount(); //number of column return from sql query
			
			String[] attr = new String[]{"pTitle", "pBirthday", "pBirthPlace", "pImage", "pDescription", "pImageUrl", "peopleId"};
			ArrayList<People> array = new ArrayList<People>();
			
			while(result.next()){
				People a = new People();
				if(columnCount == attr.length){
					People temp = new People(result.getString(attr[0]), result.getString(attr[1]), result.getString(attr[2]),
							result.getBytes(attr[3]), result.getString(attr[4]),result.getString(attr[5]),result.getString(attr[6]));
					array.add(temp);
				}
				else{
					for(int i = 1; i <= columnCount ; i++){
						String g = rsMetaData.getColumnName(i); //return column name in ResultSet with index (first index is 1) 
						if(g.equals(attr[0])){a.setpTitle(result.getString(attr[0]));}
						if(g.equals(attr[1])){a.setpBirthday(result.getString(attr[1]));}
						if(g.equals(attr[2])){a.setpBirthPlace(result.getString(attr[2]));}
						if(g.equals(attr[3])){a.setpImage(result.getBytes(attr[3]));}
						if(g.equals(attr[4])){a.setpDescription(result.getString(attr[4]));}
						if(g.equals(attr[5])){a.setpImageUrl(result.getString(attr[5]));}
						if(g.equals(attr[6])){a.setPeopleId(result.getString(attr[6]));}
					}
					array.add(a);
				}
				
			}
			return array;

		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try { if (result != null) result.close(); } catch (Exception e) {};
			try { if (statement != null) statement.close(); } catch (Exception e) {};
			try { if (con != null) con.close(); } catch (Exception e) {};
		}
		return null;
	}//END OF getPeople
	
	public static ArrayList<Organization> getOrganization(String Query){
		
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			con = getConnection();
			statement = con.prepareStatement(Query);
			result = statement.executeQuery();
			
			ResultSetMetaData rsMetaData = result.getMetaData();
			int columnCount = rsMetaData.getColumnCount(); //number of column return from sql query
			
			String[] attr = new String[]{"orgName", "orgCountry", "organizationId"};
			ArrayList<Organization> array = new ArrayList<Organization>();
			
			while(result.next()){
				Organization a = new Organization();
				if(columnCount == attr.length){
					Organization temp = new Organization(result.getString(attr[0]), result.getString(attr[1]), result.getInt(attr[2]));
					array.add(temp);
				}
				else{
					for(int i = 1; i <= columnCount ; i++){
						String g = rsMetaData.getColumnName(i); //return column name in ResultSet with index (first index is 1) 
						if(g.equals(attr[0])){a.setorgName(result.getString(attr[0]));}
						if(g.equals(attr[1])){a.setorgCountry(result.getString(attr[1]));}
						if(g.equals(attr[2])){a.setorganizationId(result.getInt(attr[2]));}
					}
					array.add(a);
				}
				
			}
			return array;

		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try { if (result != null) result.close(); } catch (Exception e) {};
			try { if (statement != null) statement.close(); } catch (Exception e) {};
			try { if (con != null) con.close(); } catch (Exception e) {};
		}
		return null;
	}//END OF getOrganization
	
	public static ArrayList<Genre> getGenre(String movieId){
		
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			String query = "SELECT mType FROM Genre WHERE (movieId = '" + movieId + "') LIMIT 0,3";
			con = getConnection();
			statement = con.prepareStatement(query);
			result = statement.executeQuery();
			
			ArrayList<Genre> array = new ArrayList<Genre>();
			
			while(result.next()){
				Genre a = new Genre();
				a.setmType(result.getString("mType"));
				array.add(a);
			}
			return array;

		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try { if (result != null) result.close(); } catch (Exception e) {};
			try { if (statement != null) statement.close(); } catch (Exception e) {};
			try { if (con != null) con.close(); } catch (Exception e) {};
		}
		return null;
	}//END OF getGenre
	
	public static ArrayList<RoleInMovie> getRole(String query){
		
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			con = getConnection();
			statement = con.prepareStatement(query);
			result = statement.executeQuery();
			
			ResultSetMetaData rsMetaData = result.getMetaData();
			int columnCount = rsMetaData.getColumnCount(); //number of column return from sql query
			
			String[] attr = new String[]{"castName", "actorFlag", "directorFlag", "writerFlag", "fkPeopleId", "fkMovieId"};
			ArrayList<RoleInMovie> array = new ArrayList<RoleInMovie>();
			
			while(result.next()){
				RoleInMovie a = new RoleInMovie();
				if(columnCount == attr.length){
					RoleInMovie temp = new RoleInMovie(result.getString(attr[0]), result.getInt(attr[1]), result.getInt(attr[2]),
							result.getInt(attr[3]), result.getString(attr[4]), result.getString(attr[5]));
					array.add(temp);
				}
				else{
					for(int i = 1; i <= columnCount ; i++){
						String g = rsMetaData.getColumnName(i); //return column name in ResultSet with index (first index is 1) 
						if(g.equals(attr[0])){a.setCastName(result.getString(attr[0]));}
						if(g.equals(attr[1])){a.setActorFlag(result.getInt(attr[1]));}
						if(g.equals(attr[2])){a.setDirectorFlag(result.getInt(attr[2]));}
						if(g.equals(attr[3])){a.setWriterFlag(result.getInt(attr[3]));}
						if(g.equals(attr[4])){a.setFkPeopleId(result.getString(attr[4]));}
						if(g.equals(attr[5])){a.setFkMovieId(result.getString(attr[5]));}
					}
					array.add(a);
				}
				
			}
			return array;

		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try { if (result != null) result.close(); } catch (Exception e) {};
			try { if (statement != null) statement.close(); } catch (Exception e) {};
			try { if (con != null) con.close(); } catch (Exception e) {};
		}
		return null;
	}//END OF getRole

	public static ArrayList<UserClass> getUserInfo(String query){
		
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			con = getConnection();
			statement = con.prepareStatement(query);
			result = statement.executeQuery();
			
			ResultSetMetaData rsMetaData = result.getMetaData();
			int columnCount = rsMetaData.getColumnCount(); //number of column return from sql query
			
			String[] attr = new String[]{"uEmail", "uDisplayName", "uPassword", "uRegistrationDate", "userId"};
			ArrayList<UserClass> array = new ArrayList<UserClass>();
			
			while(result.next()){
				UserClass a = new UserClass();
				for(int i = 1; i <= columnCount ; i++){
					String g = rsMetaData.getColumnName(i); //return column name in ResultSet with index (first index is 1) 
					if(g.equals(attr[0])){a.setuEmail(result.getString(attr[0]));}
					if(g.equals(attr[1])){a.setuDisplayName(result.getString(attr[1]));}
					if(g.equals(attr[2])){a.setuPassword(result.getString(attr[2]));}
					if(g.equals(attr[3])){a.setuRegistrationDate(result.getString(attr[3]));}
					if(g.equals(attr[4])){a.setUserId(result.getInt(attr[4]));}
				}
				array.add(a);
				
			}
			return array;

		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try { if (result != null) result.close(); } catch (Exception e) {};
			try { if (statement != null) statement.close(); } catch (Exception e) {};
			try { if (con != null) con.close(); } catch (Exception e) {};
		}
		return null;
	}//END OF userInfo
	
	public static ArrayList<UserRatings> getUserRating(String query){
		
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			con = getConnection();
			statement = con.prepareStatement(query);
			result = statement.executeQuery();
			
			ResultSetMetaData rsMetaData = result.getMetaData();
			int columnCount = rsMetaData.getColumnCount(); //number of column return from sql query
			
			String[] attr = new String[]{"fkUserId", "fkMovieId", "rating", "ratedTime"};
			ArrayList<UserRatings> array = new ArrayList<UserRatings>();
			
			while(result.next()){
				UserRatings a = new UserRatings();
				for(int i = 1; i <= columnCount ; i++){
					String g = rsMetaData.getColumnName(i); //return column name in ResultSet with index (first index is 1) 
					if(g.equals(attr[0])){a.setFkUserId(result.getString(attr[0]));}
					if(g.equals(attr[1])){a.setFkMovieId(result.getString(attr[1]));}
					if(g.equals(attr[2])){a.setRating(result.getInt(attr[2]));}
					if(g.equals(attr[3])){a.setRatedTime(result.getTimestamp(attr[3]));}
				}
				array.add(a);
			}
			return array;

		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try { if (result != null) result.close(); } catch (Exception e) {};
			try { if (statement != null) statement.close(); } catch (Exception e) {};
			try { if (con != null) con.close(); } catch (Exception e) {};
		}
		return null;
	}//END OF userRating

	public static ArrayList<MovieCommentClass> getMovieComment(String Query){
		
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			con = getConnection();
			statement = con.prepareStatement(Query);
			result = statement.executeQuery();
			
			ResultSetMetaData rsMetaData = result.getMetaData();
			int columnCount = rsMetaData.getColumnCount(); //number of column return from sql query
			
			String[] attr = new String[]{"fkMovieId", "fkUserId", "commend", "commendTime", "commendId"};
			ArrayList<MovieCommentClass> array = new ArrayList<MovieCommentClass>();
			
			while(result.next()){
				MovieCommentClass a = new MovieCommentClass();
				for(int i = 1; i <= columnCount ; i++){
					String g = rsMetaData.getColumnName(i); //return column name in ResultSet with index (first index is 1) 
					if(g.equals(attr[0])){a.setFkMovieId(result.getString(attr[0]));}
					if(g.equals(attr[1])){a.setFkUserId(result.getInt(attr[1]));}
					if(g.equals(attr[2])){a.setComment(result.getString(attr[2]));}
					if(g.equals(attr[3])){a.setCommentTime(result.getTimestamp(attr[3]));}
					if(g.equals(attr[4])){a.setCommentId(result.getInt(attr[4]));}
				}
				array.add(a);		
			}
			return array;

		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try { if (result != null) result.close(); } catch (Exception e) {};
			try { if (statement != null) statement.close(); } catch (Exception e) {};
			try { if (con != null) con.close(); } catch (Exception e) {};
		}
		return null;
	}//END OF getMovieComment
	
	public static ArrayList<MovieCommentReplyClass> getMovieCommentReply(String Query){
		
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			con = getConnection();
			statement = con.prepareStatement(Query);
			result = statement.executeQuery();
			
			ResultSetMetaData rsMetaData = result.getMetaData();
			int columnCount = rsMetaData.getColumnCount(); //number of column return from sql query
			
			String[] attr = new String[]{"fkCommendId", "fkUserId", "commend", "commendTime", "commendId"};
			ArrayList<MovieCommentReplyClass> array = new ArrayList<MovieCommentReplyClass>();
			
			while(result.next()){
				MovieCommentReplyClass a = new MovieCommentReplyClass();
				for(int i = 1; i <= columnCount ; i++){
					String g = rsMetaData.getColumnName(i); //return column name in ResultSet with index (first index is 1) 
					if(g.equals(attr[0])){a.setFkCommentId(result.getInt(attr[0]));}
					if(g.equals(attr[1])){a.setFkUserId(result.getInt(attr[1]));}
					if(g.equals(attr[2])){a.setComment(result.getString(attr[2]));}
					if(g.equals(attr[3])){a.setCommentTime(result.getTimestamp(attr[3]));}
					if(g.equals(attr[4])){a.setCommentId(result.getInt(attr[4]));}
				}
				array.add(a);		
			}
			return array;

		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try { if (result != null) result.close(); } catch (Exception e) {};
			try { if (statement != null) statement.close(); } catch (Exception e) {};
			try { if (con != null) con.close(); } catch (Exception e) {};
		}
		return null;
	}//END OF getMovieCommentReply
	
	public static Connection getConnection(){

		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/imdb?autoReconnect=true&useSSL=false";
			String username = "root";
			String password = "h3b9er1po";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}//END OF getConnection
	
	public static void postMovieImage(String directory){
		
		Connection con = null;
		PreparedStatement statement = null;
			
		ArrayList<Movie> list = SqlOperations.getMovie("SELECT mTitle FROM Movie");
		
		String imageQuery = "UPDATE Movie SET mImage = ? WHERE mTitle = ?";
		con = getConnection();
		try {
			statement = con.prepareStatement(imageQuery);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
		}
		for(int i = 0; i < list.size(); i++){
			try {
				String fileName = list.get(i).getmTitle();
				File theFile = new File(directory + "\\" + fileName + ".jpg");
				FileInputStream input = new FileInputStream(theFile);
				statement.setBinaryStream(1, input);
				statement.setString(2, fileName);
				statement.executeUpdate();
				
			} catch(java.io.FileNotFoundException e){
				//do nothing
				System.out.println("File doesnt exist");
			} catch (Exception e) {
				System.out.println(e);
			} 
		}
		
		try { if (statement != null) statement.close(); } catch (Exception e) {};
		try { if (con != null) con.close(); } catch (Exception e) {};
	}
	
	public static void postPeopleImage(String directory){
		
		Connection con = null;
		PreparedStatement statement = null;
		ArrayList<People> list = SqlOperations.getPeople("SELECT pTitle,pImage FROM People WHERE "
				+ "peopleId IN (SELECT fkPeopleId FROM moviepeople WHERE fkMovieId='" + MainForm.staticMovieId + "')");
		String imageQuery = "UPDATE People SET pImage = ? WHERE pTitle = ?";
		con = getConnection();
		try {
			statement = con.prepareStatement(imageQuery);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0; i < list.size(); i++){
			try {
					if(list.get(i).getpImage() == null){
						String fileName = list.get(i).getpTitle();
						File theFile = new File(directory + "\\" + fileName + ".jpg");
						FileInputStream input = new FileInputStream(theFile);
						statement.setBinaryStream(1, input);
						statement.setString(2, fileName);
						statement.executeUpdate();
						System.out.println("" + i + " of " + list.size() + "added");
					}
			} catch(java.io.FileNotFoundException e){
				//do nothing
				System.out.println("File doesnt exist");
			} catch (Exception e) {
				System.out.println(e);
			} 
		}

		try { if (statement != null) statement.close(); } catch (Exception e) {};
		try { if (con != null) con.close(); } catch (Exception e) {};
			
	}
	
	public static ImageIcon getMovieImage(String movieId,JLabel lblImage){
		try{
			String Query = "SELECT mImage FROM Movie WHERE movieId = '" + movieId + "'";
			ImageIcon imageIcon = new ImageIcon(SqlOperations.getMovie(Query).get(0).getmImage());
			Image image = imageIcon.getImage();
			Image im = image.getScaledInstance(lblImage.getWidth(),	lblImage.getHeight(), Image.SCALE_SMOOTH);
			return new ImageIcon(im);
		} catch(Exception e){
			//Do nothing
			ImageIcon imageIcon = new ImageIcon("C://Workplace//OurIMDb//DB//PeopleMinimizedImages//null.jpg");
			Image image = imageIcon.getImage();
			Image im = image.getScaledInstance(lblImage.getWidth(),	lblImage.getHeight(), Image.SCALE_SMOOTH);
			return new ImageIcon(im);
		}
		
	}
	
	public static ImageIcon getPeopleImage(String peopleId,JLabel lblImage){
		try{
			String Query = "SELECT pImage FROM People WHERE peopleId = '" + peopleId + "'";
			ImageIcon imageIcon = new ImageIcon(SqlOperations.getPeople(Query).get(0).getpImage());
			Image image = imageIcon.getImage();
			Image im = image.getScaledInstance(lblImage.getWidth(),	lblImage.getHeight(), Image.SCALE_SMOOTH);
			return new ImageIcon(im);
		}
		catch(Exception e){
			ImageIcon imageIcon = new ImageIcon("C://Workplace//OurIMDb//DB//PeopleMinimizedImages//null.jpg");
			Image image = imageIcon.getImage();
			Image im = image.getScaledInstance(lblImage.getWidth(),	lblImage.getHeight(), Image.SCALE_SMOOTH);
			return new ImageIcon(im);
		}
		
	}
	
	public static void insert(String query){
		
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = getConnection();
			statement = con.prepareStatement(query);
			statement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try { if (statement != null) statement.close(); } catch (Exception e) {};
			try { if (con != null) con.close(); } catch (Exception e) {};
		}
	}
	
	public static void delete(String query){
		
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = getConnection();
			statement = con.prepareStatement(query);
			statement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try { if (statement != null) statement.close(); } catch (Exception e) {};
			try { if (con != null) con.close(); } catch (Exception e) {};
		}
	}
	
	public static void update(String query){
		
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = getConnection();
			statement = con.prepareStatement(query);
			statement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try { if (statement != null) statement.close(); } catch (Exception e) {};
			try { if (con != null) con.close(); } catch (Exception e) {};
		}
	}
	
	public static void updateMovieRating(String mId, int userRating){
		
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = getConnection();
			String query = "UPDATE Movie SET mRatingCount = mRatingCount + 1, "
					+ "mRatingsum = mRatingSum + " + userRating + " WHERE movieId = '" + mId + "'";
			statement = con.prepareStatement(query);
			statement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try { if (statement != null) statement.close(); } catch (Exception e) {};
			try { if (con != null) con.close(); } catch (Exception e) {};
		}
	}
	
	public static void updateMovieRatingAfterRated(String mId, int userRating, int oldRate){
		
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = getConnection();
			String query = "UPDATE Movie SET mRatingSum = mRatingSum + " + (userRating-oldRate) + " WHERE movieId = '" + mId + "'";
			statement = con.prepareStatement(query);
			statement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try { if (statement != null) statement.close(); } catch (Exception e) {};
			try { if (con != null) con.close(); } catch (Exception e) {};
		}
	}
	
	public static int getPeopleCount(){
		Connection con = null;
		PreparedStatement statement = null;
		
		try {
			String countQuery = "SELECT count(peopleId) as peopleCount FROM people";
			con = getConnection();
			statement = con.prepareStatement(countQuery);
			ResultSet result = statement.executeQuery();
			int x = 0;
			while(result.next()){
				x = result.getInt("peopleCount");
			}
			return x;
		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try { if (statement != null) statement.close(); } catch (Exception e) {};
			try { if (con != null) con.close(); } catch (Exception e) {};
		}
		return 0;
	}
	
}
