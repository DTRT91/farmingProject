const login = {

  init: function() {
    this.bindEvent();
  },

  bindEvent: function() {
    console.log(document.querySelector('#btn-login'))
    document.querySelector('#btn-login').addEventListener('click', this.login.bind(this));
    document.querySelector('#logout').addEventListener('click', this.logout.bind(this));
  },

  login: function() {
    console.log('btn-login clicked');
    const loginUser = this.getLoginInfo();
    console.log(loginUser);

    fetch(`/login/verify`, {
      method: 'POST',
      headers: {
        'Content-type': 'application/json',
      },
      body: JSON.stringify(loginUser)
    })
    .then(response => response.text())
     .then(data => {
         const parsedData = JSON.parse(data);
         console.log(parsedData)

        if(parsedData) {
        console.log('success')
        console.log(data);
        location.href = '/main';

        }
        else {
        console.log('fail')
        return alert('아이디와 비밀번호를 확인하세요');
        }
    })
    .catch(error => {
      console.log(error)
      return alert('아이디와 비밀번호를 확인하세요');
    })
  },

  logout: function(){
  console.log('logout 버튼 클릭');
  const loginUser = this.getLoginInfo();
  fetch(`/login/logout`, {
    method: 'POST',
       headers: {
         'Content-type': 'application/json',
       },
       body: JSON.stringify(loginUser)
     })
     .then(response => response.json())
      .then(data => {
          console.log(data)
          location.href = '/main';
      })
      .catch(error => {
            console.log(error)
            return alert('아이디와 비밀번호를 확인하세요');
      })
    },

  getLoginInfo: function() {
    const memberId = document.querySelector('#memberId').value;
    console.log(memberId);
    const memberPassword = document.querySelector('#memberPassword').value;

    const loginUser = {
      memberId,
      memberPassword
    }

    return loginUser;
  },


}

login.init();

