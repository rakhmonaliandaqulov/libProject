package org.example.repository;

import org.example.dto.LessonDto;
import org.example.dto.StudentBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LessonRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void create(LessonDto lessonDto) {
        String sql = "insert into lesson (name,surname,created_date) values ('%s','%s',now())";
        sql = String.format(sql, lessonDto.getName(), lessonDto.getSurname());
        int n = jdbcTemplate.update(sql);
        System.out.println(n);
    }
    public void updateLesson(Integer lessonId, LessonDto lessonDto) {
        String sql = "Update lesson set name='%s', surname='%s'  where id = %d";
        sql = String.format(sql, lessonDto.getName(), lessonDto.getSurname(), lessonId);
        int n = jdbcTemplate.update(sql);
        System.out.println(n);
    }
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from lesson", Integer.class);
    }
    public String nameOne() {
        return jdbcTemplate.queryForObject("select name from lesson limit 1", String.class);
    }
    public LessonDto getLessonById(Integer id) {
        String sql = "SELECT * FROM lesson Where id =" + id;
        LessonDto dto = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(LessonDto.class));
        return dto;
    }
    public List<String> getLessonNameList() {
        String sql = "SELECT name FROM lesson";
        List<String> list = jdbcTemplate.queryForList(sql, String.class);
        return list;
    }
    public List<LessonDto> getLessonList() {
        String sql = "SELECT * FROM lesson";
        List<LessonDto> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LessonDto.class));
        return list;
    }
    public LessonDto getLessonByIdTest(Integer id) {
        String sql = "SELECT * FROM lesson Where id =" + id;
        List<LessonDto> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LessonDto.class));
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    // sId sName bName
    // select s.id as sId, s.name as sName, b.name as bName
    // from student_book sb inner join student as s on s.id = sb.student_id
    // inner join book as b on b.id = sb.book_id


    public List<StudentBook> getStudentBookInfoList() {
        String sql = " select s.id as sId, s.name as sName, b.name as bName " +
                " from student_book sb inner join student as s on s.id = sb.student_id " +
                " inner join book as b on b.id = sb.book_id ";
        List<StudentBook> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentBook.class));
        return list;
    }
}
