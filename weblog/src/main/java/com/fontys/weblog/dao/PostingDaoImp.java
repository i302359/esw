/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fontys.weblog.dao;

import com.fontys.weblog.model.Comment;
import com.fontys.weblog.model.Posting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class PostingDaoImp implements PostingDao {

    private HashMap<Long, Posting> postings;
    private Long nextId;
    private Long nextIdC;

    public PostingDaoImp() {
        initWeblog();
    }

    public void initWeblog() {

        postings = new HashMap<Long, Posting>();

        postings.put(1L, new Posting(1L, "Title 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas in lacus nisl. Proin sit amet risus mauris. Phasellus lacus leo, ornare eget ultrices in, vehicula et purus. Integer posuere ac justo sed pulvinar. Quisque at lectus lobortis, commodo justo vitae, vestibulum enim. Sed vel sodales massa. Sed arcu quam, aliquet at aliquet ac, ultrices ac lectus. Duis interdum auctor magna et bibendum. Vivamus non nunc quis risus pharetra elementum et et dui. Etiam rutrum nunc nec tellus viverra, non sagittis nibh vestibulum. Integer at sollicitudin nibh. Vivamus placerat ligula sem, eget cursus neque maximus nec."));
        postings.put(2L, new Posting(2L, "Title 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas in lacus nisl. Proin sit amet risus mauris. Phasellus lacus leo, ornare eget ultrices in, vehicula et purus. Integer posuere ac justo sed pulvinar. Quisque at lectus lobortis, commodo justo vitae, vestibulum enim. Sed vel sodales massa. Sed arcu quam, aliquet at aliquet ac, ultrices ac lectus. Duis interdum auctor magna et bibendum. Vivamus non nunc quis risus pharetra elementum et et dui. Etiam rutrum nunc nec tellus viverra, non sagittis nibh vestibulum. Integer at sollicitudin nibh. Vivamus placerat ligula sem, eget cursus neque maximus nec."));
        postings.put(3L, new Posting(3L, "Title 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas in lacus nisl. Proin sit amet risus mauris. Phasellus lacus leo, ornare eget ultrices in, vehicula et purus. Integer posuere ac justo sed pulvinar. Quisque at lectus lobortis, commodo justo vitae, vestibulum enim. Sed vel sodales massa. Sed arcu quam, aliquet at aliquet ac, ultrices ac lectus. Duis interdum auctor magna et bibendum. Vivamus non nunc quis risus pharetra elementum et et dui. Etiam rutrum nunc nec tellus viverra, non sagittis nibh vestibulum. Integer at sollicitudin nibh. Vivamus placerat ligula sem, eget cursus neque maximus nec."));
        
        List<Comment> comments = new ArrayList<Comment>();
        comments.add(new Comment(1L, "Dit is de eerste opmerking"));
        comments.add(new Comment(2L, "Dit is de tweede opmerking. Met wat meer tekst. Enzovoort."));
        postings.get(1L).setComments(comments);
        
        nextId = 4L;
        nextIdC = 3L;
    }

    @Override
    public void create(Posting p) throws IllegalArgumentException {
        if (p == null) {
            throw new IllegalArgumentException("Posting is null");
        }
        p.setId(nextId);
        postings.put(nextId++, p);
    }

    @Override
    public List<Posting> findAll() {
        return new ArrayList(postings.values());
    }

     @Override
    public Posting find(Long id) throws IllegalArgumentException {
        if (!postings.containsKey(id)) {
            throw new IllegalArgumentException("Id no found" + id);
        }
        return postings.get(id);
    }

    @Override
    public void edit(Posting p) throws IllegalArgumentException{
        if (p == null) {
            throw new IllegalArgumentException("Posting is null");
        }
        for(Comment comment : p.getComments()){
            if(comment.getId() == null){
                comment.setId(nextIdC++);
            }
        }
    }
}
