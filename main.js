var http = require('http');
var fs = require('fs');
var url = require('url');
var qs = require('querystring');
var template = require('./lib/template.js');
var path = require('path');
var sanitizeHtml = require('sanitize-html');
var mysql = require('mysql');
//패스워드 본인 db에 맞게 변경 할 것
var db = mysql.createConnection({
  host:'localhost',
  user:'root',
  password:'wlsgml214',
  database:'graduate'
});
db.connect();

var app = http.createServer(function(request,response){
    var _url = request.url;
    var queryData = url.parse(_url, true).query;
    var pathname = url.parse(_url, true).pathname;
    if(pathname === '/'){
      if(queryData.major_number === undefined){
        db.query(`SELECT * FROM majors`, function(error,majors){
          var major_name = 'Welcome';
          var major_number = '안녕';
          var list = template.list(majors);
          var html = template.HTML(major_name, list,
            `<h2>${major_name}</h2>${major_number}`,
            `<a href="/create">create</a>`
          );
          response.writeHead(200);
          response.end(html);});
      } else {
        db.query(`SELECT * FROM majors`, function(error,majors){
          if(error){
            throw error;
          }
          db.query(`SELECT * FROM majors WHERE major_number=?`,[queryData.major_number], function(error2, majors){
            if(error2){
              throw error2;
            }
           var major_name = majors[0].major_name;
           var major_number = majors[0].major_number;
           var list = template.list(majors);
           var html = template.HTML(major_name, list,
             `<h2>${major_name}</h2>${major_number}`,
             ` <a href="/create">create</a>
                 <a href="/update?major_number=${queryData.major_number}">update</a>
                 <form action="delete_process" method="post">
                   <input type="hmajor_numberden" name="major_number" value="${queryData.major_number}">
                   <input type="submit" value="delete">
                 </form>`
           );
           response.writeHead(200);
           response.end(html);
          })
       });
      }
    } else if(pathname === '/create'){
      db.query(`SELECT * FROM majors`, function(error,majors){
        var major_name = 'Create';
        var list = template.list(majors);
        var html = template.HTML(major_name, list,
          `
          <form action="/create_process" method="post">
            <p><input type="text" name="major_name" placeholder="major_name"></p>
            <p>
              <textarea name="major_number" placeholder="major_number"></textarea>
              <textarea name="category" placeholder="category"></textarea>
              <textarea name="recommend_time" placeholder="recommend_time"></textarea>
              <textarea name="this_time" placeholder="this_time"></textarea>
              <textarea name="professor_name" placeholder="professor_name"></textarea>
              <textarea name="division_number" placeholder="division_number"></textarea>
            </p>
            <p>
              <input type="submit">
            </p>
          </form>
        `, '');
        response.writeHead(200);
        response.end(html);
      });
    } else if(pathname === '/create_process'){
      var body = '';
      request.on('data', function(data){
          body = body + data;
      });
      request.on('end', function(){
          var post = qs.parse(body);
          db.query(`
          INSERT INTO majors (major_name, major_number, category, recommend_time, this_time, professor_name, division_number) 
            VALUES(?, ?, ?, ?, ?, ?, ?)`,
          [post.major_name, post.major_number, post.category, post.recommend_time, post.this_time, post.professor_name, post.division_number], 
          function(error, result){
            if(error){
              throw error;
            }
            response.writeHead(302, {Location: `/?major_number=${result.major_number}`});
            response.end();
          }
        )
      });
    } else if(pathname === '/update'){
          db.query('SELECT * FROM topic', function(error, topics){
            if(error){
              throw error;
            }
          db.query(`SELECT * FROM topic WHERE id=?`,[queryData.id], function(error2, topic){
            if(error2){
              throw error2;
            }
            `
            <form action="/update_process" method="post">
              <input type="hidden" name="id" value="${topic[0].id}">
              <p><input type="text" name="title" placeholder="title" value="${topic[0].title}"></p>
              <p>
                <textarea name="description" placeholder="description">${topic[0].description}</textarea>
              <p>
                <input type="submit">
              </p>
            </form>
            `,
            `<a href="/create">create</a> <a href="/update?id=${topic[0].id}">update</a>`
          response.writeHead(200);
          response.end(html);
        });
      });
    } else if(pathname === '/update_process'){
      var body = '';
      request.on('data', function(data){
          body = body + data;
      });
      request.on('end', function(){
          var post = qs.parse(body);
          var major_number = post.major_number;
          var major_name = post.major_name;
          var major_number = post.major_number;
          fs.rename(`data/${major_number}`, `data/${major_name}`, function(error){
            fs.writeFile(`data/${major_name}`, major_number, 'utf8', function(err){
              response.writeHead(302, {Location: `/?major_number=${major_name}`});
              response.end();
            })
          });
      });
    } else if(pathname === '/delete_process'){
      var body = '';
      request.on('data', function(data){
          body = body + data;
      });
      request.on('end', function(){
          var post = qs.parse(body);
          var major_number = post.major_number;
          var filteredmajor_number = path.parse(major_number).base;
          fs.unlink(`data/${filteredmajor_number}`, function(error){
            response.writeHead(302, {Location: `/`});
            response.end();
          })
      });
    } else {
      response.writeHead(404);
      response.end('Not found');
    }
});
app.listen(3000);
