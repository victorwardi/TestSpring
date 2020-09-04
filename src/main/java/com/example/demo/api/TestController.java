package com.example.demo.api;

import javax.validation.Valid;
import java.util.List;


import com.example.demo.service.TestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tests")
public class TestController {

	private TestService test;

	//merge two lists received in json  with the path test
	//	input1: [2, 4, 6, 8]
	//	input2: [3, 7]
	//	Final:  [2, 3, 4, 7, 6, 8]
	@PostMapping
    public List<Integer> setConfig(@RequestBody @Valid ObjectLists req) {
		return TestService.mergeLists(req.getList1(),req.getList2());
    }

  
  

}