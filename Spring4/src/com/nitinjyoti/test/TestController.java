package com.nitinjyoti.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@Autowired JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value="/test")
	public ModelAndView testingValue(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView("index.jsp");
		List<TestBean> list =  jdbcTemplate.query("Select * from temp", new RowMapper<TestBean>(){
			@Override
			public TestBean mapRow(ResultSet rs, int rsNum) throws SQLException {
				// TODO Auto-generated method stub
				TestBean objct = new TestBean();
				objct.setId(Integer.parseInt(rs.getString("id")));
				objct.setName(rs.getString("Name"));
				return objct;
			}
		});
		
		model.addObject("list", list);
		return model;
	}
	
}
