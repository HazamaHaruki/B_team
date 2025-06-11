package com.example.library_management.mapper;

import com.example.library_management.entity.Library;
import com.example.library_management.viewmodel.LibraryViewModel;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface LibraryMapper {
    
    @Select("""
        select * from users
            join dates on users.id = dates.user_id
            join libraries on dates.book_id = libraries.id;
                        """)
    List<Library> selectAllLibraries();

    @Insert("INSERT INTO users (hito_id,libraries_id,book_id, book_name, user_name,user_id,shelf_id,rental_date,return_date) VALUES (#{hitoId},#{librariesId},#{bookId}, #{bookName}, #{userName},#{userId},#{shelfId},#{rentalDate},#{returnDate})")
    @Options(useGeneratedKeys = true, keyProperty = "bookId")
    void insertLibrary(Library library);

    @Select("SELECT * FROM users WHERE book_id = #{bookId}")
    Library selectLibraryById(int bookId);

    @Delete("DELETE FROM users WHERE book_id = #{bookId}")
    void deleteLibraryById(int bookId);

    @Update("UPDATE users SET book_id = #{bookId}, book_name = #{bookName}, user_name = #{userName}, user_id = #{userId},rental_date = #{rentalDate},return_date = #{returnDate},shelf_id = #{shelfId} WHERE book_id = #{bookId}")
    void updateLibrary(Library library);
    
@Select("""
            select book_id,book_name,shelf_id,user_id,user_name,rental_date,return_date from users
            join dates on users.id = dates.user_id
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