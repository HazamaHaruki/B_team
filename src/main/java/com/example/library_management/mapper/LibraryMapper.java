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

    @Insert("INSERT INTO libraries (book_id, book_name, user_name,user_id,shelf_id,rental_date,return_date) VALUES (#{bookId}, #{bookName}, #{userName},#{userId},#{shelfId},#{rentalDate},#{returnId})")
    @Options(useGeneratedKeys = true, keyProperty = "libraryId")
    void insertLibrary(Library library);

    @Select("SELECT * FROM libraries WHERE library_id = #{libraryId}")
    Library selectLibraryById(long libraryId);

    @Delete("DELETE FROM libraries WHERE library_id = #{libraryId}")
    void deleteLibraryById(long libraryId);

    @Update("UPDATE libraries SET book_id = #{bookId}, book_name = #{bookName}, user_name = #{userName},user_id = #{userId},rental_date = #{rentalDate},return_date = #{returnId},shelf_id = #{shelfId}, WHERE library_id = #{libraryId}")
    void updateLibrary(Library library);
    
    /*@Select("""
            SELECT libraries.libraryId, libraries.title, artist, release_date, count(musics.music_id) AS music_count FROM albums
            LEFT OUTER JOIN musics ON libraries.library_id = musics.library_id
            GROUP BY libraries.library_id, libraries.title, artist, release_date
            """)
            
    public List<LibraryViewModel> selectAllLibrariesWithCount();*/
}