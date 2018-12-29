<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>  
<script type="text/javascript" src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.js"></script>  
<script type="text/javascript">  
    var websocket = null;  
    if ('WebSocket' in window) {  
        //Websocket的连接  
        websocket = new WebSocket("ws://"+location.host+"/jeesite/websocket/socketServer.do");//WebSocket对应的地址  
    }  
    else if ('MozWebSocket' in window) {  
        //Websocket的连接  
        websocket = new MozWebSocket("ws://"+location.host+"/jeesite/websocket/socketServer.do");//SockJS对应的地址  
    }  
    else {  
        //SockJS的连接  
        websocket = new SockJS("http://"+location.host+"/jeesite/sockjs/socketServer.do");    //SockJS对应的地址  
    }  
    websocket.onopen = onOpen;  
    websocket.onmessage = onMessage;  
    websocket.onerror = onError;  
    websocket.onclose = onClose;  
  
    function onOpen(openEvt) {  
        //alert(openEvt.Data);  
    }  
  
    function onMessage(evt) {  
        alert(evt.data);  
    }  
    function onError() {  
    }  
    function onClose() {  
    }  
  
    function doSend() {  
        if (websocket.readyState == websocket.OPEN) {  
            var msg = document.getElementById("inputMsg").value;  
            websocket.send(msg);//调用后台handleTextMessage方法  
            alert("发送成功!");  
        } else {  
            alert("连接失败!");  
        }  
    }  
  
    window.close = function () {  
    	console.log("关闭窗口");
        websocket.onclose();  
    }  
</script>  
请输入：<textarea rows="3" cols="100" id="inputMsg" name="inputMsg"></textarea>  
<button onclick="doSend();">发送</button>  
</body>
</html>