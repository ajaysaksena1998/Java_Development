package upes.tech.Repository;

import org.springframework.data.repository.CrudRepository;

import upes.tech.entity.Post;

public interface Repo extends CrudRepository<Post, Integer>  {

}
