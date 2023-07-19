$(()=>{
   $("form").submit(()=>{
   let formData = new FormData($("form")[0]);
      $.ajax({
         url:"/frontback/upload",
         method:"POST",
         data:formData,
         processData:false,
         contentType:false,
         success:(r)=>{
            console.log(r)
            alert("파일첨부 성공")
         },
         error:()=>{
            alert("파일첨부 실패")
         }
      })
      return false;
   })
})