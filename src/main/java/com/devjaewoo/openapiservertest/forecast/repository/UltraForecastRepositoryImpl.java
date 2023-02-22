package com.devjaewoo.openapiservertest.forecast.repository;

import com.devjaewoo.openapiservertest.forecast.dto.UltraForecastSearch2;
import com.devjaewoo.openapiservertest.forecast.entity.UltraForecast;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.devjaewoo.openapiservertest.forecast.entity.QUltraForecast.ultraForecast;

@Repository
@RequiredArgsConstructor
public class UltraForecastRepositoryImpl implements UltraForecastRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<UltraForecast> search(UltraForecastSearch2 search) {
        PageRequest pageable = PageRequest.of(search.page(), search.size());

        List<UltraForecast> content = queryFactory
                .selectFrom(ultraForecast)
                .where(
                        baseDateEq(search.baseDate()),
                        baseTimeEq(search.baseTime()),
                        fcstDateEq(search.fcstDate()),
                        fcstTimeEq(search.fcstTime()),
                        fcstValueEq(search.fcstValue()),
                        categoryEq(search.category()),
                        nxEq(search.nx()),
                        nyEq(search.ny())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(ultraForecast.count())
                .from(ultraForecast)
                .where(
                        baseDateEq(search.baseDate()),
                        baseTimeEq(search.baseTime()),
                        fcstDateEq(search.fcstDate()),
                        fcstTimeEq(search.fcstTime()),
                        fcstValueEq(search.fcstValue()),
                        categoryEq(search.category()),
                        nxEq(search.nx()),
                        nyEq(search.ny())
                );

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    private BooleanExpression baseDateEq(String baseDate) {
        return (baseDate != null) ? ultraForecast.baseDate.eq(baseDate) : null;
    }

    private BooleanExpression baseTimeEq(String baseTime) {
        return (baseTime != null) ? ultraForecast.baseTime.eq(baseTime) : null;
    }

    private BooleanExpression fcstDateEq(String fcstDate) {
        return (fcstDate != null) ? ultraForecast.fcstDate.eq(fcstDate) : null;
    }

    private BooleanExpression fcstTimeEq(String fcstTime) {
        return (fcstTime != null) ? ultraForecast.fcstTime.eq(fcstTime) : null;
    }

    private BooleanExpression fcstValueEq(String fcstValue) {
        return (fcstValue != null) ? ultraForecast.fcstValue.eq(fcstValue) : null;
    }

    private BooleanExpression categoryEq(String category) {
        return (category != null) ? ultraForecast.category.eq(category) : null;
    }

    private BooleanExpression nxEq(Integer nx) {
        return (nx != null) ? ultraForecast.nx.eq(nx) : null;
    }

    private BooleanExpression nyEq(Integer ny) {
        return (ny != null) ? ultraForecast.ny.eq(ny) : null;
    }
}
