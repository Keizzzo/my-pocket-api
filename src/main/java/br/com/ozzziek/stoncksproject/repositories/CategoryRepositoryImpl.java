package br.com.ozzziek.stoncksproject.repositories;

import br.com.ozzziek.stoncksproject.entities.Category;
import br.com.ozzziek.stoncksproject.entities.SimpleRelease;
import br.com.ozzziek.stoncksproject.entities.enums.CategoryStatusEnum;
import br.com.ozzziek.stoncksproject.entities.enums.FinancialReleaseTypeEnum;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
@AllArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Override //REFACTOR - INTERFACE SEGREGATION BREAK
    public Long insert(Category obj) {
        return null;
    }

    @Override
    public void insertList(List<Category> categories) {
        jdbcTemplate.batchUpdate(
                "INSERT INTO CATEGORY (PERCENTUAL_SHARE, NAME, STATUS) VALUES(?,?,?)",
                new BatchPreparedStatementSetter() {

                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setDouble(1, categories.get(i).getPercentual());
                        ps.setString(2, categories.get(i).getName());
                        ps.setString(3, categories.get(i).getStatus());
                    }

                    public int getBatchSize() {
                        return categories.size();
                    }
                });
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public List<Category> list(String parameters) {
        String queryString = "SELECT ID, NAME, PERCENTUAL_SHARE, STATUS FROM CATEGORY ";

        if (parameters != null) {
            queryString += " WHERE STATUS = '" + parameters + "'";
        }

        return jdbcTemplate.query(queryString,
                (rs, row) -> new Category(Long.parseLong(rs.getString("ID")),
                        rs.getString("NAME"),
                        rs.getDouble("PERCENTUAL_SHARE"),
                        CategoryStatusEnum.valueOf(rs.getString("STATUS"))));
    }

    @Override
    public void update(Long id, Category obj) {

    }

    @Override
    public void remove(Long id) {

    }

}
