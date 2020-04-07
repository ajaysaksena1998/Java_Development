package upes.tech.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import upes.tech.entity.Post;
import upes.tech.service.PostService;

@RestController
public class PostController {

	@Autowired
	PostService service;

	@RequestMapping("/posts")
	public List<Post> getposts() {
		return service.getposts();
	}

	@RequestMapping("/post/{id}")
	public Post getpost(@PathVariable int id) {
		return service.getpost(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/posts")
	public void addpost(@RequestBody Post post) {
		service.addpost(post);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/posts")
	public void updatepost(@RequestBody Post post) {
		service.updatepost(post);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/post/{id}")
	public void deletepost(@PathVariable int id) {
		service.deletepost(id);
	}

}
