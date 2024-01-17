package com.hms.hostel_managment_system.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hms.hostel_managment_system.entities.Category;
import com.hms.hostel_managment_system.entities.Post;
import com.hms.hostel_managment_system.entities.User;
import com.hms.hostel_managment_system.exceptions.ResourceNotFoundException;
import com.hms.hostel_managment_system.payload.PostDto;
import com.hms.hostel_managment_system.payload.PostResponse;
import com.hms.hostel_managment_system.repositories.CategoryRepo;
import com.hms.hostel_managment_system.repositories.PostRepo;
import com.hms.hostel_managment_system.repositories.UserRepo;
import com.hms.hostel_managment_system.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
    @Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User id",userId));
		
		Category category= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","category id",categoryId));		
				
		Post post = this.modelMapper.map(postDto,Post.class);
		post.setImageName("default.png");
		post.setImageName1("default.png");
		post.setAddedDate( new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost=this.postRepo.save(post);
		
		
		
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		
		Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","post id",postId));
		
		post.setTitle(postDto.getTitle());
		post.setGenders(postDto.getGenders());
		post.setCasteCategory(postDto.getCasteCategory());
		post.setParents(postDto.getParents());
		post.setIncome(postDto.getIncome());
		post.setAns(postDto.getAns());
		post.setContent(postDto.getContent());
		post.setAddress(postDto.getAddress());
		post.setCurentinstitude(postDto.getCurentinstitude());
		post.setLastinstitude(postDto.getLastinstitude());
		post.setField1(postDto.getField1());
		post.setField2(postDto.getField2());
		post.setField3(postDto.getField3());
		post.setDateOfBirth(postDto.getDateOfBirth());
		post.setJoinDate(postDto.getJoinDate());
		post.setAge(postDto.getAge());
		post.setSubject(postDto.getSubject());
		post.setMarks(postDto.getMarks());;
		post.setImageName(postDto.getImageName());
		Post updatedPost=this.postRepo.save(post);
		return this.modelMapper.map(updatedPost,PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","post id",postId));
		this.postRepo.delete(post);
		
	}

	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy) {
		
		PageRequest p=PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
		
		Page<Post> pagePost =this.postRepo.findAll(p);
		
		List<Post> allPosts= pagePost.getContent();
		List<PostDto> postDtos =allPosts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		
		PostResponse postResponse=new PostResponse();
		
		postResponse.setContent(postDtos);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElement(pagePost.getTotalElements());
		postResponse.setTotalPage(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());
		
		return postResponse;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","post id",postId));
		
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","category",categoryId));
		List<Post> posts=this.postRepo.findByCategory(cat);
		
	List<PostDto> postDtos=	posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
	
		User user =this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","user",userId));
		List<Post> posts=this.postRepo.findByUser(user);
		
	List<PostDto> postDtos=	posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
		
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		List<Post> posts=this.postRepo.findByTitleContaining(keyword);
		List<PostDto>postDtos=posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		return postDtos;
	} 




}
