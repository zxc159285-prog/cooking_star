/**
 * 
 */
const add =document.getElementById("add")
const fileform = document.getElementById("fileform")
const deletBtn =document.getElementById("delete")

let fileSize=fileform.getAttribute("data-file-size")

let addFileCount=0;

let maxFileCount=5;

add.addEventListener("click",()=>{

    if(fileSize + addFileCount >= maxFileCount){
        alert("파일 추가는 최대 5개 입니다")

        return;
    }

    const div =document.createElement("div")

    div.innerHTML=`<label for="file">음식 사진</label>			
    <input type="file" class="form-control-file" name="attach"></input>
     <button type="button" class="btn btn-danger file-remove-btn">삭제</button>`
;
fileform.append(div);
    addFileCount++;

})
fileform.addEventListener("click", (e) => {
    if (e.target.classList.contains("file-remove-btn")) {
        e.target.parentElement.remove();
        addFileCount--;
    }
});