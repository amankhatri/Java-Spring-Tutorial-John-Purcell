package com.caveofprogramming.section6.lecture39.spring_tutorial_39;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component("offersDao")	
public class OffersDao {

/*
 * 4) Usually in JDBC we use select * from table where column = ? to dynimically insert values in
 * sql however, spring  lets you use named parameters. for that we will use named parameter jdbctemplate 
 * not just jdbcTemplate
 * 
 * 
 */
	private JdbcTemplate jdbc;
	public JdbcTemplate getJdbc() {
		return jdbc;
	}
	@Autowired
	public void setJdbc(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}

	public List<Offer> getOffers() {
		return jdbc.query("select * from Offers", new RowMapper() {
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
	
	private NamedParameterJdbcTemplate namedParamJdbc;

	public NamedParameterJdbcTemplate getNamedParamJdbc() {
		return namedParamJdbc;
	}
	@Autowired
	public void setNamedParamJdbc(DataSource dataSource) {
		this.namedParamJdbc = new NamedParameterJdbcTemplate(dataSource);
	}


	public List<Offer> getOffersfromNamedParamJdbc() {
		/*
		 * 5) to used named parameter we will use the call called MapSqlPArameterSource
		 * like so: 
		 */
		MapSqlParameterSource param = new MapSqlParameterSource("name", "sue");
		/*6) however if you got more than one parameter you can just add them as key value pair 
		 * like so: 
		 * param.add("key", "value");
		 * */
		
		return namedParamJdbc.query("select * from Offers where name =:name", param, new RowMapper() {
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
	
	/*
	 * 7) To delete rows we do : 
	 * */
	public boolean delete (int id) {
		MapSqlParameterSource paramMap = new MapSqlParameterSource("id", id);
		return namedParamJdbc.update("delete from Offers where id=:id", paramMap)==1;
	}
	
	/*
	 * 8) Getting placeholder values from bean. demoing it by creating create method
	 *  Since ID column is autoupdate we don't have to worry about id while creating objects in database
	 *  
	 *  We will use BeanPropertySqlParameterSource to replace place holders like :name from object properties by 
	 *  passing in the bean to the consturctor of BeanPropertySqlParameterSource. Just have to make sure the params :name, :text, :email 
	 *  matches the properties from offer obj
	 * */
	
	public boolean create(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return namedParamJdbc.update("insert into offers(name, text, email) values (:name, :text, :email)", params) ==1;
	}
	
	
	/*
	 * 9) Demonstrate using Batch in spring that means we want to execute many sql statements together 
	 *  This method is gonna return the array of int, where each element is the number of statements effected by the statement
	 * */
	public int[] createBatchUpdates(List<Offer> offers) {
		/*in order to execute several statements we need to be able to pass in array of  BeanPropertySqlParameterSource or MapSqlParameterSource or we can use
		 * SqlParameterSourceUtils.createBatch method which accepts a list
		 * It only works with namedParamJdbc
		 */
		SqlParameterSource[] sqlParamSrcArray= SqlParameterSourceUtils.createBatch(offers.toArray());
		return namedParamJdbc.batchUpdate("insert into offers(name, text, email) values (:name, :text, :email)", sqlParamSrcArray);
	}

	
	
	/*14) Although ID is auto increment in the db, we will add id, and write put zero as its value. This spring would
	 * make up an id 
	 * 15) go to app.java 
	 * 17) add @Transcational annotation on top of this method*/
	@Transactional
	public int[] createBatchUpdatesWithTransactions(List<Offer> offers) {
		SqlParameterSource[] sqlParamSrcArray= SqlParameterSourceUtils.createBatch(offers.toArray());
		return namedParamJdbc.batchUpdate("insert into offers(name, text, email) values (:name, :text, :email)", sqlParamSrcArray);
	}
}
