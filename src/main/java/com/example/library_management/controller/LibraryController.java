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

    /*@GetMapping("/{bookId}")
    public String library(@PathVariable String bookId, Model model) {
        Library library = libraryService.getAllLibraryById(bookId);
        model.addAttribute("library", library);
        return "library/library-detail";
    }*/
    
    @PostMapping("/{bookId}/delete")
    public String deleteLibrary(@PathVariable String bookId) {
        libraryService.deleteLibrary(bookId);
        return "redirect:/libraries";
    }

    @GetMapping("/{bookId}/edit")
    public String editLibrary(@PathVariable String bookId, Model model) {
        Library library = libraryService.getAllLibraryById(bookId);
        model.addAttribute("library", library);

        return "library/library-edit";
    }

    @PostMapping("/{bookId}/edit")
    public String updateLibrary(@PathVariable String bookId, Library library) {
        libraryService.updateLibrary(bookId, library);
        return "redirect:/libraries";
    }

    @GetMapping("/search")
    public String LibrarySearch(Model model) {
            LibraryForm library = new LibraryForm();
        /*List<Music> musics = musicService.getMusicsBybookId(bookId);*/
        model.addAttribute("library", library);
        /*model.addAttribute("musics", musics);*/
        return "library/library-search";
    }

    @PostMapping("/search")
    public String getLibraries2ById(String bookId) { // , Model model) {
        libraryService.getLibraries2ById(bookId);

        // List<Album> albums = albumService.getALLAlbums();
        // model.addAttribute("albums", albums);
        // return "album/album-list";
        return "redirect:/libraries";
    }

    /*@GetMapping("/{bookId}/musics/new")
    public String createMusicForm(@PathVariable String bookId, Model model) {
        MusicForm musicForm = new MusicForm();
        musicForm.setbookId(bookId);
        model.addAttribute("musicForm", musicForm);
        
        return "music/music-form";
    }

    @PostMapping("/{bookId}/musics/new")
    public String createMusic(@PathVariable String bookId, MusicForm musicForm) {
        musicService.createMusic(musicForm);
        return "redirect:/albums/" + bookId;
    }

    @PostMapping("/{bookId}/musics/{musicId}/delete")
    public String deleteMusic(@PathVariable String bookId, @PathVariable String musicId) {
        musicService.deleteMusic(musicId);
        return "redirect:/albums/" + bookId;
    }

    @GetMapping("/{bookId}/musics/{musicId}/edit")
    public String editMusic(@PathVariable String bookId, @PathVariable String musicId, Model model) {
        Music music = musicService.getMusicById(musicId);
        model.addAttribute("music", music);
        return "music/music-edit";
    }*/

    /*@PostMapping("/{bookId}/musics/{musicId}/edit")
    public String postMethodName(@PathVariable String bookId, @PathVariable String musicId, Music music) {
        musicService.updateMusic(musicId, music);
        return "redirect:/albums/" + bookId;
    }*/
}