document.getElementById("submit").addEventListener("click", requestLogin);

function requestLogin(){
	
	let user = document.getElementById("username").value;
	let pass = document.getElementById("password").value;
	
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/project1/";
	xhr.open("POST", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let auth = xhr.getResponseHeader("Authorization");
			/*
				session is a storage that lasts for that specific page session(tab)
				here we store our auth token
			*/
			localStorage.setItem("token", auth);
			/*
				if the login is successful, redirects to the home page
			*/
			let parseToken = localStorage.getItem("token");
		
			let s = parseToken.split(":");
				console.log(s[1]);
			if(s[1] == "manager") {
						window.location.href = "http://localhost:8080/project1/static/Manager/ManagerHome.html";			
					
					}
					else {
						window.location.href = "http://localhost:8080/project1/static/Employee.html";			
					}
			
			//window.location.href="http://localhost:8080/project1/static/Employee.html"
		} 
		else if (xhr.readyState == 4){
			//document.getElementById('message').innerHTML='Incorrect credentials!';
			document.getElementById('login').style.color = 'red';
			document.getElementById('login').innerHTML = 'Login Failed!';

		}
	}
	
	/*
		Allows us to send form data as a single block in the body rather than as query params in the URL
	*/
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	let requestBody = `username=${user}&password=${pass}`;
	xhr.send(requestBody);
}