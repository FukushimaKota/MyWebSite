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
import model.Thread;

/**
 * Servlet implementation class bordDeleteServlet
 */
@WebServlet("/bordDeleteServlet")
public class bordDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public bordDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// URLからGETパラメータとしてIDを受け取る
		//スレッドのid
		String id = request.getParameter("id");
		ThreadDao dao = new ThreadDao();
		Thread thread = dao.ThreadData(id);
		request.setAttribute("thread",thread);

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/BordDelete.jsp");
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
        String ok = request.getParameter("OK");
        String cancellation = request.getParameter("cancellation");

		ThreadDao a = new ThreadDao();
		CommentDao b= new CommentDao();

		//OKな時
		if(ok!=null) {

		a.Delete(id);
		b.CDelete(id);

		//全件表示
		ThreadDao threadDao = new ThreadDao();
		ArrayList<Thread> threadList = threadDao.AllThread();
		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("threadList", threadList);

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Top.jsp");
		dispatcher.forward(request, response);
		return ;
		}else if(cancellation!=null){

		//キャンセルした時
			//全件表示
			ThreadDao threadDao = new ThreadDao();
			ArrayList<Thread> threadList = threadDao.AllThread();
			// リクエストスコープにユーザ一覧情報をセット
			request.setAttribute("threadList", threadList);

		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("TopServlet");
		}
	}
}
