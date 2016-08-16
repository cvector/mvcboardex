package com.javalec.ex.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.command.BCommand;
import com.javalec.ex.command.BContentCommand;
import com.javalec.ex.command.BDeleteCommand;
import com.javalec.ex.command.BListCommand;
import com.javalec.ex.command.BModifyCommand;
import com.javalec.ex.command.BWriteCommand;
import com.javalec.ex.command.BReplViewCommand;
import com.javalec.ex.command.BReplyCommand;

@WebServlet("*.do")
public class BFrontcontroller extends HttpServlet {
	public  BFrontcontroller(){
		super();
	}
	protected void  doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}
	protected void  doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}
	protected void  actionDo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		System.out.println("actionDo");
		
		request.setCharacterEncoding("euc-kr");
		
		String viewPage=null;
		BCommand command =null;
		
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		
		if(com.equals("/wirte_view.do")){
			viewPage="wirte_view.jsp";
		}else if(com.equals("/wirte.do")){
			command=new BWriteCommand();
			command.execute(request, response);
			viewPage="list.do";
		}else if(com.equals("/list.do")){
			command=new BListCommand();
			command.execute(request, response);
			viewPage="list.jsp";
		}else if(com.equals("/content_view.do")){
			command=new BContentCommand();
			command.execute(request, response);
			viewPage="content_view.jsp";
		}else if(com.equals("/modify.do")){
			command=new BModifyCommand();
			command.execute(request, response);
			viewPage="list.do";
		}else if(com.equals("/delete.do")){
			command=new BDeleteCommand();
			command.execute(request, response);
			viewPage="list.do";
		}else if(com.equals("/reply_view.do")){
			command=new BReplViewCommand();
			command.execute(request, response);
			viewPage="reply_view.jsp";
		}else if(com.equals("/reply.do")){
			command=new BReplyCommand();
			command.execute(request, response);
			viewPage="list.do";
	}
		RequestDispatcher dispatcher=request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

}
}
