package com.example.banking.controller;

import com.example.banking.model.Members;
import com.example.banking.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PickListController {

    private final MemberRepository memberRepository;

    @Autowired
    public PickListController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/picklist")
    public String showPicklist(@RequestParam(name = "memberType", required = false) String memberType, Model model) {
        // If memberType is provided, filter members by type; otherwise, fetch all members
        List<Members> members;
        if (memberType != null && !memberType.isEmpty()) {
            members = memberRepository.findByType(memberType);
        } else {
            members = memberRepository.findAll();
        }

        model.addAttribute("members", members);
        return "picklist";
    }
}
