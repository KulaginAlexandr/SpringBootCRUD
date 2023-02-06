package com.kulagin.SpringBootCRUD.controller;

import com.kulagin.SpringBootCRUD.model.User;
import com.kulagin.SpringBootCRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getUserListPage(ModelMap model) {
        model.addAttribute("list", userService.getUserList());
        return "users";
    }

    @GetMapping(value = "delete")
    public String deleteUserById(@RequestParam(value = "id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping(value = "newUser")
    public String getUserAddForm(ModelMap model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @GetMapping(value = "edit")
    public String getUserEditForm(@RequestParam(value = "id", required = false) Integer id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PostMapping("save")
    public String saveUser(@ModelAttribute("user") User user) {
        System.out.println(user.toString());
        userService.saveUser(user);
        return "redirect:/";
    }

    @PatchMapping("update")
    public String updateUser(@ModelAttribute("user") User user) {
        System.out.println(user.toString());
        userService.saveUser(user);
        return "redirect:/";
    }


}
