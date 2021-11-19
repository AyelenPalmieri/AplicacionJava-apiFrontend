package com.example.apiFrontend.controllers;

import com.example.apiFrontend.models.Address;
import com.example.apiFrontend.models.Role;
import com.example.apiFrontend.models.User;
import com.example.apiFrontend.models.UserForm;
import com.example.apiFrontend.services.HttpClientAsynchronous;
import com.example.apiFrontend.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ApiIgnore
@Controller
public class UsersController {

    private final UserService userService;
    private final HttpClientAsynchronous httpClientAsynchronous;

    @Autowired
    public UsersController(HttpClientAsynchronous httpClientAsynchronous , UserService userService){
        this.httpClientAsynchronous = httpClientAsynchronous;
        this.userService = userService;
    }


    @GetMapping("/base")
    public String Test(){
        return "base";
    }

    @GetMapping("users/getAll")
    public String userList(Model model) throws Exception {
        try {
            String urlUsers = "user/getAll";

            JSONObject resposeUser = this.httpClientAsynchronous.GET(urlUsers);
            String responseString = resposeUser.get("data").toString();

            String urlRole = "role/getAll";
            JSONObject responseRole = this.httpClientAsynchronous.GET(urlRole);
            String responseStringRole = responseRole.get("data").toString();

            Type listType = new TypeToken<ArrayList<User>>() {}.getType();
            ArrayList<User> users = new Gson().fromJson(responseString, listType);

            Type listTypeRole = new TypeToken<ArrayList<Role>>() {}.getType();
            ArrayList<Role> roles = new Gson().fromJson(responseStringRole, listTypeRole);

            ArrayList<User> usersWithRoleName = new ArrayList<>();
            for (User aUser : users) {
                for (Role aRole : roles){
                    if (aUser.get_idRole().equals(aRole.get_id())) {
                        User aux = aUser;
                        aux.setRoleLabel(aRole.getRoleName());
                        usersWithRoleName.add(aux);
                    }
                }
            }

//            System.out.println(usersWithRoleName);

//            System.out.println(users);
            model.addAttribute("titulo","Lista de Usuarios");
            model.addAttribute("users", usersWithRoleName);

            return "users";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "users";
    }

    @RequestMapping("users/getOne")
    @ResponseBody
    public User getOne(String Id) throws Exception {
        var temp = this.userService.findById(Id);
        System.out.println(temp);
        return temp;
    }

    @RequestMapping(value="users/update/{id}/{idRole}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(@PathVariable String id, @PathVariable String idRole, UserForm model) throws Exception{

        if(model.getId() == null){
            return "redirect:/users/getAll";
        }

        ModelMapper modelMapper = new ModelMapper();
        Address adress = modelMapper.map(model, Address.class);
        User user = modelMapper.map(model,User.class);
        user.set_id(id);
        user.set_idRole(idRole);
        user.setAddress(adress);

        var temp = this.userService.update(user);
        System.out.println(temp);
        return "redirect:/users/getAll";
    }
}