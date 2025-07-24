package com.peng.controller;

import com.peng.service.PengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/22 14:11
 * @Desc:
 */
@RestController
public class PengController {
    @Autowired
    private PengService pengService;

    @GetMapping("/test")
    public String test(@RequestParam("name") String name, Model model) {
        System.out.println(name);
        model.addAttribute("name", name);
        return pengService.test();
    }



	@RequestMapping(method = RequestMethod.POST, path = "/upload")
	public long test1(@RequestPart("file") MultipartFile file,@RequestPart("name") String name) {
		System.out.println(file.getSize());
		System.out.println(file.getOriginalFilename());
		return file.getSize();
	}
}
