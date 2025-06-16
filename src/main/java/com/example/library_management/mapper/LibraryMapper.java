package com.example.library_management.mapper;

import com.example.library_management.entity.Library;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface LibraryMapper {
    
    @Select("SELECT * FROM libraries")
    List<Library> selectAllLibraries();

    @Insert("""
        INSERT INTO libraries (book_id, book_name, user_name, user_id, shelf_id, rental_date, return_date)
        VALUES (#{bookId}, #{bookName}, #{userName}, #{userId}, #{shelfId}, CURRENT_TIMESTAMP, DATEADD('DAY', 20, CURRENT_TIMESTAMP))
        """)
void insertLibrary(Library library);

    @Select("SELECT * FROM libraries WHERE album_id = #{albumId}")
    Library selectLibraryById(long albumId);

    @Delete("DELETE FROM libraries WHERE album_id = #{albumId}")
    void deleteLibraryById(long albumId);

    @Update("UPDATE libraries SET book_id = #{bookId}, book_name = #{bookName}, user_name = #{userName}, user_id = #{userId},rental_date = #{rentalDate},return_date = #{returnDate},shelf_id = #{shelfId} WHERE album_id = #{albumId}")
    void updateLibrary(Library library);
    
    @Select("SELECT * FROM libraries WHERE book_id = #{bookId}")
    List<Library> selectLibraries2ById(String bookId);
    
    @Update("UPDATE libraries SET return_check = #{returnCheck} WHERE album_id = #{albumId}")
    void updateReturnCheck(long albumId, boolean returnCheck);
}