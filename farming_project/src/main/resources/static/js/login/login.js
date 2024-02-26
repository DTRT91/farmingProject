const login = {

    init: function() {
    this.bindEvent();
    }

    bindEvent: function() {
    document.querySelector('#btn-login').addEventListener('click', this.login.bind(this));
    },

    login: function(){
    const loginUser = this.getLoginInfo();

        fetch(`/login/verify`, {
        method: 'POST',
        headers: {
            'Content-type' : 'application/json',
        },
        body: JSON.stringify(loginUser)
        })
        .then(response => response.text())
        .then(data => {
        if(!data) return alert('아이디와 비밀번호를 확인해주세요');
        location.href ='/main';
        })
        .catch(error => {
        console.log(error);
        return alert('아이디와 비밀번호를 확인하세요');
        })

    },

    getLoginInfo: function() {
    const id = document.querySelector('#userId').value;
    const password = document.querySelector('#password').value;

    const loginUser ={
        id,
        password
    }

    return loginUser;
    },
}

login.init();

