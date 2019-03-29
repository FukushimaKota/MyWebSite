package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ThreadDao;
import dao.UserDao;
import model.Thread;
import model.User;

/**
 * Servlet implementation class writeServlet
 */
@WebServlet("/writeServlet")
public class writeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public writeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo") == null) {
		// ログイン画面サーブレットにリダイレクト
			response.sendRedirect("TopServlet");
			return;
		}

		ThreadDao threadDao = new ThreadDao();
		ArrayList<Thread> threadList = threadDao.AllThread();
		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("threadList", threadList);

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Write.jsp");
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
        String tittle = request.getParameter("tittle");
        String text = request.getParameter("text");

		ThreadDao thread = new ThreadDao();

		//空欄な場合
		boolean a2 = tittle.isEmpty();
		boolean a3 = text.isEmpty();

		if(a2||a3) {
			// URLからGETパラメータとしてIDを受け取る
			String id1 = request.getParameter("id");
			UserDao dao = new UserDao();
			User user1 = dao.UserData(id1);
			request.setAttribute("user",user1);

			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Write.jsp");
			dispatcher.forward(request, response);
			return ;
		}else {
		//データ更新
		thread.CreateThread(id,tittle,text);
		}


		ThreadDao threadDao = new ThreadDao();
		ArrayList<Thread> threadList = threadDao.AllThread();
		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("threadList", threadList);

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Top.jsp");
		dispatcher.forward(request, response);
		return;

	}

}
