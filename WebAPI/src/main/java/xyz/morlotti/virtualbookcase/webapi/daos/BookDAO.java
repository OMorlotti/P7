package xyz.morlotti.virtualbookcase.webapi.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.morlotti.virtualbookcase.webapi.beans.Book;
import xyz.morlotti.virtualbookcase.webapi.beans.Genre;

@Repository
public interface BookDAO extends JpaRepository<Book, Integer>
{

}