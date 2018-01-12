package javaweb.project.poliakov.slava.controllers;

/**
 * Created by SiXFOiL on 10.08.2017.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/warplanes")
public class ContactsController {

    @RequestMapping(method = RequestMethod.GET)
    public String showPage(ModelMap model) {
        String object = "Show page of contacts";
        model.addAttribute("messageFromController", object);
        return "contacts";
    }

    @RequestMapping(method=RequestMethod.POST,params={})
    public String goHome(){
        return "view";
    }
}
