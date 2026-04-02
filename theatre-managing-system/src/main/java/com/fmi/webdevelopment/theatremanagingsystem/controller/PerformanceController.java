package com.fmi.webdevelopment.theatremanagingsystem.controller;

import com.fmi.webdevelopment.theatremanagingsystem.dto.PerformanceResponse;
import com.fmi.webdevelopment.theatremanagingsystem.service.PerformanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/performances")
@Tag(name = "Performances", description = "Query scheduled performances")
public class PerformanceController {

    private final PerformanceService performanceService;

    public PerformanceController(PerformanceService performanceService) {
        this.performanceService = performanceService;
    }

    @GetMapping
    @Operation(summary = "List performances", description = "List all performances, optionally filtered by show ID")
    @ApiResponse(responseCode = "200", description = "List of performances")
    @ApiResponse(responseCode = "404", description = "Show not found (when showId is provided but invalid)")
    public List<PerformanceResponse> listPerformances(
            @Parameter(description = "Filter by show ID")
            @RequestParam(required = false) Long showId) {
        return showId != null
                ? performanceService.findPerformancesByShow(showId)
                : performanceService.getAllPerformances();
    }
}
