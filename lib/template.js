module.exports = {
  HTML:function(major_name, list, body, control){
    return `
    <!doctype html>
    <html>
    <head>
      <major_name>과목명 : ${major_name}</major_name>
      <meta charset="utf-8">
    </head>
    <body>
      <h1><a href="/">WEB</a></h1>
      ${list}
      ${control}
      ${body}
    </body>
    </html>
    `;
  },list:function(majors){
    var list = '<ul>';
    var i = 0;
    while(i < majors.length){
      list = list + `<li><a href="/?major_number=${majors[i].major_number}">${majors[i].major_name}</a></li>`;
      i = i + 1;
    }
    list = list+'</ul>';
    return list;
  }
}
