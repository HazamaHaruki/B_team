/*
package com.example.library_management.service;

import org.springframework.stereotype.Service;

import com.example.library_management.entity.Music;
import com.example.library_management.form.MusicForm;
import com.example.library_management.repository.MusicRepository;

import java.util.List;

@Service
public class MusicService {
    private final MusicRepository musicRepository;

    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public List<Music> getMusicsByAlbumId(long albumId) {
        return musicRepository.getMusicsByAlbumId(albumId);
    }

    public void createMusic(MusicForm musicForm) {
        Music music = new Music();
        music.setTitle(musicForm.getTitle());
        music.setDuration(musicForm.getDuration());
        music.setAlbumId(musicForm.getAlbumId());

        musicRepository.insertMusic(music);
    }
    
    public void deleteMusic(long musicId) {
        musicRepository.deleteMusicById(musicId);
    }

    public Music getMusicById(long musicId) {
        return musicRepository.selectMusicById(musicId);
    }

    public void updateMusic(long musicId, Music music) {
        if (musicId != music.getMusicId()) {
            throw new IllegalArgumentException("Music ID does not match");
        }

        musicRepository.updateMusic(music);
        
    }

}

*/