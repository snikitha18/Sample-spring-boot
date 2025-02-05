package repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.Student;
@Repository
public class StudentDB {
	@Autowired
	private JdbcTemplate jdbc;
	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	//List<Student> db = new ArrayList<>();
	public StudentDB() {
		
		
		
	}

	public List<Student> getAllStudents() {
		String sql="SELECT * FROM STUDENT";
		RowMapper<Student> row = new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student st = new Student();
				st.setId(rs.getInt("id"));
				st.setName(rs.getString("name"));
				st.setAge(rs.getInt("age"));
				return st;
			}
		};
		List<Student> result = jdbc.query(sql,row);
		
		return result;
	}

	public Student getStudent(int id) {
		String sql="SELECT ID,NAME,AGE FROM STUDENT WHERE ID = "+id;
		ResultSetExtractor<Student> rs = new ResultSetExtractor<Student>() {

			@Override
			public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
if(rs.next()) {
				Student st = new Student();
				st.setId(rs.getInt("id"));
				st.setName(rs.getString("NAME"));
				st.setAge(rs.getInt("AGE"));
				return st;}
return null;
			}
			
		};
		Student result = jdbc.query(sql, rs);
		
		return result;
	}

	public int updateStudent(Student st) {
		String sql="UPDATE STUDENT SET name = "+st.getName()+", age = "+st.getAge()+" WHERE ID = "+st.getId();
		return jdbc.update(sql);
		
		
	}

	public int addStudent(Student st) {
		String checkSql = "SELECT COUNT(*) FROM STUDENT WHERE ID = ?";
		int count = jdbc.queryForObject(checkSql, Integer.class, st.getId());

		if (count > 0) {
		    return 0;
		}
		else {
		String sql="INSERT INTO STUDENT ( NAME, AGE ,ID) VALUES(?,?,?)";
		return jdbc.update(sql,st.getName(),st.getAge(),st.getId());
		}
	
	}

	public int deleteStudent(int id) {
		String checkSql = "SELECT COUNT(*) FROM STUDENT WHERE ID = ?";
		int count = jdbc.queryForObject(checkSql, Integer.class, id);

		if (count == 0) {
		    return 0;
		}
		else {
		String sql="DELETE STUDENT WHERE ID = "+id;
		return jdbc.update(sql);
	}
	}

}
