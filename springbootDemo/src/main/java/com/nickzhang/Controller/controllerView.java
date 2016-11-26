package com.nickzhang.Controller;

import com.nickzhang.entity.UserInfo;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nickzhang on 2016/11/23.
 */
@Controller
@RequestMapping("/view")
public class controllerView {

    @RequestMapping("/index")
    public String index(Model model){

        UserInfo single = new UserInfo("nickzhang","123","shenzhen");

        List<UserInfo> people = new ArrayList<UserInfo>();
        UserInfo p1 = new UserInfo("nickzhang1","1231","shenzhen1");
        UserInfo p2 = new UserInfo("nickzhang2","1232","shenzhen2");
        UserInfo p3 = new UserInfo("nickzhang3","1233","shenzhen3");

        people.add(p1);
        people.add(p2);
        people.add(p3);

        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);

        return "index";

    }

}
