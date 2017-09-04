/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fontys.weblog.dao;

import com.fontys.weblog.model.Posting;
import java.util.List;

public interface PostingDao {

    void create(Posting p) throws IllegalArgumentException;

    List<Posting> findAll();

    Posting find(Long id) throws IllegalArgumentException;
    
    void edit(Posting p) throws IllegalArgumentException;
}
