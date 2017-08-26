
window.update = function() {
	var firstName = document.getElementById('inp1').value;
	var lastName = document.getElementById('inp2').value;

	document.getElementById('inp3').value = firstName + " " + lastName;
}

$("#D6").click(function() {
	var inputStr = $("#inp1").val();
	if (inputStr.length < 8)
		$("#error_msg1").html("First Name must be atleast 8 characters");
	else {
		$("#error_msg1").html("");

	}
})
$("#D6").click(function() {
					var password1 = $("#pwd1").val();
					var password2 = $("#pwd2").val();
					var regularExpression = /^(?=.[0-9])(?=.[!@#$%^&])[A-Za-z]\w{10,50}$/;

					if (!regularExpression.test(password1)) {
						$("#error_msg2")
								.html(
										"Password must be atleast 10 characters in size and should contain atleast one speacial character and one digit");
					} else {
						$("#error_msg2").html("");
						if (password1 == password2) {
							$("#myForm").submit();
						} else {
							alert("Passwords Do Not Match!");

						}
					}

				})


function myFunction() {
	document.getElementById("myForm").reset();
}
function cancel() {
	window.location = "login.html";
}
function Register() {
	$(".requiredAttr").each(function() {
		if ($(this).val().length < 1) {
			document.getElementById("th1").style.display = "block";
			$(this).focus();
			return false;
		} else {
			return true;
		}
	});
	return false;

}
