package com.fzz.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
public class SessionController {

    @RequestMapping("uid")
    String uid(HttpSession httpSession) {
        UUID uuid = (UUID) httpSession.getAttribute("uid");
        if (uuid == null) {
            uuid=UUID.randomUUID();

        }
        httpSession.setAttribute("uid", uuid);
        return httpSession.getId();
    }

}
