//dom트리가 완성되고 
//렌더링준비가 완료되었을때 widnow객체의 load이벤트가 발생한다. 
$(() => {
    const formObj = $('form.signup')

    //아이디입력란 객체찾기
    const inputIdObj = $('form.signup>input[id=id]')

    //아이디중복확인버튼 객체 찾기
    const btIdDupchk = $('form.signup>button.iddupchk')

    //가입버튼객체 찾기
    const btSignup = $('form.signup>button.signup')
    
    
	const backURL='/frontback'
    //아이디중복확인버튼-일반버튼,
    btIdDupchk.click(() => {
		
        /*if (inputIdObj.val() == 'id1') {
            alert('이미가입된 아이디입니다.')
        } else {
            btSignup.show()
        }
        */
	   //DB와 연결하여 확인
	   
        $.ajax({
			url : `${backURL}/Iddupchk`,
			method: 'get',
			data : `id=${inputIdObj.val()}`,
			success:(responseData)=>{
				if(responseData==0){
					alert('이미사용중인 아이디입니다.')
				}else{
					alert('사용가능한 아이디입니다')
					btSignup.show()}
			},
			errorr: ()=>{
				
			}
		})
    })

    //가입버튼-전송버튼 클릭 ->
    //폼의 서브밋이벤트발생

    //--폼 서브밋이벤트발생시 할 일 START--
    formObj.submit((e) => {
        //아이디입력값이 'id1'인 경우
        //이미사용중인 아이디입니다. 경고창을 보여준다. 
        //아이디입력값이 'id1'가 아닌 경우
        //가입버튼을 화면에 보여주기하기 

        //비밀번호1,2가 일치 확인
        const pwdObj = $('form.signup>input[id=pwd]')
        const pwd1Obj = $('#pwd1')
        if (pwdObj.val() != pwd1Obj.val()) {
            alert('비밀번호가 일치하지 않습니다.')
            pwdObj.focus();
            return false;
        }
        alert(formObj.serialize())
        $.ajax({
            url: `${backURL}/signup`,
            method: 'post',
            data: formObj.serialize(),
            //{"id" : inputIdObj.val()}, //post method 방식일때만 가능
            //{id:inputIdObj
            //,pwd:pwdObj, 
            //name:'form.signup>input[name=name]'},
            //"id=abc&pwd=p1&name=1",
            // success: (responseData) => {
                // const responseObj = JSON.parse(responseData) //json 문자열을 js객체로 변환 <= 응답형식이 "text/html"인 경우 파싱해줘야 함
                
            success: (responseData) => { //응답형식이 "application/json"이면 자바스크립트에서 파싱할 필요 없음
                if(responseData == 0){
                    //실패경우 할 일
                    alert("가입실패")
                }else{
                    //성공경우 할 일
                    alert("가입성공")
                    location.href='layout.jsp'
                    
                }
                // alert(responseData)
            },
            error: () => {

            }

        })
        return false; //e.preventdefault() e.stopPropagation()


    })
    //--폼 서브밋이벤트발생시 할 일 End--
    inputIdObj.focus(() => {


        //--아이디입력란에 'focus'이벤트발생시 할 일 START --
        btSignup.hide()
        //--가입버튼 사라지기
    })
    //--아이디입력란에 focus이벤트발생시 할 일 END --
})