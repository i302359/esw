<%-- 
    Document   : myBlogAdm
    Created on : Aug 29, 2017, 8:08:54 PM
    Author     : sander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="/weblog/css/style.css">
        <title>My Blog</title>
    </head>
    <body>    
        <div id="nav">
            <div id="title">
                <h1>New Comment</h1>
            </div>
            <ul>
                <li><a href="/weblog">Home</a></li>
                <li><a href="/weblog/blog">View Blogs</a></li>
            </ul>
            <div class="clearer"></div>
        </div>
        <div id="content">
            <div id="post-input">
                <form id="post-input-form" action="/weblog/addComment" method="post">
                    <fieldset>
                        <legend>New Comment</legend>                       
                        <p><label class="field" for="content">Comment:</label><textarea name="content" rows="20"></textarea></p>
                        <p><input type="hidden" name="id" value="${id}"></p>
                        <p><input type="submit" value="Add Comment"></p>
                    </fieldset>                    
                </form>
            </div>
        </div>
    </body>
</html>
