<%-- 
    Document   : myBlog
    Created on : Aug 29, 2017, 8:09:08 PM
    Author     : sander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>My Blog</title>
    </head>
    <body>       
        <div id="nav">
            <div id="title">
                <h1>My Blog</h1>
            </div>
            <ul>
                <li><a href="/weblog">Home</a></li>
                <li><a href="/weblog/addBlog">New Blog</a></li>
            </ul>
            <div class="clearer"></div>
        </div>
        <div id="content">
            <div id="left-content">
                <div id="left-content-item">
                    <h2>About</h2>
                    <p>Blaat</p>
                </div>
                <div id="left-content-item">                  
                    <h2>Pictures</h2>
                    <p>Blaat</p>
                </div>
                <div id="left-content-item">                   
                    <h2>My Friends</h2>
                    <ul>
                        <li>Friend 1</li>
                        <li>Friend 2</li>
                    </ul>
                </div>
            </div>
            <div id="right-content">
                <div id="posts">
                    <c:forEach items="${postings}" var="posting">
                        <div id="post">
                            <div id="post-title"><c:out value="${posting.title}"/></div>
                            <div id="post-content"><c:out value="${posting.content}"/></div>                           
                            <div id="post-date"><c:out value="${posting.date}"/></div>                           
                            <div class="clearer"></div>                                                     
                        </div>
                        <div id="comments">
                            <div id="post-comment"><a href="/weblog/addComment?id=${posting.id}">Add comment</a></div>
                            <c:forEach items="${posting.comments}" var="comment">
                                <div id="comment"><c:out value="${comment.content}"/></div>
                            </c:forEach>     
                        </div>
                    </c:forEach>
                </div>                
            </div>          
            <div class="clearer"></div>
        </div>  
    </body>
</html>
