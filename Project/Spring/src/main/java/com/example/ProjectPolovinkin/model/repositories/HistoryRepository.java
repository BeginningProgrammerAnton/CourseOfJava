package com.example.ProjectPolovinkin.model.repositories;

import com.example.ProjectPolovinkin.model.Book;
import com.example.ProjectPolovinkin.model.history.History;
import com.example.ProjectPolovinkin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository  extends JpaRepository<History,Long> {

    List<History> findByBookIdAndUserIdOrderByIdDesc(Book bookId, User userId);
    @Query(
            value = "select book_id as city_count from history group by book_id order by city_count",
            nativeQuery = true)
    List<Long> findPopular();

    @Query(
            value = "select count(id) as city_count from history group by book_id order by city_count desc",
            nativeQuery = true)
    List<Integer> findCount();

    @Query(
            value = "select user_id as city_count from history group by user_id order by city_count",
            nativeQuery = true)
    List<Long> popularUsers();

    @Query(
            value = "select count(id) as city_count from history group by user_id order by city_count desc",
            nativeQuery = true)
    List<Integer> popularUsersCount();

    @Query(
            value = "select * from history where data_comeback_true is NULL and data_comeback < now() or data_comeback_true > data_comeback",
            nativeQuery = true)
    List<History> getCredit();

    @Query(
            value = "select count(id) from history where data_comeback_true is NULL and data_comeback < now() or data_comeback_true > data_comeback\n" +
                    "group by user_id order by count(id) desc",
            nativeQuery = true)
    List<Integer> getCountUsersCredit();

    @Query(
            value = "select user_id from history where data_comeback_true is NULL and data_comeback < now() or data_comeback_true > data_comeback\n" +
                    "group by user_id order by count(id) desc",
            nativeQuery = true)
    List<Long> getUsersCredit();

    @Query(
            value = "select book_id from history where (data_comeback_true is NULL and data_comeback < now() or data_comeback_true > data_comeback) and user_id = :id",
            nativeQuery = true)
    List<Long> getCreditBooksUser(@Param("id") Long id);

}
