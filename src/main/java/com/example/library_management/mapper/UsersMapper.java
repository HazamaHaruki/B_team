package com.example.library_management.mapper;

import com.example.library_management.entity.Users;
import com.example.library_management.viewmodel.LibraryViewModel;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface UsersMapper {
    
@Select("SELECT * FROM users")
List<Users> selectAllUsers();

    @Insert("INSERT INTO users (hito_id, user_name) VALUES (#{hitoId},#{userName}")
    @Options(useGeneratedKeys = true, keyProperty = "hitoId")
    void insertUsers(Users users);

    @Select("SELECT * FROM users WHERE hito_id = #{hitoId}")
    Users selectUsersById(int hitoId);

    @Delete("DELETE FROM users WHERE hito_id = #{hitoId}")
    void deleteUsersById(int hitoId);

    @Update("UPDATE users SET hito_id = #{hitoId}, user_name = #{userName} WHERE hito_id = #{hitoId}")
    void updateUsers(Users users);
    
@Select("""
            select book_id,book_name,shelf_id,users_id,user_name,rental_date,return_date from users
            join dates on users.id = dates.users_id
            join libraries on dates.book_id = libraries.id;
            """)
            public List<LibraryViewModel> selectAllLibrariesGraph();

    /*@Select("""
            SELECT libraries.bookId, libraries.title, artist, release_date, count(musics.music_id) AS music_count FROM albums
            LEFT OUTER JOIN musics ON libraries.library_id = musics.library_id
            GROUP BY libraries.library_id, libraries.title, artist, release_date
            """)
            
    public List<LibraryViewModel> selectAllLibrariesWithCount();*/
}