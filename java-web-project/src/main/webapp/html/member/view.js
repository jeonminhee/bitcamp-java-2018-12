var param = location.href.split('?')[1];
if (param) {
  document.querySelector('h1').innerHTML = "회원 조회"
  loadData(param.split('=')[1])
  var el = document.querySelectorAll('.bit-new-item');
  for(e of el){
    e.style.display = 'none';
  }
  } else {
    document.querySelector('h1').innerHTML = "새 회원"
    var el = document.querySelectorAll('.bit-view-item');
    for(e of el){
      e.style.display = 'none';
  }
}

document.querySelector('#add-btn').onclick = () => {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if(xhr.readyState != 4 || xhr.status != 200){
      return;
    } 
    var data = JSON.parse(xhr.responseText);
    
    if(data.status == 'success'){
      location.href = "index.html"
    } else {
      alert('등록 실패입니다!\n' + data.message)
    }
    
  };
  xhr.open('POST', '../../app/json/member/add', true);
  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencodeda")
  
  var name = document.querySelector('#name').value,
      email = document.querySelector('#email').value,
      password = document.querySelector('#password').value,
      photoFile = document.querySelector('#photoFile').value,
      tel = document.querySelector('#tel').value;
      
  xhr.send(
      "name=" + encodeURIComponent(name) + 
      "&email=" + email + 
      "&password=" + password + 
      "&photoFile=" + photoFile +
      "&tel=" + tel);
};

document.querySelector('#delete-btn').onclick = () => {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if(xhr.readyState != 4 || xhr.status != 200){
      return;
    } 
    var data = JSON.parse(xhr.responseText);
    
    if(data.status == 'success'){
      location.href = "index.html"
    } else {
      alert('삭제 실패입니다!\n' + data.message)
    }
  };
  
  var no = document.querySelector('#no').value;
  xhr.open('GET', '../../app/json/member/delete?no=' + no, true);
  xhr.send();
};

document.querySelector('#update-btn').onclick = () => {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if(xhr.readyState != 4 || xhr.status != 200){
      return;
    } 
    var data = JSON.parse(xhr.responseText);
    
    if(data.status == 'success'){
      location.href = "index.html"
    } else {
      alert('변경 실패입니다!\n' + data.message)
    }
    
  };
  xhr.open('POST', '../../app/json/member/update', true);
  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
  
  var no = document.querySelector('#no').value;
  var title = document.querySelector('#title').value;
  var contents = document.querySelector('#contents').value;
  var startDate = document.querySelector('#startDate').value;
  var endDate = document.querySelector('#endDate').value;
  var totalHours = document.querySelector('#totalHours').value;
  var dayHours = document.querySelector('#dayHours').value;
  
  var qs = 
    'no=' + no +
    '&title=' + encodeURIComponent(title) +
    '&contents=' + encodeURIComponent(contents) +
    '&startDate=' + startDate +
    '&endDate=' + endDate +
    '&totalHours=' + totalHours +
    '&dayHours=' + dayHours;
  
  xhr.send(qs);
};

function loadData(no) {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if(xhr.readyState != 4 || xhr.status != 200){
      return;
    }
    
    var data = JSON.parse(xhr.responseText);
    console.log(data.photo);
    document.querySelector('#no').value = data.no;
    document.querySelector('#name').value = data.name;
    document.querySelector('#email').value = data.email;
    document.querySelector('#password').value = data.password;
    document.querySelector('#photo').src = "/java-web-project/upload/member/" + data.photo;
    document.querySelector('#tel').value = data.tel;
    document.querySelector('#registeredDate').value = data.registeredDate;
  };
  
  xhr.open('GET', '../../app/json/member/detail?no=' + no, true);
  xhr.send();
}



















