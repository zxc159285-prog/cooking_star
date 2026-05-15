/**
 * 
 *////// 업데이트 파일 추가 관련 



 document.addEventListener("DOMContentLoaded", function () {

     const maxFileCount = 5;

     const fileArea = document.getElementById("new-file-area");
     const addFileBtn = document.getElementById("add-file-btn");
     const messageBox = document.getElementById("file-count-message");
     const form = document.querySelector("form");

     const existingFileCount = document.querySelectorAll(".image-item").length;

     if (!fileArea || !addFileBtn || !messageBox) {
         console.log("파일 추가 관련 요소를 찾지 못했습니다.");
         return;
     }

     function getDeleteFileCount() {
         const deleteChecks = document.querySelectorAll(".delete-file-check");

         let count = 0;

         deleteChecks.forEach(function (check) {
             if (check.checked) {
                 count++;
             }
         });

         return count;
     }

     function getInputRowCount() {
         return document.querySelectorAll(".file-input-row").length;
     }

     function getSelectedNewFileCount() {
         const attachInputs = document.querySelectorAll(".attach-input");

         let count = 0;

         attachInputs.forEach(function (input) {
             if (input.files && input.files.length > 0) {
                 count++;
             }
         });

         return count;
     }

     function getAvailableInputCount() {
         const deleteFileCount = getDeleteFileCount();

         return maxFileCount - existingFileCount + deleteFileCount;
     }

     function getFinalFileCount() {
         return existingFileCount - getDeleteFileCount() + getSelectedNewFileCount();
     }

     function updateMessage() {
         const availableInputCount = getAvailableInputCount();
         const inputRowCount = getInputRowCount();
         const finalFileCount = getFinalFileCount();

         messageBox.innerText =
             "현재 최종 이미지 수: " + finalFileCount + " / " + maxFileCount
             + " | 추가 가능 칸: " + inputRowCount + " / " + availableInputCount;

         if (finalFileCount > maxFileCount || inputRowCount > availableInputCount) {
             messageBox.style.color = "red";
             return false;
         }

         messageBox.style.color = "#666";
         return true;
     }

     function updateAddButtonState() {
         const availableInputCount = getAvailableInputCount();
         const inputRowCount = getInputRowCount();

         if (inputRowCount >= availableInputCount) {
             addFileBtn.disabled = true;
             addFileBtn.style.opacity = "0.5";
             addFileBtn.style.cursor = "not-allowed";
         } else {
             addFileBtn.disabled = false;
             addFileBtn.style.opacity = "1";
             addFileBtn.style.cursor = "pointer";
         }
     }

     function refresh() {
         updateMessage();
         updateAddButtonState();
     }

     function createFileInput() {
         const row = document.createElement("div");
         row.className = "file-input-row";
         row.style.marginTop = "8px";

         const input = document.createElement("input");
         input.type = "file";
         input.name = "attach";
         input.className = "form-control attach-input";
         input.accept = "image/*";

         const removeBtn = document.createElement("button");
         removeBtn.type = "button";
         removeBtn.innerText = "삭제";
         removeBtn.className = "btn btn-delete";
         removeBtn.style.marginTop = "6px";

         input.addEventListener("change", function () {
             if (!updateMessage()) {
                 alert("기존 이미지와 새 이미지를 합쳐 최대 5장까지만 등록할 수 있습니다.");
                 input.value = "";
             }

             refresh();
         });

         removeBtn.addEventListener("click", function () {
             row.remove();
             refresh();
         });

         row.appendChild(input);
         row.appendChild(removeBtn);

         return row;
     }

     addFileBtn.addEventListener("click", function () {
         const availableInputCount = getAvailableInputCount();
         const inputRowCount = getInputRowCount();

         if (availableInputCount <= 0) {
             alert("이미지가 이미 최대 5장입니다. 기존 이미지를 삭제 체크한 뒤 추가할 수 있습니다.");
             refresh();
             return;
         }

         if (inputRowCount >= availableInputCount) {
             alert("추가 가능한 이미지 칸은 최대 " + availableInputCount + "개입니다.");
             refresh();
             return;
         }

         const newInputRow = createFileInput();
         fileArea.appendChild(newInputRow);

         refresh();
     });

    document.addEventListener("change", function (e) {
         if (e.target.classList.contains("delete-file-check")) {
             const availableInputCount = getAvailableInputCount();
             const inputRowCount = getInputRowCount();

             if (inputRowCount > availableInputCount) {
                 alert("삭제 체크를 해제해서 추가 이미지 칸이 최대 개수를 초과했습니다. 추가 이미지 칸을 줄여주세요.");
             }

             refresh();
         }
     });

     if (form) {
         form.addEventListener("submit", function (e) {
             const finalFileCount = getFinalFileCount();

             if (finalFileCount > maxFileCount) {
                 e.preventDefault();
                 alert("기존 이미지와 새 이미지를 합쳐 최대 5장까지만 등록할 수 있습니다.");
                 return;
             }

             const availableInputCount = getAvailableInputCount();
             const inputRowCount = getInputRowCount();

             if (inputRowCount > availableInputCount) {
                 e.preventDefault();
                 alert("추가 이미지 입력 칸이 허용 개수를 초과했습니다.");
             }
         });
     }

     refresh();
 });