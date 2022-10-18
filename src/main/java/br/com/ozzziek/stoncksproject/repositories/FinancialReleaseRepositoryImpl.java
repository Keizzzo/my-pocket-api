package br.com.ozzziek.stoncksproject.repositories;

import br.com.ozzziek.stoncksproject.entities.Category;
import br.com.ozzziek.stoncksproject.entities.FinancialRelease;
import br.com.ozzziek.stoncksproject.entities.SimpleRelease;
import br.com.ozzziek.stoncksproject.entities.enums.CategoryStatusEnum;
import br.com.ozzziek.stoncksproject.entities.enums.FinancialReleaseTypeEnum;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.Objects;

@Repository
@AllArgsConstructor
public class FinancialReleaseRepositoryImpl implements FinancialReleaseRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Long insert(FinancialRelease financialRelease) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO FINANCIAL_RELEASE(DATE, DESCRIPTION, VALUE, CATEGORY_ID, FINANCIAL_RELEASE_TYPE) VALUES(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setDate(1, Date.valueOf(financialRelease.getDate()));
            ps.setString(2, financialRelease.getDescription());
            ps.setDouble(3, financialRelease.getValue());
            ps.setLong(4, financialRelease.getCategory().getId());
            ps.setString(5, financialRelease.getFinancialReleaseTypeEnum());

            return ps;

        }, keyHolder);

        return Long.parseLong(Objects.requireNonNull(keyHolder.getKey()).toString());
    }

    @Override
    public FinancialRelease findById(Long id) {

        var test = jdbcTemplate.queryForObject("SELECT ID, DATE, DESCRIPTION, VALUE, CATEGORY_ID, FINANCIAL_RELEASE_TYPE FROM FINANCIAL_RELEASE WHERE ID = ?",
                new Object[]{id},
                (rs, row) -> new SimpleRelease(rs.getLong("ID"),
                        rs.getDate("DATE").toLocalDate(),
                        rs.getString("DESCRIPTION"),
                        rs.getDouble("VALUE"),
                        new Category(rs.getLong("CATEGORY_ID")),
                        FinancialReleaseTypeEnum.valueOf(rs.getString("FINANCIAL_RELEASE_TYPE"))));

        return test;
    }

    @Override
    public List<FinancialRelease> list(String parameters) {

        String queryString = "SELECT fr.ID, fr.DATE, fr.DESCRIPTION, fr.VALUE, fr.CATEGORY_ID, c.name, c.percentual_share, c.status, fr.FINANCIAL_RELEASE_TYPE FROM FINANCIAL_RELEASE fr inner join category c on fr.category_id = c.id ";

        if (parameters != null) {
            queryString += " WHERE MONTH(DATE) = " + parameters;
        }

        return jdbcTemplate.query(queryString,
                (rs, row) -> new SimpleRelease(Long.parseLong(rs.getString("fr.ID")),
                        rs.getDate("fr.DATE").toLocalDate(),
                        rs.getString("fr.DESCRIPTION"),
                        rs.getDouble("fr.VALUE"),
                        new Category(rs.getLong("fr.CATEGORY_ID"), rs.getString("c.name"), rs.getDouble("c.percentual_share"), CategoryStatusEnum.valueOf(rs.getString("c.status"))),
                        FinancialReleaseTypeEnum.valueOf(rs.getString("fr.FINANCIAL_RELEASE_TYPE"))));

    }

    @Override
    public void update(Long id, FinancialRelease financialRelease) {

        Object[] params = {financialRelease.getDate(),
                financialRelease.getDescription(),
                financialRelease.getValue(),
                financialRelease.getCategory().getId(),
                financialRelease.getFinancialReleaseTypeEnum(),
                id};

        int[] types = {Types.DATE, Types.VARCHAR, Types.DOUBLE, Types.BIGINT, Types.VARCHAR, Types.BIGINT};

        jdbcTemplate.update("UPDATE FINANCIAL_RELEASE SET DATE = ?, DESCRIPTION = ?, VALUE = ?, CATEGORY_ID = ?, FINANCIAL_RELEASE_TYPE = ? WHERE ID = ?",
                params,
                types);

    }

    @Override
//    @Modifying
//    @Transactional
    public void remove(Long id) {
//        var release = findById(id);
//
//        if (release == null) {
//            throw new RuntimeException("Object not found");
//        }

        jdbcTemplate.update("DELETE FROM FINANCIAL_RELEASE WHERE ID = ?", id);

    }
}
