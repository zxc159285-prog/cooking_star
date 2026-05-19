document.addEventListener("DOMContentLoaded", function() {
	document.querySelectorAll(".btn-delete").forEach(function(button) {
		button.addEventListener("click", function() {
			const recipeNum = this.getAttribute("data-num");

			if (recipeNum == null || recipeNum === "") {
				return;
			}

			if (!confirm(recipeNum + "\uBC88 \uB808\uC2DC\uD53C\uB97C \uC815\uB9D0 \uC0AD\uC81C\uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?")) {
				return;
			}

			const formData = new URLSearchParams();
			formData.append("recipeNum", recipeNum);

			fetch("./delete", {
				method: "POST",
				headers: {
					"Content-Type": "application/x-www-form-urlencoded"
				},
				body: formData
			})
				.then(function(response) {
					if (!response.ok) {
						throw new Error("\uC0AD\uC81C \uC694\uCCAD\uC774 \uC2E4\uD328\uD588\uC2B5\uB2C8\uB2E4. status: " + response.status);
					}

					return response.json();
				})
				.then(function(result) {
					if (result > 0) {
						alert("\uC0AD\uC81C \uB418\uC5C8\uC2B5\uB2C8\uB2E4");
						location.href = "./myList";
						return;
					}

					if (result === -1) {
						alert("\uB85C\uADF8\uC778\uC774 \uD544\uC694\uD569\uB2C8\uB2E4");
						location.href = "/member/login";
						return;
					}

					alert("\uC0AD\uC81C\uC5D0 \uC2E4\uD328\uD588\uC2B5\uB2C8\uB2E4");
				})
				.catch(function(error) {
					console.error(error);
					alert("\uC0AD\uC81C \uCC98\uB9AC \uC911 \uBB38\uC81C\uAC00 \uBC1C\uC0DD\uD588\uC2B5\uB2C8\uB2E4");
				});
		});
	});
});
