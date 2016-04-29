package ru.mitenev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mitenev.domain.User;
import ru.mitenev.services.UserService;
import ru.mitenev.vo.Users;

@Controller
@RequestMapping(value = "/user")
public class UserController {

//    final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/listData", method = RequestMethod.GET)
    @ResponseBody
    public Users listData {
        return new Users(userService.loadAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody User user, @PathVariable Long id) {
        userService.update(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        User user = userService.findUserById(id);
        userService.delete(user);
    }

}
