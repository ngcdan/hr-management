package com.jesse.training.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1.0.0/")
public class GroupController {


  @Autowired
  private com.jesse.training.spring.service.AccountGroupLogic logic;


}