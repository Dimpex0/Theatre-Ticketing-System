package com.fmi.webdevelopment.theatremanagingsystem.controller;

import com.fmi.webdevelopment.theatremanagingsystem.dto.ShowResponse;
import com.fmi.webdevelopment.theatremanagingsystem.service.ShowService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
@Tag(name = "Shows", description = "CRUD operations for theatre shows")
public class ShowController {
    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }


    @GetMapping
    public List<ShowResponse> listShows() {
        return showService.getAllShows();
    }

    @GetMapping("/{id}")
    public ShowResponse getShowById(@PathVariable Long id) {
        return showService.getShowById(id);
    }
}
