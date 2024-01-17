//package com.hms.hostel_managment_system.controllers;
//
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.hms.hostel_managment_system.entities.Post;
//import com.hms.hostel_managment_system.repositories.PostRepo;
//import com.hms.hostel_managment_system.services.PostService;
//import com.hms.hostel_managment_system.services.UserService;
//import com.razorpay.RazorpayClient;
//
//@RestController
//@RequestMapping("/api/v1/")
//public class PaymentController {
//	
//	@Value("{razorpay.api.key}")
//	String apiKey;
//	
//	@Value("{razorpay.api.secret}")
//	String apiSecret;
//	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private PostService postService;
//	
//	@Autowired
//	private PostRepo postRepo;
//	
//	@PostMapping("/payments/{postId}")
//	public ResponseEntity<PaymentLinkResponse> createPaymentLink(@PathVariable Integer postId,
//			@RequestHeader("Authorization")String jwt){
//		
//		Post post= postService.findPostById(postId);
//		
//	try {
//		
//		RazorpayClient razorpay= new RazorpayClient(apiKey, apiSecret);
//		JSONObject paymentLinkRequest=new JSONObject();
//		
//	}catch(Exception e) {
//		
//	}
//		
//		
//		
//		return null;
//		
//	}
//	
//
//}
