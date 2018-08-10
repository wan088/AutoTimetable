package kr.or.connect.mvcexam.dao;

import static kr.or.connect.mvcexam.dao.GangDaoSqls.SELECT_BY_NAME;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.mvcexam.dto.gang;

@Repository
public class GangDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<gang> rowMapper = BeanPropertyRowMapper.newInstance(gang.class);
	
	public GangDao(DataSource datasource) {
		this.jdbc = new NamedParameterJdbcTemplate(datasource);
	}
	
	public List<gang> selectByName(String name) {
		try {
			Map<String, ?> params = Collections.singletonMap("name", "%"+name+"%");
			return jdbc.query(SELECT_BY_NAME, params, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	
}
