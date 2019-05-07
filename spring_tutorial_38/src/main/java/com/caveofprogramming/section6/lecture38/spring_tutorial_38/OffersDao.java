package com.caveofprogramming.section6.lecture38.spring_tutorial_38;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.caveofprogramming.section6.lecture38.spring_tutorial_38.Offer;
@Component("offersDao")	
public class OffersDao {

	/*
	 * 3) Add JdbcTemplateClass which would facilitate the use of JDBC
	 * 4) Look into beans.xml
	*/
	
	/*
	 * 12) added private variable for JdbcTemplate Class & add getters and setters for it
	 */
	private JdbcTemplate jdbc;
	
	public JdbcTemplate getJdbc() {
		return jdbc;
	}
	/*
	 * 13) pass and autowire datasource to set JdbcTemplate
	 * */
	@Autowired
	public void setJdbc(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}
	
	
	/*
	 *  14) used configured jdbc template to execute a query.
	 *  
	 *  Note RowMapper is a generic so we have to specify to store offer
	 */
	public List<Offer> getOffers() {
		return jdbc.query("select * from Offers", new RowMapper() {
			/*purpose of this mapRow method is to map each offer to its object that is Offer.java*/
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				 offer.setId(rs.getInt("id"));
				 offer.setName(rs.getString("name"));
				 offer.setEmail(rs.getString("email"));
				 offer.setText(rs.getString("text"));
				return offer;
				
			}
			
		});
	}
}
