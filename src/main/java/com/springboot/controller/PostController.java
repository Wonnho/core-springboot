package com.springboot.controller;

import com.springboot.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @RequestMapping(value="/domain", method= RequestMethod.POST)
    public String  post(){
        return "Hello POST API";

    }

    @PostMapping(value="/member")
    public String postMember(@RequestBody Map<String,Object> postData) {
      StringBuilder  sb=new StringBuilder();

     postData.entrySet().forEach(map -> {
         sb.append(map.getKey() + ":" + map.getValue());
     });
      return  sb.toString();
    }


    @PostMapping(value="/member2")
    public String postMember2(@RequestBody MemberDto memberDto) {

        return  memberDto.toString();
    }

    @PutMapping(value="/member3")
    public String putMember3(@RequestBody Map<String,String> putData) {

      StringBuilder  sb=new StringBuilder();
      putData.entrySet().forEach(map->{
          sb.append(map.getKey() + " : " + map.getValue() + "\n");
      });
       return  sb.toString();

    }
    @PutMapping(value="/member4")
    public String putMember4(@RequestBody MemberDto memberDto) {
        return  memberDto.toString();
    }


    @PutMapping(value="/member5")
    public MemberDto putMember6(@RequestBody MemberDto memberDto) {
        return   memberDto;
    }

    @PutMapping(value="/member6")
    public ResponseEntity<MemberDto> putMember5(@RequestBody MemberDto memberDto) {
        return   ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);

    }

}
