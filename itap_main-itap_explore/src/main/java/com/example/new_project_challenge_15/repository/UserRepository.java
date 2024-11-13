package com.example.new_project_challenge_15.repository;

import com.example.new_project_challenge_15.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
  User getById(Long id);
  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
  @Query(value = "select * FROM users where id > 10 and id < 16 limit 3", nativeQuery = true)

  List<User> get3users1();
  @Query(value = "select * FROM users where id < 70 and id > 65 limit 3", nativeQuery = true)

  List<User> get3users2();

  @Query(value = "select * FROM users where username like ?1 limit 1", nativeQuery = true)
  User findByUsernameTwo(String username);

  @Query(value = "update users set password = ?1 where id = ?2", nativeQuery = true)
  void changePassword(String password, Long id);
  @Query(value= "select * from users where username like '%' || ?1 || '%' or email like '%' || ?1 || '%'", nativeQuery = true)
  List<User> getUsersByLike(String value);
  @Modifying
  @Query(value = "update user_roles set role_id = ?1 where user_id = ?2", nativeQuery = true)
  void updateRole(Integer role, Integer user);

  @Query(value = "select r.name from roles r where r.id = (select role_id from user_roles where user_id = (select id from users where username = ?1))", nativeQuery = true)
  String getRoleById(String username);

  @Query(value = "select count(*) from users", nativeQuery = true)
  Integer getUserNum();
}
