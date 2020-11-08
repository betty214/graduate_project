/*이건 사실 원본에서 DB를 web형식으로 보여주느라 필요했던 건데 지우거나 수정해도 될듯
다만 main.js에 연동된 부분이 많으니 신중하게 할 것*/
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
