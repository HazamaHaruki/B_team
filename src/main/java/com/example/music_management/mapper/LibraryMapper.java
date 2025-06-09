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

    @Insert("INSERT INTO libraries (title, artist, release_date) VALUES (#{title}, #{artist}, #{releaseDate})")
    @Options(useGeneratedKeys = true, keyProperty = "libraryId")
    void insertLibrary(Library library);

    @Select("SELECT * FROM libraries WHERE library_id = #{libraryId}")
    Library selectLibraryById(long libraryId);

    @Delete("DELETE FROM libraries WHERE library_id = #{libraryId}")
    void deleteLibraryById(long libraryId);

    @Update("UPDATE libraries SET title = #{title}, artist = #{artist}, release_date = #{releaseDate} WHERE album_id = #{albumId}")
    void updateLibrary(Library library);
    
    @Select("""
            SELECT libraries.library_id, libraries.title, artist, release_date, count(musics.music_id) AS music_count FROM albums
            LEFT OUTER JOIN musics ON libraries.library_id = musics.library_id
            GROUP BY libraries.library_id, libraries.title, artist, release_date
            """)
            
    public List<LibraryViewModel> selectAllLibrariesWithMusicCount();
}


