package com.example.library_management.mapper;

import com.example.library_management.entity.Libraries;

import com.example.library_management.viewmodel.LibraryViewModel;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface librariesMapper {

    @Select("SELECT * FROM libraries")
    List<Libraries> selectAllLibraries();

    @Insert("INSERT INTO libraries (libraries_id, book_name,shelf_id) VALUES (#{librariesId},#{bookName},#{shelfId}")
    @Options(useGeneratedKeys = true, keyProperty = "librariesId")
    void insertLibrary(Libraries library);

    @Select("SELECT * FROM libraries WHERE libraries_id = #{librariesId}")
    Libraries selectLibraryById(int librariesId);

    @Delete("DELETE FROM libraries WHERE libraries_id = #{librariesId}")
    void deleteLibraryById(int librariesId);

    @Update("UPDATE libraries SET libraries_id = #{librariesId}, book_name = #{bookName},shelf_id = #{shelfId} WHERE libraries_id = #{librariesId}")
    void updateLibrary(Libraries library);

}
