package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import dao.ThreadDao;
import dao.UserDao;
import model.Comment;
import model.Thread;
import model.User;

/**
 * Servlet implementation class bordServlet
 */
@WebServlet("/bordServlet")
public class bordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public bordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		// URLからGETパラメータとしてIDを受け取る
		//threadId
		String id = request.getParameter("id");


		//スレッド内容の表示
		ThreadDao dao = new ThreadDao();
		Thread thread = dao.ThreadData(id);
		request.setAttribute("thread",thread);

		ThreadDao threadDao = new ThreadDao();
		ArrayList<Thread> threadList = threadDao.AllThread();
		request.setAttribute("threadList", threadList);

		//コメント表示
		CommentDao commentDao = new CommentDao();
		ArrayList<Comment> commentList = commentDao.AllComment(id);
		request.setAttribute("commentList", commentList);


		//スレッドの投稿者を表示
		UserDao userdao = new UserDao();
		User user = userdao.UserData(id);
		request.setAttribute("user",user);

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Bord.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータの文字コードを指定
        request.setCharacterEncoding("UTF-8");

		//リクエストパラメーターの取得
        String id = request.getParameter("id");
        String id2 = request.getParameter("id2");
        String commentt = request.getParameter("comment");

		CommentDao comment = new CommentDao();

		//空欄な場合
		boolean a3 = commentt.isEmpty();

		if(a3) {
			//表示
			ThreadDao dao = new ThreadDao();
			Thread thread = dao.ThreadData(id2);
			request.setAttribute("thread",thread);

			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Bord.jsp");
			dispatcher.forward(request, response);
			return ;
		}else {
		//データ更新
		comment.CreateComment(id,id2,commentt);
		}

		CommentDao commentDao = new CommentDao();
		ArrayList<Comment> commentList = commentDao.AllComment(id2);
		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("commentList", commentList);

		ThreadDao dao = new ThreadDao();
		Thread thread = dao.ThreadData(id2);
		request.setAttribute("thread",thread);

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Bord.jsp");
		dispatcher.forward(request, response);
	}

}
