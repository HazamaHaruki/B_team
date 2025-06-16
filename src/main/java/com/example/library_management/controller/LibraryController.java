package com.example.library_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.library_management.entity.Library;
// import com.example.library_management.entity.Music;
import com.example.library_management.form.LibraryForm;
// import com.example.library_management.form.MusicForm;
import com.example.library_management.service.LibraryService;
//import com.example.library_management.service.MusicService;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/libraries")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
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
    public String createLibrary(LibraryForm libraryForm) {
        libraryService.createLibrary(libraryForm);
        return "redirect:/libraries";
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

    @GetMapping("/search")
    public String LibrarySearch(String bookId, Model model) {
        List<Library> libraries = libraryService.getLibraries2ById(bookId);
        model.addAttribute("libraries", libraries);
        return "library/library-search";
    }

    @PostMapping("/search")
    public String getLibraries2ById(String bookId) {
        libraryService.getLibraries2ById(bookId);
        return "redirect:/libraries";
    }

    @PostMapping("/{albumId}/return")
    public String returnCheck(@PathVariable long albumId, boolean returnCheck) {
        libraryService.updateReturnCheck(albumId, returnCheck);
        return "redirect:/libraries";
    }
    @GetMapping("/returnCheck")
	public String LibraryreturnCheck(boolean returnCheck, Model model) {
		List<Library> libraries = libraryService.getLibraryReturned(returnCheck);
		model.addAttribute("libraries", libraries);
		return "library/library-returnCheck";
	}

    @PostMapping("/returnCheck")
    public String getLibraryReturned(boolean returnCheck) {
        libraryService.getLibraryReturned(returnCheck);
        return "redirect:/libraries";
    }
}