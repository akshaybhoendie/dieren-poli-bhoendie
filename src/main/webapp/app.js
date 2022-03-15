clearInputFields();
loadBookList();
// findGebruikerById();

function loadBookList() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let bookDataList = JSON.parse(this.responseText);
            let bookList = ' <ul class="w3-ul w3-card-4"> ';

            bookDataList.reverse();

            for (let index = 0; index < bookDataList.length; index++) {
                bookList +=
                    ' <li class="w3-bar"> ' +

                    ' <button id= ' + bookDataList[index].id + ' onclick="editBook(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Edit</button> ' +

                    ' <button id=' + bookDataList[index].id + ' onclick="removeBook(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Remove</button> ' +


                    ' <img src="images/icons8-reading-48.png" class="w3-bar-item w3-circle w3-hide-small" style="width:85px"> ' +
                    ' <div class="w3-bar-item"> ' +
                    ' <span class="w3-large"> Title: ' +  bookDataList[index].name  + ' </span><br> ' +
                    ' <span> Author: ' +  bookDataList[index].author  + ' </span> <br>' +

                    ' <span> ISBN: ' +  bookDataList[index].isbn  + ' </span> ' +
                    ' </div> ';
            }
            bookList += "</ul>";
            document.getElementById("bookData").innerHTML = bookList;
        }
    };
    xhttp.open("GET", "/dierenpolibhoendie/api/book/list", true);
    xhttp.send();
}

function findGebruikerById() {
    let book = {"id" : 1}
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "/dierenpolibhoendie/api/gebruiker/find", true);
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState>3 && xmlhttp.status==200) {
            console.log(xmlhttp.readyState);
        }
    };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(book));
}

function addBook() {
    let book = {  "id" : null, "name" : document.getElementById("name").value, "author" : document.getElementById("author").value, "isbn" : document.getElementById("isbn").value }
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "/dierenpolibhoendie/api/book/add", true);
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState>3 && xmlhttp.status==200) { loadBookList(); clearInputFields();}
    };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(book));
}

function updateBook()
{
    let book = {  "id" : document.getElementById("bookId").value, "name" : document.getElementById("name").value, "author" : document.getElementById("author").value, "isbn" : document.getElementById("isbn").value }
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("PUT", "/dierenpolibhoendie/api/book/update", true);
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState>3 && xmlhttp.status==200) { loadBookList(); clearInputFields(); document.getElementById("btnSaveBook").innerHTML = "Add Book";}
    };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(book));
}

function clearInputFields()
{
    document.getElementById("bookId").value = "";
    document.getElementById("name").value = "";
    document.getElementById("author").value = "";
    document.getElementById("isbn").value = "";
    document.getElementById("btnSaveBook").innerHTML = "Add Book";
}

function removeBook(bookId)
{
    if ( confirm("Are you sure you want to delete this book?") ) {
        deleteBook(bookId);
    }
}

function deleteBook(bookId)
{
    let book = {  "id" : bookId, "name" : document.getElementById("name").value, "author" : document.getElementById("author").value, "isbn" : document.getElementById("isbn").value }
    var xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "/dierenpolibhoendie/api/book/remove", true);
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState>3 && xhttp.status==200) { loadBookList(); }
    };
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(book));
}

function getBook(bookId)
{
    let book = {  "id" : bookId, "name" : document.getElementById("name").value, "author" : document.getElementById("author").value, "isbn" : document.getElementById("isbn").value }

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState>3 && xhttp.status==200) {
            let foundBook = JSON.parse(this.responseText);

            document.getElementById("bookId").value = foundBook.id;
            document.getElementById("name").value = foundBook.name;
            document.getElementById("author").value = foundBook.author;
            document.getElementById("isbn").value = foundBook.isbn;

            document.getElementById("btnSaveBook").innerHTML = "Update Book";
        }
    };
    xhttp.open("POST", "/dierenpolibhoendie/api/book/getBook", true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(book));
}

function editBook(bookId)
{
    getBook(bookId);
}

function saveBook()
{
    if(validateForm())
    {
        if(document.getElementById("btnSaveBook").innerHTML == 'Add Book')
        {
            addBook();
        }
        else
        {
            updateBook();
        }
    }
}

function validateForm()
{
    let pass = true;
    let name = document.getElementById("name").value;
    let author = document.getElementById("author").value;
    let isbn = document.getElementById("isbn").value;

    if (name == null || name == "", author == null || author == "", isbn == null || isbn == "")
    {
        alert("Please fill in all the fields.");
        pass = false;
    }

    return pass;
}