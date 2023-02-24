package com.devjaewoo.openapiservertest.forecast.repository;

import com.devjaewoo.openapiservertest.RepositoryTest;
import com.devjaewoo.openapiservertest.forecast.dto.UltraForecastSearch2;
import com.devjaewoo.openapiservertest.forecast.entity.UltraForecast;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import static org.assertj.core.api.Assertions.*;

@RepositoryTest
class UltraForecastRepositoryTest {

    @Autowired UltraForecastRepository ultraForecastRepository;

    @Nested
    @DisplayName("검색")
    class Search {

        @Test
        @DisplayName("page")
        public void page() {

            // given
            UltraForecast ultraForecast1 = UltraForecast.create("", "", "", "", "", "", 1, 2);
            UltraForecast ultraForecast2 = UltraForecast.create("", "", "", "", "", "", 1, 2);
            UltraForecast ultraForecast3 = UltraForecast.create("", "", "", "", "", "", 1, 2);
            UltraForecast ultraForecast4 = UltraForecast.create("", "", "", "", "", "", 1, 2);
            UltraForecast ultraForecast5 = UltraForecast.create("", "", "", "", "", "", 1, 2);

            ultraForecastRepository.save(ultraForecast1);
            ultraForecastRepository.save(ultraForecast2);
            ultraForecastRepository.save(ultraForecast3);
            ultraForecastRepository.save(ultraForecast4);
            ultraForecastRepository.save(ultraForecast5);

            UltraForecastSearch2 search1 = new UltraForecastSearch2(1, 2, null, null, null, null, null, null, null, null);
            UltraForecastSearch2 search2 = new UltraForecastSearch2(2, 3, null, null, null, null, null, null, null, null);

            // when
            Page<UltraForecast> result1 = ultraForecastRepository.search(search1);
            Page<UltraForecast> result2 = ultraForecastRepository.search(search2);

            // then
            assertThat(result1).contains(ultraForecast1, ultraForecast2);
            assertThat(result2).contains(ultraForecast4, ultraForecast5);
        }

        @Test
        @DisplayName("all")
        public void all() {

            // given
            UltraForecast ultraForecast1 = UltraForecast.create("", "", "", "", "", "", 1, 2);
            UltraForecast ultraForecast2 = UltraForecast.create("", "", "", "", "", "", 1, 2);

            ultraForecastRepository.save(ultraForecast1);
            ultraForecastRepository.save(ultraForecast2);

            UltraForecastSearch2 searchAll = new UltraForecastSearch2(1, 2, null, null, null, null, null, null, null, null);

            // when
            Page<UltraForecast> resultAll = ultraForecastRepository.search(searchAll);

            // then
            assertThat(resultAll).contains(ultraForecast1, ultraForecast2);
        }

        @Test
        @DisplayName("baseDate")
        public void baseDate() {

            // given
            String baseDate1 = "20220224";
            String baseDate2 = "20220225";

            UltraForecast ultraForecast1 = UltraForecast.create(baseDate1, "", "", "", "", "", 1, 2);
            UltraForecast ultraForecast2 = UltraForecast.create(baseDate2, "", "", "", "", "", 1, 2);

            ultraForecastRepository.save(ultraForecast1);
            ultraForecastRepository.save(ultraForecast2);

            UltraForecastSearch2 search1 = new UltraForecastSearch2(1, 2, baseDate1, null, null, null, null, null, null, null);
            UltraForecastSearch2 search2 = new UltraForecastSearch2(1, 2, baseDate2, null, null, null, null, null, null, null);
            UltraForecastSearch2 searchAll = new UltraForecastSearch2(1, 2, null, null, null, null, null, null, null, null);
            UltraForecastSearch2 searchNone = new UltraForecastSearch2(1, 2, "", null, null, null, null, null, null, null);

            // when
            Page<UltraForecast> result1 = ultraForecastRepository.search(search1);
            Page<UltraForecast> result2 = ultraForecastRepository.search(search2);
            Page<UltraForecast> resultAll = ultraForecastRepository.search(searchAll);
            Page<UltraForecast> resultNone = ultraForecastRepository.search(searchNone);

            // then
            assertThat(result1).contains(ultraForecast1);
            assertThat(result2).contains(ultraForecast2);
            assertThat(resultAll).contains(ultraForecast1, ultraForecast2);
            assertThat(resultNone).isEmpty();
        }

        @Test
        @DisplayName("baseTime")
        public void baseTime() {

            // given
            String baseTime1 = "1200";
            String baseTime2 = "1300";

            UltraForecast ultraForecast1 = UltraForecast.create("", baseTime1, "", "", "", "", 1, 2);
            UltraForecast ultraForecast2 = UltraForecast.create("", baseTime2, "", "", "", "", 1, 2);

            ultraForecastRepository.save(ultraForecast1);
            ultraForecastRepository.save(ultraForecast2);

            UltraForecastSearch2 search1 = new UltraForecastSearch2(1, 2, null, baseTime1, null, null, null, null, null, null);
            UltraForecastSearch2 search2 = new UltraForecastSearch2(1, 2, null, baseTime2, null, null, null, null, null, null);
            UltraForecastSearch2 searchAll = new UltraForecastSearch2(1, 2, null, null, null, null, null, null, null, null);
            UltraForecastSearch2 searchNone = new UltraForecastSearch2(1, 2, null, "", null, null, null, null, null, null);

            // when
            Page<UltraForecast> result1 = ultraForecastRepository.search(search1);
            Page<UltraForecast> result2 = ultraForecastRepository.search(search2);
            Page<UltraForecast> resultAll = ultraForecastRepository.search(searchAll);
            Page<UltraForecast> resultNone = ultraForecastRepository.search(searchNone);

            // then
            assertThat(result1).contains(ultraForecast1);
            assertThat(result2).contains(ultraForecast2);
            assertThat(resultAll).contains(ultraForecast1, ultraForecast2);
            assertThat(resultNone).isEmpty();
        }

        @Test
        @DisplayName("category")
        public void category() {

            // given
            String category1 = "AAA";
            String category2 = "BBB";

            UltraForecast ultraForecast1 = UltraForecast.create("", "", category1, "", "", "", 1, 2);
            UltraForecast ultraForecast2 = UltraForecast.create("", "", category2, "", "", "", 1, 2);

            ultraForecastRepository.save(ultraForecast1);
            ultraForecastRepository.save(ultraForecast2);

            UltraForecastSearch2 search1 = new UltraForecastSearch2(1, 2, null, null, category1, null, null, null, null, null);
            UltraForecastSearch2 search2 = new UltraForecastSearch2(1, 2, null, null, category2, null, null, null, null, null);
            UltraForecastSearch2 searchAll = new UltraForecastSearch2(1, 2, null, null, null, null, null, null, null, null);
            UltraForecastSearch2 searchNone = new UltraForecastSearch2(1, 2, null, null, "", null, null, null, null, null);

            // when
            Page<UltraForecast> result1 = ultraForecastRepository.search(search1);
            Page<UltraForecast> result2 = ultraForecastRepository.search(search2);
            Page<UltraForecast> resultAll = ultraForecastRepository.search(searchAll);
            Page<UltraForecast> resultNone = ultraForecastRepository.search(searchNone);

            // then
            assertThat(result1).contains(ultraForecast1);
            assertThat(result2).contains(ultraForecast2);
            assertThat(resultAll).contains(ultraForecast1, ultraForecast2);
            assertThat(resultNone).isEmpty();
        }

        @Test
        @DisplayName("fcstDate")
        public void fcstDate() {

            // given
            String fcstDate1 = "20220224";
            String fcstDate2 = "20220225";

            UltraForecast ultraForecast1 = UltraForecast.create("", "", "", fcstDate1, "", "", 1, 2);
            UltraForecast ultraForecast2 = UltraForecast.create("", "", "", fcstDate2, "", "", 1, 2);

            ultraForecastRepository.save(ultraForecast1);
            ultraForecastRepository.save(ultraForecast2);

            UltraForecastSearch2 search1 = new UltraForecastSearch2(1, 2, null, null, null, fcstDate1, null, null, null, null);
            UltraForecastSearch2 search2 = new UltraForecastSearch2(1, 2, null, null, null, fcstDate2, null, null, null, null);
            UltraForecastSearch2 searchAll = new UltraForecastSearch2(1, 2, null, null, null, null, null, null, null, null);
            UltraForecastSearch2 searchNone = new UltraForecastSearch2(1, 2, null, null, null, "", null, null, null, null);

            // when
            Page<UltraForecast> result1 = ultraForecastRepository.search(search1);
            Page<UltraForecast> result2 = ultraForecastRepository.search(search2);
            Page<UltraForecast> resultAll = ultraForecastRepository.search(searchAll);
            Page<UltraForecast> resultNone = ultraForecastRepository.search(searchNone);

            // then
            assertThat(result1).contains(ultraForecast1);
            assertThat(result2).contains(ultraForecast2);
            assertThat(resultAll).contains(ultraForecast1, ultraForecast2);
            assertThat(resultNone).isEmpty();
        }

        @Test
        @DisplayName("fcstTime")
        public void fcstTime() {

            // given
            String fcstTime1 = "20220224";
            String fcstTime2 = "20220225";

            UltraForecast ultraForecast1 = UltraForecast.create("", "", "", "", fcstTime1, "", 1, 2);
            UltraForecast ultraForecast2 = UltraForecast.create("", "", "", "", fcstTime2, "", 1, 2);

            ultraForecastRepository.save(ultraForecast1);
            ultraForecastRepository.save(ultraForecast2);

            UltraForecastSearch2 search1 = new UltraForecastSearch2(1, 2, null, null, null, null, fcstTime1, null, null, null);
            UltraForecastSearch2 search2 = new UltraForecastSearch2(1, 2, null, null, null, null, fcstTime2, null, null, null);
            UltraForecastSearch2 searchNone = new UltraForecastSearch2(1, 2, null, null, null, null, "", null, null, null);

            // when
            Page<UltraForecast> result1 = ultraForecastRepository.search(search1);
            Page<UltraForecast> result2 = ultraForecastRepository.search(search2);
            Page<UltraForecast> resultNone = ultraForecastRepository.search(searchNone);

            // then
            assertThat(result1).contains(ultraForecast1);
            assertThat(result2).contains(ultraForecast2);
            assertThat(resultNone).isEmpty();
        }

        @Test
        @DisplayName("fcstValue")
        public void fcstValue() {

            // given
            String fcstValue1 = "20220224";
            String fcstValue2 = "20220225";

            UltraForecast ultraForecast1 = UltraForecast.create("", "", "", "", "", fcstValue1, 1, 2);
            UltraForecast ultraForecast2 = UltraForecast.create("", "", "", "", "", fcstValue2, 1, 2);

            ultraForecastRepository.save(ultraForecast1);
            ultraForecastRepository.save(ultraForecast2);

            UltraForecastSearch2 search1 = new UltraForecastSearch2(1, 2, null, null, null, null, null, fcstValue1, null, null);
            UltraForecastSearch2 search2 = new UltraForecastSearch2(1, 2, null, null, null, null, null, fcstValue2, null, null);
            UltraForecastSearch2 searchNone = new UltraForecastSearch2(1, 2, null, null, null, null, null, "", null, null);

            // when
            Page<UltraForecast> result1 = ultraForecastRepository.search(search1);
            Page<UltraForecast> result2 = ultraForecastRepository.search(search2);
            Page<UltraForecast> resultNone = ultraForecastRepository.search(searchNone);

            // then
            assertThat(result1).contains(ultraForecast1);
            assertThat(result2).contains(ultraForecast2);
            assertThat(resultNone).isEmpty();
        }

        @Test
        @DisplayName("nx")
        public void nx() {

            // given
            int nx1 = 1;
            int nx2 = 2;

            UltraForecast ultraForecast1 = UltraForecast.create("", "", "", "", "", "", nx1, 2);
            UltraForecast ultraForecast2 = UltraForecast.create("", "", "", "", "", "", nx2, 2);

            ultraForecastRepository.save(ultraForecast1);
            ultraForecastRepository.save(ultraForecast2);

            UltraForecastSearch2 search1 = new UltraForecastSearch2(1, 2, null, null, null, null, null, null, nx1, null);
            UltraForecastSearch2 search2 = new UltraForecastSearch2(1, 2, null, null, null, null, null, null, nx2, null);
            UltraForecastSearch2 searchNone = new UltraForecastSearch2(1, 2, null, null, null, null, null, null, 999, null);

            // when
            Page<UltraForecast> result1 = ultraForecastRepository.search(search1);
            Page<UltraForecast> result2 = ultraForecastRepository.search(search2);
            Page<UltraForecast> resultNone = ultraForecastRepository.search(searchNone);

            // then
            assertThat(result1).contains(ultraForecast1);
            assertThat(result2).contains(ultraForecast2);
            assertThat(resultNone).isEmpty();
        }

        @Test
        @DisplayName("ny")
        public void ny() {

            // given
            int ny1 = 1;
            int ny2 = 2;

            UltraForecast ultraForecast1 = UltraForecast.create("", "", "", "", "", "", 1, ny1);
            UltraForecast ultraForecast2 = UltraForecast.create("", "", "", "", "", "", 2, ny2);

            ultraForecastRepository.save(ultraForecast1);
            ultraForecastRepository.save(ultraForecast2);

            UltraForecastSearch2 search1 = new UltraForecastSearch2(1, 2, null, null, null, null, null, null, null, ny1);
            UltraForecastSearch2 search2 = new UltraForecastSearch2(1, 2, null, null, null, null, null, null, null, ny2);
            UltraForecastSearch2 searchNone = new UltraForecastSearch2(1, 2, null, null, null, null, null, null, null, 999);

            // when
            Page<UltraForecast> result1 = ultraForecastRepository.search(search1);
            Page<UltraForecast> result2 = ultraForecastRepository.search(search2);
            Page<UltraForecast> resultNone = ultraForecastRepository.search(searchNone);

            // then
            assertThat(result1).contains(ultraForecast1);
            assertThat(result2).contains(ultraForecast2);
            assertThat(resultNone).isEmpty();
        }
    }
}