/**
 * 
 */

const goodBtn = document.getElementById("goodBtn")
const goodCount=document.getElementById("goodCount")


goodBtn.addEventListener("click",()=>{
	
	const recipeNum =goodBtn.getAttribute("data-recipe-num")
	
	const form = new FormData();
	
	form.append("recipeNum",recipeNum)

	fetch("/myrecipe/good",{
		method:"POST",
		body:form
		
	}).then(r=>r.json())
	.then(data=>{
		
		goodCount.innerText=data.goodCount
		
		if(data.good){
			goodBtn.innerText="좋아요 취소"
			
		}else{
			goodBtn.innerText="좋아요"
			
		}
	})
	
	
	
	
	
	
})