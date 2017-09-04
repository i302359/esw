package com.fontys.weblog.service;

import com.fontys.weblog.dao.PostingDao;
import com.fontys.weblog.dao.PostingDaoImp;
import com.fontys.weblog.model.Comment;
import com.fontys.weblog.model.Posting;
import java.util.List;

public class WebLogService {

    private PostingDao postingDao;

    public WebLogService() {
        postingDao = new PostingDaoImp();
    }

    public void addPosting(Posting p) throws IllegalArgumentException {
        postingDao.create(p);
    }

    public List<Posting> getPostings() {
        List<Posting> postings = postingDao.findAll();
        postings.sort(null);
        return postings;
    }
    
    public void addCommentToPosting(Long id, String content) throws IllegalArgumentException{
        Posting posting = postingDao.find(id);
        posting.getComments().add(new Comment(content));
        postingDao.edit(posting);
    }
}
