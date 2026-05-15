$(document).ready(function() {
    // 1. $("#server-msg").val() 대신, JSP에서 선언한 변수를 직접 사용합니다.
    const message = serverMessage; 
    
    // 2. 메시지가 존재하고 비어있지 않은지 확인
    if(message && message.trim() !== "") {
        alert(message);
    }
});