package com.my.test.control;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

//   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      InputStream is = request.getInputStream();//요청Body영역을 읽어오는 스트림
//      int readValue = -1;
//      while( (readValue = is.read()) != -1) {
//         System.out.print((char)readValue);
//      }
//   }

   // 요청의 기본 인코딩은 utf-8이 아니다. ISO-88 ~ 이거다, 그래서 파일 이름이 한글인 경우 한글 깨짐이 발생할 수 있따.
   private static final String CHARSET = "utf-8";
   private static final String ATTACHES_DIR = "C:\\attaches"; // 첨부될 파일들이 저장될 경로,
   private static final int LIMIT_SIZE_BYTES = 1024 * 1024; // 첨부될 파일의 max-size

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      File attachesDir = new File(ATTACHES_DIR);
      if (!attachesDir.exists()) {
         attachesDir.mkdir(); // 해당 디렉토리가 없다면 만든다.
      }

      // 파일 업로드용 라이브러리에서 제공하는 클래스
      DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
      fileItemFactory.setRepository(attachesDir); // 파일 경로
      fileItemFactory.setSizeThreshold(LIMIT_SIZE_BYTES); // 첨부파일 최대크기 설정
      ServletFileUpload fileUpload = 
    		  new ServletFileUpload(fileItemFactory);

      
      try {
    	  fileUpload.setFileSizeMax(LIMIT_SIZE_BYTES); //첨부파일 최대크기 설정
         List<FileItem> items = fileUpload.parseRequest(request); // 첨부파일 분석
         for (FileItem item : items) {
            if (item.isFormField()) { // 일반 요청 전달데이터(첨부파일 x)인 경우 true
               System.out.println("파라미터 명 : " + item.getFieldName() + ", 파라미터 값 :  " + item.getString(CHARSET));
            } else { // 첨부된 데이터
               System.out.println("파일 파라미터 명 : " + item.getFieldName() // 요청 전달데이터 이름 현재는 f1
                     + ", 파일 명 : " + item.getName() // 첨부파일 이름
                     + ",  파일 크기 : " + item.getSize()); // 첨부파일 크기
               if (item.getSize() > 0) {
                  // String separator = File.separator;
                  // int index = item.getName().lastIndexOf(separator);
                  // String fileName = item.getName().substring(index + 1);
                  String fileName = item.getName(); // 이렇게 해줘도 된다.
                  File uploadFile = new File(ATTACHES_DIR, fileName);// 경로, 파일
                  item.write(uploadFile);
               }
            }
         }
         System.out.println("파일 업로드 완료");
      } catch (Exception e) {
         e.printStackTrace();
         System.out.println("파일 업로드 중 오류가  발생하였습니다");
      }
   }
}