 console.log(loginUser);
        if(loginUser != null){
        document.querySelector('#loginModalBtn').classList.add('d-none');
        document.querySelector('#logout').classList.remove('d-none');
        console.log("로그인 완료");
        } else if (loginUser == null) {
        document.querySelector('#loginModalBtn').classList.remove('d-none');
        document.querySelector('#logout').classList.add('d-none');
        console.log('로그아웃 완료');
        }