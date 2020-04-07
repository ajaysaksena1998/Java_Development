package upes.tech.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upes.tech.Repository.Repo;
import upes.tech.entity.Post;

@Service
public class PostService {

	@Autowired
	private Repo repo;

	public List<Post> getposts() {
		List<Post> list = new ArrayList<Post>();

		for (Post post : repo.findAll()) {
			list.add(post);
		}
		return list;
	}

	public Post getpost(int id) {
		return repo.findById(id).get();
	}

	public void addpost(Post post) {
		repo.save(post);

	}

	public void updatepost(Post post) {
		repo.save(post);
	}

	public void deletepost(int id) {

		repo.deleteById(id);

	}

}
