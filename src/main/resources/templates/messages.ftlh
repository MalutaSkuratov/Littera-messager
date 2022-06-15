<!DOCTYPE html>
<html>
<head>
    <title>Littera</title>
</head>
<body>
<h3>Littera Messager</h3><hr>

<#list messages as message>
    <p>
        <b>${message.title}</b> :
        ${message.message} |
        <i>${message.author}</i>
        <form action="/message/delete/${message.id}" method="post">
    <button type="submit">Delete</button>
</form>
    </p>
    <#else>
    <h4>Nothing messages</h4>
</#list>
<hr>
<h3>Add message</h3>
<form action="/messages/new" method="post">
    Title: <input type="text" name="title"><br><br>
    Message: <input type="text" name="message"><br><br>
    Author: <input type="text" name="author"><br><br>
    <button type="submit">Create</button>
</form>
</body>
</html>