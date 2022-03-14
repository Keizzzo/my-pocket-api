package br.com.ozzziek.stoncksproject.repositories;

import br.com.ozzziek.stoncksproject.entities.Category;
import br.com.ozzziek.stoncksproject.entities.FinancialRelease;
import br.com.ozzziek.stoncksproject.entities.SimpleRelease;
import br.com.ozzziek.stoncksproject.entities.enums.FinancialReleaseTypeEnum;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

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

            PreparedStatement ps = connection.prepareStatement("INSERT INTO FINANCIAL_RELEASE(DATE, DESCRIPTION, VALUE, CATEGORY, FINANCIALRELEASETYPE) VALUES(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setDate(1, Date.valueOf(financialRelease.getDate()));
            ps.setString(2, financialRelease.getDescription());
            ps.setDouble(3, financialRelease.getValue());
            ps.setString(4, financialRelease.getCategory().getName());
            ps.setString(5, financialRelease.getFinancialReleaseTypeEnum().toString());

            return ps;

        }, keyHolder);

        return Long.parseLong(Objects.requireNonNull(keyHolder.getKey()).toString());
    }

    @Override
    public FinancialRelease findById(Long id) {

        return jdbcTemplate.queryForObject("SELECT ID, DATE, DESCRIPTION, VALUE, CATEGORY, FINANCIALRELEASETYPE FROM FINANCIAL_RELEASE WHERE ID = ?",
                new Object[]{id},
                (rs, row) -> new SimpleRelease(rs.getLong("ID"),
                        rs.getDate("DATE").toLocalDate(),
                        rs.getString("DESCRIPTION"),
                        rs.getDouble("VALUE"),
                        new Category(rs.getString("CATEGORY"), 0.0),
                        FinancialReleaseTypeEnum.valueOf(rs.getString("FINANCIALRELEASETYPE"))));
    }

    @Override
    public List<FinancialRelease> list(String parameters) {

        String queryString = "SELECT ID, DATE, DESCRIPTION, VALUE, CATEGORY, FINANCIALRELEASETYPE FROM FINANCIAL_RELEASE ";

        return jdbcTemplate.query(queryString,
                (rs, row) -> new SimpleRelease(Long.parseLong(rs.getString("ID")),
                        rs.getDate("DATE").toLocalDate(),
                        rs.getString("DESCRIPTION"),
                        rs.getDouble("VALUE"),
                        new Category(rs.getString("CATEGORY"), 0.0),
                        FinancialReleaseTypeEnum.valueOf(rs.getString("FINANCIALRELEASETYPE"))));

    }

    @Override
    public void update(Long id, FinancialRelease financialRelease) {

        var release = findById(financialRelease.getCode());

        if (release == null) {
            throw new RuntimeException("Object not found :/");
        }

//        jdbcTemplate.update("UPDATE FINANCIAL_RELEASE SET DATE = ?, DESCRIPTION = ?, VALUES = ?, CATEGORY = ?, FINANCIALRELEASETYPE = ? WHERE ID = ?",
//                financialRelease.getDate() != null ? financialRelease.getDate() : release.getDate(),
//                financialRelease.getDescription() != null ? financialRelease.getDescription() : release.getDescription(),
//                financialRelease.getValue() != null ? financialRelease.getValue() : release.getValue(),
//                financialRelease.getCategory() != null ? financialRelease.getCategory().getName() : release.getCategory().getName(),
//                financialRelease.getFinancialReleaseTypeEnum() != null ? financialRelease.getFinancialReleaseTypeEnum().name() : release.getFinancialReleaseTypeEnum().name(),
//                id);

        Object[] params = { financialRelease.getDate() != null ? financialRelease.getDate() : release.getDate(),
                financialRelease.getDescription() != null ? financialRelease.getDescription() : release.getDescription(),
                financialRelease.getValue() != null ? financialRelease.getValue() : release.getValue(),
                financialRelease.getCategory() != null ? financialRelease.getCategory().getName() : release.getCategory().getName(),
                financialRelease.getFinancialReleaseTypeEnum() != null ? financialRelease.getFinancialReleaseTypeEnum().name() : release.getFinancialReleaseTypeEnum().name(),
                id};

        int[] types = {Types.DATE, Types.VARCHAR, Types.DOUBLE, Types.VARCHAR, Types.VARCHAR, Types.INTEGER};

        jdbcTemplate.update("UPDATE FINANCIAL_RELEASE SET DATE = ?, DESCRIPTION = ?, VALUES = ?, CATEGORY = ?, FINANCIALRELEASETYPE = ? WHERE ID = ?",
                params,
                types);

    }

    @Override
    public void remove(Long id) {
        var release = findById(id);

        if (release == null) {
            throw new RuntimeException("Object not found");
        }

        jdbcTemplate.update("DELETE FROM FINANCIAL_RELEASE WHERE ID = ?", id);
        
    }
}
