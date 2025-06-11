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
    
    @Select("SELECT * FROM libraries")
    List<Library> selectAllLibraries();

    @Insert("INSERT INTO libraries (book_id, book_name, user_name,user_id,shelf_id,rental_date,return_date) VALUES (#{bookId}, #{bookName}, #{userName},#{userId},#{shelfId},#{rentalDate},#{returnDate})")
    @Options(useGeneratedKeys = true, keyProperty = "albumId")
    void insertLibrary(Library library);

    @Select("SELECT * FROM libraries WHERE album_id = #{albumId}")
    Library selectLibraryById(long albumId);

    @Delete("DELETE FROM libraries WHERE album_id = #{albumId}")
    void deleteLibraryById(long albumId);

    @Update("UPDATE libraries SET book_id = #{bookId}, book_name = #{bookName}, user_name = #{userName},user_id = #{userId},rental_date = #{rentalDate},return_date = #{returnDate},shelf_id = #{shelfId} WHERE album_id = #{albumId}")
    void updateLibrary(Library library);
    
    /*@Select("""
            SELECT libraries.bookId, libraries.title, artist, release_date, count(musics.music_id) AS music_count FROM albums
            LEFT OUTER JOIN musics ON libraries.library_id = musics.library_id
            GROUP BY libraries.library_id, libraries.title, artist, release_date
            """)
            
    public List<LibraryViewModel> selectAllLibrariesWithCount();*/
}