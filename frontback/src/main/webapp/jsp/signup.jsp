<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" href="../css/signup.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src = "../js/signupjq.js"></script>
    </head>

    <body>
        <h1>가입하기</h1>
        <form class="signup">
            <label for="id">아이디:</label>
            <input name="id" 
                   id="id" 
                   value="id2"
                   placeholder="아이디를 입력하세요">
            <button type="button" class="iddupchk">아이디중복확인</button>

            <label for="pwd">비밀번호:</label>
            <input name="pwd" 
                   id="pwd"
                   value="123"
                   type="password">
                   <!--  pattern="(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}">
                   <!--문자하나, 특수문자하나, 숫자 8자리.--> 
            <label for="pwd1">비밀번호확인:</label>
            <input id="pwd1"
                   value="123"
                   type="password">
            <label for="name">이름:</label>
            <input type="text" name="name" id ="n" >
            <button type = "submit" class="signup">가입</a></button>
            <!--
                form내부에 
                button만 만들면 (type="submit")인 버튼이 된다.
                type=button으로 설명하면 일반버튼이 된다. 
            -->
        </form>
        <!--
            form외부에 
            button을 만들면 일반(type="button")버튼이 된다. 
        -->
    </body>
</html>