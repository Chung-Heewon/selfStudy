$(() => {
    const loginObj = $('form.login')

    const cbObj = loginObj.find("input[type=checkbox]")//아이디저장
    const savedId = localStorage.getItem("savedId")
    if (savedId != null) {
        loginObj.find("input[name=id]").val(savedId)
    }

    // cbObj.click((e) => {
       
    // })
    loginObj.submit((e) => {
        if (cbObj.prop('checked')) {//체크된 경우
            const idValue = loginObj.find('input[name=id]').val()
            localStorage.setItem("savedId", idValue)
        } else { //체크해제된 경우
            localStorage.removeItem("savedId")
        }
        
        //const data = loginObj.serialize()
        const backURL = '/frontback'

        $.ajax({
            url: `${backURL}/login`,
            method: 'post',
            data: loginObj.serialize(),
            success: (responseData) => {
				if(responseData==0){
					alert('로그인실패')
					$(`form.login>input[name=id]`).focus()
				}else{ //로그인이 성공된 경우
				location.href='layout.jsp'
				console.log("로그인성공")
				}
			},
			error:(xhr)=>{
				alert("에러 : "+xhr.status)
			}
			})
			return false;
		})
	})