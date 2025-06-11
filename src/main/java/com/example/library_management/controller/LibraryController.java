package com.example.library_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.library_management.entity.Library;
// import com.example.library_management.entity.Music;
import com.example.library_management.form.LibraryForm;
// import com.example.library_management.form.MusicForm;
import com.example.library_management.service.LibraryService;
//import com.example.library_management.service.MusicService;
import com.example.library_management.viewmodel.LibraryViewModel;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/libraries")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
        /*this.musicService = musicService;*/
    }
    
    @GetMapping
    public String libraries(Model model) {
        List<Library> libraries = libraryService.getAllLibraries();
        model.addAttribute("libraries", libraries);
        return "library/library-list";
    }

    @GetMapping("/new")
    public String libraryForm(Model model) {
        LibraryForm libraryForm = new LibraryForm();
        model.addAttribute("libraryForm", libraryForm);
        return "library/library-form";
    }

    @PostMapping("/new")
    public String createLibrary(LibraryForm libraryForm) { // , Model model) {
        libraryService.createLibrary(libraryForm);

        // List<Album> albums = albumService.getALLAlbums();
        // model.addAttribute("albums", albums);
        // return "album/album-list";
        return "redirect:/libraries";
    }

    @GetMapping("/{albumId}")
    public String library(@PathVariable long albumId, Model model) {
        Library library = libraryService.getAllLibraryById(albumId);
        /*List<Music> musics = musicService.getMusicsByAlbumId(albumId);*/
        model.addAttribute("library", library);
        /*model.addAttribute("musics", musics);*/
        return "library/library-detail";
    }
    
    @PostMapping("/{albumId}/delete")
    public String deleteLibrary(@PathVariable long albumId) {
        libraryService.deleteLibrary(albumId);
        return "redirect:/libraries";
    }

    @GetMapping("/{albumId}/edit")
    public String editLibrary(@PathVariable long albumId, Model model) {
        Library library = libraryService.getAllLibraryById(albumId);
        model.addAttribute("library", library);

        return "library/library-edit";
    }

    @PostMapping("/{albumId}/edit")
    public String updateLibrary(@PathVariable long albumId, Library library) {
        libraryService.updateLibrary(albumId, library);
        return "redirect:/libraries";
    }

    /*@GetMapping("/{albumId}/musics/new")
    public String createMusicForm(@PathVariable long albumId, Model model) {
        MusicForm musicForm = new MusicForm();
        musicForm.setAlbumId(albumId);
        model.addAttribute("musicForm", musicForm);
        
        return "music/music-form";
    }

    @PostMapping("/{albumId}/musics/new")
    public String createMusic(@PathVariable long albumId, MusicForm musicForm) {
        musicService.createMusic(musicForm);
        return "redirect:/albums/" + albumId;
    }

    @PostMapping("/{albumId}/musics/{musicId}/delete")
    public String deleteMusic(@PathVariable long albumId, @PathVariable long musicId) {
        musicService.deleteMusic(musicId);
        return "redirect:/albums/" + albumId;
    }

    @GetMapping("/{albumId}/musics/{musicId}/edit")
    public String editMusic(@PathVariable long albumId, @PathVariable long musicId, Model model) {
        Music music = musicService.getMusicById(musicId);
        model.addAttribute("music", music);
        return "music/music-edit";
    }*/

    /*@PostMapping("/{albumId}/musics/{musicId}/edit")
    public String postMethodName(@PathVariable long albumId, @PathVariable long musicId, Music music) {
        musicService.updateMusic(musicId, music);
        return "redirect:/albums/" + albumId;
    }*/
}