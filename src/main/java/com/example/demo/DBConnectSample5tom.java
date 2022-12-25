package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class DBConnectSample5tom extends HttpServlet
{

	  @RequestMapping("/DBConnect4")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Connection conn = null;

		response.setContentType("text/html; charset=Windows-31J");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("<table border=’true’>");
		out.println("<tr><th>id</th><th>name</th><th>price</th><th>量"
				+ "</th></tr>");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC ドライバのロード
			String url = "jdbc:mysql://localhost/devdb01?useUnicode=true&characterEncoding=utf8"; // 接続先URL
			String user = "root"; //ユーザ名
			String password = "3140293Mysql2212!"; // パスワード

			conn = DriverManager.getConnection(url, user, password); // 接続の確立

			Statement stmt = conn.createStatement();
			
			String sql = "INSERT INTO items(name,price,quantity) values('じゃがいも5',110,50)";
		    stmt.executeUpdate(sql);
			
			
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM items"); // SQL文の実行

			while (rs.next()) { // SQL実行結果の取り出し
				out.print("<tr>");
				out.print("<td>"+rs.getString("id")+"</td>");
				out.print("<td>"+rs.getString("name") + "</td>");
				out.print("<td>"+rs.getString("price") + "</td>");
				out.print("<td>"+rs.getString("quantity") + "</td>");
				out.print("</tr>");
			}
		}
		catch (ClassNotFoundException e) {
			out.println("クラスが見つかりません。");
		}
		catch (SQLException e) {
			out.println("データベース操作中にエラーがありました。");
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null)
					conn.close(); // 接続の切断
			}
			catch (SQLException e) {}
		}

		out.println("</table>");
		out.println("</body></html>");
		out.close();
	}
	  
	  
	  
	  

	  //入力内容をINSERTするクラス
	  
	  
	  @RequestMapping("/register4_1")
	protected void doPost1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Connection conn = null;

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		
		out.println("<html><head></head><body>");
		out.println("<table border=’true’>");
		out.println("<tr><th>id</th><th>name</th><th>price</th><th>量"
				+ "</th></tr>");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC ドライバのロード
			String url = "jdbc:mysql://localhost/devdb01?useUnicode=true&characterEncoding=utf8"; // 接続先URL
			String user = "root"; //ユーザ名
			String password = "3140293Mysql2212!"; // パスワード

			conn = DriverManager.getConnection(url, user, password); // 接続の確立

			Statement stmt = conn.createStatement();
			
			String sql = "INSERT INTO items(name,price,quantity) values('" + name + "',"+ price +","+ quantity +")";
		    stmt.executeUpdate(sql);
			
			
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM items"); // SQL文の実行

			while (rs.next()) { // SQL実行結果の取り出し
				out.print("<tr>");
				out.print("<td>"+rs.getString("id")+"</td>");
				out.print("<td>"+rs.getString("name") + "</td>");
				out.print("<td>"+rs.getString("price") + "</td>");
				out.print("<td>"+rs.getString("quantity") + "</td>");
				out.print("</tr>");
			}
		}
		catch (ClassNotFoundException e) {
			out.println("クラスが見つかりません。");
		}
		catch (SQLException e) {
			out.println("データベース操作中にエラーがありました。");
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null)
					conn.close(); // 接続の切断
			}
			catch (SQLException e) {}
		}

		out.println("</table><br/><br/>");
		out.println("<br/><form action=\"/register4_1\" method=\"post\">名前(30字以内)：<input type=\"text\" name=\"name\" size=\"10\" /><br/>価格：<input type=\"text\" name=\"price\" size=\"10\"/><br/>在庫量：<input type=\"text\" name=\"quantity\" size=\"10\"/><br/><br/><input type=\"submit\" value=\"送信\" /></form>");
		out.println("<br/><form action=\"/register4_2\" method=\"post\">id：<input type=\"text\" name=\"id\" size=\"10\" /><br/><input type=\"submit\" value=\"削除\" /></form>");
		
		out.println("<br/><br/><form action=\"/4\" method=\"post\"><input type=\"submit\" value=\"戻るよ\" /></form>");
		
		out.println("</body></html>");
		out.close();
	}
	    
	  
	  
	  
	  
	  
	  
	  //削除のMapping
	  
	  @RequestMapping("/register4_2")
	protected void doPost2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Connection conn = null;

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		
		out.println("<html><head></head><body>");
		out.println("<table border=’true’>");
		out.println("<tr><th>id</th><th>name</th><th>price</th><th>量"
				+ "</th></tr>");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC ドライバのロード
			String url = "jdbc:mysql://localhost/devdb01?useUnicode=true&characterEncoding=utf8"; // 接続先URL
			String user = "root"; //ユーザ名
			String password = "3140293Mysql2212!"; // パスワード

			conn = DriverManager.getConnection(url, user, password); // 接続の確立

			Statement stmt = conn.createStatement();
			
			String sql = "delete from items where id ="+ id;
		      int i = stmt.executeUpdate(sql);
			
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM items"); // SQL文の実行
			out.println( i + "件レコードを削除しました。");
			while (rs.next()) { // SQL実行結果の取り出し
				out.print("<tr>");
				out.print("<td>"+rs.getString("id")+"</td>");
				out.print("<td>"+rs.getString("name") + "</td>");
				out.print("<td>"+rs.getString("price") + "</td>");
				out.print("<td>"+rs.getString("quantity") + "</td>");
				out.print("</tr>");
			}
		}
		catch (ClassNotFoundException e) {
			out.println("クラスが見つかりません。");
		}
		catch (SQLException e) {
			out.println("データベース操作中にエラーがありました。");
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null)
					conn.close(); // 接続の切断
			}
			catch (SQLException e) {}
		}

		out.println("</table><br/><br/>");
		out.println("<br/><form action=\"/register4_1\" method=\"post\">名前(30字以内)：<input type=\"text\" name=\"name\" size=\"10\" /><br/>価格：<input type=\"text\" name=\"price\" size=\"10\"/><br/>在庫量：<input type=\"text\" name=\"quantity\" size=\"10\"/><br/><br/><input type=\"submit\" value=\"送信\" /></form>");
		out.println("<br/><form action=\"/register4_2\" method=\"post\">id：<input type=\"text\" name=\"id\" size=\"10\" /><br/><input type=\"submit\" value=\"削除\" /></form>");
		out.println("<br/><br/><form action=\"/4\" method=\"post\"><br/><input type=\"submit\" value=\"戻るよ\" /></form>");
		
		out.println("</body></html>");
		out.close();
	}  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	  
	  
	  @RequestMapping("/4")
	  public String start() {
	    return "input4.html";
	  }


	  @RequestMapping("/register4")
	  public ModelAndView register
	    (@ModelAttribute RegisterBean4 rb, ModelAndView m) {
	    m.addObject("rb", rb);
	    m.setViewName("register4.html");
	    return m;
	  }
	  @RequestMapping("/DBregister4")
	  public ModelAndView dbregister
	    (@ModelAttribute RegisterBean4 rb, ModelAndView m) {
	    m.addObject("rb", rb);
	    m.setViewName("success4.html");
	    return m;
	  }  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  @RequestMapping("/servlet5")
	  public class RegisterServlet extends HttpServlet {
	    public void doPost(HttpServletRequest req, HttpServletResponse res)
	        throws IOException, ServletException {
	      // リクエストの文字コード指定
	      req.setCharacterEncoding("utf-8");
	      
	      // 入力情報の取得
	      String date = req.getParameter("date");
	      String contentname = req.getParameter("contentname");
	      String[] time = req.getParameterValues("time");
	      res.setContentType("text/html;charset=utf-8");
	      
	      // Beanの作成
	      ContentBean rb = new ContentBean();
	      rb.setDate(date);
	      rb.setContentname(contentname);
	      rb.setTime(time);
	      
	      rb.setHoge("hoge~");
	      
	      // Beanをリクエストに格納
	      req.setAttribute("rb", rb);
	      
	      // register.jspへフォワード
	      jakarta.servlet.RequestDispatcher rd = req.getRequestDispatcher("register50.jsp");  ///src/main/webapp/register50.jsp
	      rd.forward(req, res);
	      
	      //　request.getRequestDispatcher(“遷移先のパス”).forward(request, response);でも可
	      
	    }
	    public void doGet(HttpServletRequest req, HttpServletResponse res)
	        throws IOException, ServletException {
	      doPost(req, res);
	    }
	  }
	  
	  
	  @RequestMapping("/servlet50")
	  public ModelAndView dbregistertest
	    (@ModelAttribute ContentBean rb, ModelAndView m) {
	    m.addObject("rb", rb);
 	    m.setViewName("register5html.html");   //register5html.html  register50.jsp
	    return m;
	  }  
	  
	  @RequestMapping("/501")
	  public ModelAndView dbregistertest1
	    (@ModelAttribute ContentBean rb, ModelAndView m) {
	      rb.setHoge("hoge~");
	    m.addObject("rb", rb);
 	    m.setViewName("test5th.html");   //register5html.html  register50.jsp
	    return m;
	  }  
	  
	  
	  
	  @RequestMapping("/502")
	  public ModelAndView dbregistertest2
	  (@ModelAttribute ContentBean rb, ModelAndView m) {
		  rb.setHoge("先生");
	        int dice = 1 + (int) Math.floor(Math.random()*6);
//	        int dice = 1 ;
//	        m.addAttribute("dice", dice);
	        m.addObject("dice", dice);
		  
		  m.addObject("rb",rb);
		  m.setViewName("test5th2.html");
		  return m;
		  
		  
		  
	  }
	  
	  @RequestMapping("/504")
	  public ModelAndView dbregistertest3
	  (@ModelAttribute ContentBean rb, ModelAndView m) {
		   m.addObject("rb",rb);
		  m.setViewName("test5th503.html");
		  return m;
		  
		  
		  
	  }
	  
	  
	  
	  
	  //DBconnectをthymeleafに落とし込み。
	  
	  

	  @RequestMapping("/503")
//	protected void doPost3(HttpServletRequest request, HttpServletResponse response)
	  protected ModelAndView doPost3(@ModelAttribute HttpServletRequest request, ModelAndView m)
			throws ServletException, IOException
	{
		Connection conn = null;

		
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		


		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC ドライバのロード
			String url = "jdbc:mysql://localhost/devdb01?useUnicode=true&characterEncoding=utf8"; // 接続先URL
			String user = "root"; //ユーザ名
			String password = "root"; // パスワード

			conn = DriverManager.getConnection(url, user, password); // 接続の確立

			Statement stmt = conn.createStatement();
			
			String sql = "INSERT INTO items(name,price,quantity) values('" + name + "',"+ price +","+ quantity +")";
		    stmt.executeUpdate(sql);
			ResultSet rs = stmt.executeQuery("SELECT * FROM items"); // SQL文の実行
			  m.addObject("rs",rs);


		}
		catch (ClassNotFoundException e) {
//			out.println("クラスが見つかりません。");
		}
		catch (SQLException e) {
//			out.println("データベース操作中にエラーがありました。");
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null)
					conn.close(); // 接続の切断
			}
			catch (SQLException e) {}
		}
		
		
		
		 
			  m.setViewName("test5th503.html");
			  return m;
			  
	

	}
	    
	
	  
	  
	  
	  
	  

	  
	  
	  
	  
	  
	  
}

















