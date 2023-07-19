$(() => {
    //-- 상품목록 얻기 START --
    //요청 URL : http://localhost:8888/back1/productlist
    //요청방식 : GET
    //요청 전달 데이터 : 없음

    //응답형식 : JSON
    //응답성공데이터는 js 객체

   
    
    
    //-- 상품클릭할 때 할 일 START-- $.deferred(promise())
    // const divProductObj = $('div.product')
    // console.log((divProductObj).length)
   
    $('div.product').click((e)=>{
        const prodNo = $(e.currentTarget).attr('class').split(" ")[1]
        alert(prodNo+' clicked')
       $.ajax({
		   url:`${backURL}/product`,
		   method:'get',
		   data: `prodNo=${prodNo}`,
		   success:(responseData)=>{
			   $('section').empty()
			   $('section').html(responseData)
		   }
	   })

       // $('section').load(`./product.html?prodNo=${prodNo}`)

    })
    //-- 상품클릭할 때 할 일 END--
 
    $('div.pagegroup>span').click((e)=>{
		const classValue = $(e.target).attr('class')//page3, page4, page7
		const pageNo = classValue.substring(4)
		//alert(pageNo+"페이지를 요청합니다")
		location.href=`${backURL}/productlist?cp=${pageNo}`
	})
	})
    //div.product객체가 만들어졌을때, 상품등록을 미리해놓을 수 있다. 
