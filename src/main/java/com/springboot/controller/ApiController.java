package com.springboot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/get-apt")
public class ApiController {

    @GetMapping(value="/name")
    public String getName() {
        return "Flature";
    }
    @GetMapping(value="/variable1/{variable}")
    public String getVariable(@PathVariable String variable) {
        return variable;
    }
    @GetMapping(value="/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    @GetMapping(value="/request1")
    public String getRequestParam(@RequestParam String name,@RequestParam String email,
    @RequestParam String organization) {
        return name +  '|' + email +  '|' + organization;
    }

    @GetMapping(value="/request2/{organization}")
    public String getRequestParam2(@RequestParam String name,@RequestParam String email,
                                  @PathVariable("organization") String com) {
        return name +  '|' + email +  '|' + com;
    }
}
