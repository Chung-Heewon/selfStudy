const frontURL = 'http://localhost:5500/html'
const backURL = '/frontback'
function showAjax(url, targetObj) {
    targetObj.load(url)
}
$(() => {
    const menuObjs = $('header>nav>ul>li>a')
    const sectionObj = $('section')
    /*-----------------------------
    <a href="./a.html">
    주의 : js에서  
        document.querySelector("a").href속성값은 'http://127.0.0.1:5500/html/a.html'
        jq에서
        $("a").attr("href")속성값은 './a.html'이다
    -------------------------------*/
    menuObjs.click((e) => {
        switch ($(e.target).attr('href')) {
            case `${backURL}/jsp/login.jsp`:
                showAjax($(e.target).attr('href'), sectionObj)
                break
            case 'logout' : //로그아웃메뉴
            	$.ajax({
					url:`${backURL}/logout`,
					success:()=>{
						location.href=`${backURL}/jsp/layout.jsp`
					}
				})
            	break
            case `${backURL}/jsp/signup.jsp`:
                showAjax($(e.target).attr('href'), sectionObj)
                break
            case `${backURL}/productlist`:
                location.href= `${backURL}/productlist`
                break
        }
        return false
    });
})