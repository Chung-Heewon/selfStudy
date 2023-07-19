const prodNo = location.search.substring(1).split('=')[1] //product.html?prodNo=C0001
                                                          //==>search결과 : ?prodNo=C0001
                                                          //==>substring(1)결과 : prodNo=C0001 
                                                          //==>split('=')결과 : [0]는 prodNo [1]는 C0001


/*$(()=>{
    //상품번호
    const prodNo = sessionStorage.getItem('prodNo')
    $.ajax({
        url:'http://localhost:8888/back/product',
        method : 'post',
        data: `prodNo=${prodNo}`,
        success:(responseObj)=>{ //prodNo : "C0001", "prodName":"아메리카노", "prodPrice" : 1000}
            const prodName=responseObj.prodName
            const prodPrice=responseObj.prodPrice
            
            $('div.product_view>div.product_view_detail>h4>detail.span.ko').html(prodName)
            $('div.product_view>div.product_view_detail>h4>detail.span.price').html(prodPrice)

        },
        error:(xhr)=>{
            alert('에러 :'+xhr.status)
        }
    })
    //상품이미지는 상품번호이미지로 변경
    $('div.product_view>div.product_view_pic>img').attr('src', `../images/${prodNo}.jpg`)
    */
$('button.addtocart').click(()=>{
	const prodNo = $('span.prodNo').html()
	const qt = $('input[name=qt').val()
	$.ajax({
		url : `${backURL}/addtocart`,
		data:`prodNo=${prodNo}&qt=${qt}`,
		success:()=>{
			location.href=`${backURL}/productlist`
		}
	})
	})