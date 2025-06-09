package com.example.library_management.service;

import org.springframework.stereotype.Service;

import com.example.library_management.entity.Album;
import com.example.library_management.form.AlbumForm;
import com.example.library_management.repository.AlbumRepository;
import com.example.library_management.viewmodel.LibraryViewModel;

import java.util.List;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;
    
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getALLAlbums() {
        return albumRepository.getAllAlbums();
    }

    public void createAlbum(AlbumForm albumForm) {
        Album album = new Album();
        album.setTitle(albumForm.getTitle());
        album.setArtist(albumForm.getArtist());
        album.setReleaseDate(albumForm.getReleaseDate());
        albumRepository.insertAlbum(album);
    }

    public Album getAllAlbumById(long albumId) {
        return albumRepository.getAlbumById(albumId);
    }

    public void deleteAlbum(long albumId) {
        albumRepository.deleteAlbum(albumId);
    }

    public void updateAlbum(long albumId, Album album) {
        if (albumId != album.getAlbumId()) {
            throw new IllegalArgumentException("Album ID does not match");
        }
        albumRepository.updateAlbum(album);
    }

    public List<LibraryViewModel> getAllAlbumsWithMusicCount() {
        return albumRepository.getAllAlbumsWithMusicCount();
    }
}