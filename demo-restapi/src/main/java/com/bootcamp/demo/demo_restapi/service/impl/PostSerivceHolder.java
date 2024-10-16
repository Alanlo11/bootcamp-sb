package com.bootcamp.demo.demo_restapi.service.impl;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_restapi.infra.Scheme;
import com.bootcamp.demo.demo_restapi.infra.UrlManager;
import com.bootcamp.demo.demo_restapi.entity.PostEntity;
import com.bootcamp.demo.demo_restapi.model.Post;
import com.bootcamp.demo.demo_restapi.model.mapper.Mapper;
import com.bootcamp.demo.demo_restapi.repository.PostRepository;
import com.bootcamp.demo.demo_restapi.service.PostService;

@Service
public class PostSerivceHolder implements PostService{

  @Value("${api.url.domain}")
  private String domain;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private Mapper mapper;

  @Override
  public Post[] getPosts(){
  String url = UrlManager.builder()
        .scheme(Scheme.HTTPS)
        .domain(this.domain)
        .endpoint("/posts")
        .build()
        .toString();

    System.out.println("url=" + url);

    Post[] posts = this.restTemplate.getForObject(url, Post[].class);

    if(postRepository.findAll().size() == 0){
    Arrays.asList(posts).stream()
    .forEach(post -> {
      PostEntity postsEntity = mapper.map(post);
      postRepository.save(postsEntity);
    });
  } else {
    System.out.println("Post Alredy have data");
  }
    return posts;
  }

  @Override
  public Post getPost(String id){
    return Arrays.stream(this.getPosts())
    .filter(post -> post.getId() == Integer.valueOf(id))
    .findFirst()
    .get();
  }

  // @Override
  // public String getPost(String id){
  //   Post[] temp = getPosts();
  //   try {
  //     for (Post p : temp) {
  //       if (Integer.valueOf(id).equals(p.getId())) {
  //         return p.toString();
  //       }
  //     }
  //   } catch (NumberFormatException e) {
  //     return "Give me a number";
  //   }
  //   return new Post().toString();
  // }

  // @Override
  // public List<PostDTO> getAllPostsByUserId(Long userID){

  // }

}
