package ru.lenivtsev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.lenivtsev.model.User;
import ru.lenivtsev.repositories.UserRepository;

import java.net.Socket;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("users");
        mv.addObject("users", userRepository.findAll());
        return mv;
    }

    @GetMapping("/remove/{id}")
    public String deleteByUserId(@PathVariable("id") long id) {
        userRepository.delete(id);
        return "redirect:/users";
    }


    @GetMapping("/new")
    public ModelAndView addNewUser(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("formUser");
        mv.addObject("user", new User());
        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView form(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("formUser");
        mv.addObject("user", userRepository.findById(id));
        return mv;
    }

    @PostMapping
    public String saveUser(@ModelAttribute User user){
        userRepository.saveOrUpdate(user);
        return "redirect:/users";
    }

}
