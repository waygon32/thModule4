package com.company.controller;

import com.company.model.City;
import com.company.model.Country;
import com.company.service.ICityService;

import com.company.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.data.domain.Pageable;

import java.util.Optional;


@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    ICityService cityService;
    @Autowired
    ICountryService countryService;

    @ModelAttribute("listCountry")
    public Page<Country> listCountry(Pageable pageable) {
        return countryService.findAll(pageable);
    }

    @GetMapping("")
    ModelAndView getList(Pageable pageable) {
        Page<City> cities = cityService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    String getDetail(@PathVariable Long id, Model model) {
        Optional<City> city = cityService.findById(id);
        model.addAttribute("city", city.get());
        return "/city/detail";
    }

    @GetMapping("/create")
    ModelAndView createNewForm() {
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("cityForm", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    String createNewCity(@Validated @ModelAttribute("cityForm") City city, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/city/create";
        }
        cityService.save(city);
        return "redirect:/city/";
    }

    @GetMapping("/edit/{id}")
    ModelAndView editForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        Optional<City> city = cityService.findById(id);
        modelAndView.addObject("cityForm", city.get());
        return modelAndView;
    }

    @PostMapping("/edit")
    String editCity(@Validated @ModelAttribute("cityForm") City city, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/city/edit";
        }
        cityService.save(city);
        return "redirect:/city/";
    }

    @GetMapping("/delete/{id}")
    ModelAndView deleteForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/city/delete");
        Optional<City> city = cityService.findById(id);
        modelAndView.addObject("cityForm", city.get());
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    String deleteCity(@PathVariable Long id) {
        cityService.delete(id);
        return "redirect:/city/";
    }
}
