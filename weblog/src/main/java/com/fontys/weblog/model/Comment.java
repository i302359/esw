/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fontys.weblog.model;

import java.util.Date;

public class Comment implements Comparable<Comment>{

    private Long id;
    private String content;
    private Date date;
    
    public Comment(String content) {
        this.content = content;
        this.date = new Date();
    }
    
    public Comment(Long id, String content) {
        this.id = id;
        this.content = content;
        this.date = new Date();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int compareTo(Comment other) {
        return other.getDate().compareTo(this.getDate());
    }
}
