package xyz.morlotti.virtualbookcase.webapi.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.morlotti.virtualbookcase.webapi.beans.Genre;
import xyz.morlotti.virtualbookcase.webapi.beans.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>
{

}
