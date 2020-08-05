<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  boardNumber is ${boardVO.boardNumber}. </P>
<P>  boardId is ${boardVO.boardId}. </P>

<a class="dropdown-item" href="test?boardVO=${boardVO}">link</a>

<div class="col-2 text-center">
	<button type="button" id="test" name="test" class="btn btn-success">save</button>
</div>



</body>
</html>

<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script>
	$('#test').click(function(){
			
	//	alert(JSON.stringify("${boardVO}"));
	var obj = {"boardNumber": "${boardVO.boardNumber}", "boardId":"${boardVO.boardId}"}
	//var obj = {"boardNumber": 100, "boardId":"abcd"}
	alert("${boardVO}");
		
			//jQuery.ajaxSettings.traditional = true;
	 		$.ajax({
	 			url:"test",
	 			type:"post",
	 			data:JSON.stringify(obj), //
	 			dataType: "json",
	 			contentType : "application/json",
	 			success:function(data){
	 				if(data != 1){
	 					//alert("");
	 				} else {
	 					//alert("");
	 				}
	 			}, error:function(request, status, error){
	 				//alert("");
	 			}
	 		});
	});
</script>
