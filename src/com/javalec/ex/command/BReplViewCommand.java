package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BDao;
import com.javalec.ex.dto.BDto;

public class BReplViewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bId=request.getParameter("bId");
		BDao dao= new BDao();
		BDto dto= dao.replay_view(bId);
		
		request.setAttribute("reply_view", dto);
	}

}
