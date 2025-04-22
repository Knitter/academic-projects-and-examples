function startClock(){
	tick();
}

function tick(){
	document.getElementById("horas").innerHTML = new Date().toLocaleString();
	setTimeout("tick()", 1000);  	
}

function login(){
	if (document.getElementById("username").value == "")
		alert('O campo "utilizador" é de preenchimento obrigatório.');
	else if (document.getElementById("password").value == "")
		alert('O campo "palavra-passe" é de preenchimento obrigatório.');										
	else{
		document.getElementById("sender").value = location.href;
		document.getElementById("login").submit();
	}
}

function handleEnterUsername(e){
	if(!e)
		var e = window.event;
	
	if (e.keyCode == 13){
		document.getElementById("password").focus();
	}
} 

function handleEnterPassword(e){
	if(!e)
		var e = window.event;
	
	if (e.keyCode == 13)
		login();
}

function toggleLayer(whichLayer){
	var s = document.getElementById(whichLayer).style;
	
	if(s.display != ""){
		s.display = "";
		s = document.getElementById(whichLayer + "Square").style;
		s.backgroundColor = "#4F7DB0";
		s = document.getElementById("content").style;
//		window.location.reload( false );
	}else{
		var hidables = document.getElementsByName("hidable");
		var i;
		for(i = 0; i<hidables.length; i++){
			var t = hidables[i].style;
			t.display = "";
		}
		var squares = document.getElementsByName("square");
		for(i = 0; i<squares.length; i++){
			t = squares[i].style;
			t.backgroundColor = "#4F7DB0";
		}
		s.display = "block";
		s = document.getElementById(whichLayer + "Square").style;
		s.backgroundColor = "#99CCFF";
		s = document.getElementById("content").style;
	}
}

function validarRegisto() {
	if(document.getElementById("nome").value == "") {
		alert("O campo 'nome' é de preenchimento obrigatório");
	}else if(document.getElementById("apelido").value == "") {
		alert("O campo 'apelido' é de preenchimento obrigatório");
	}else if(document.getElementById("endereco").value == "") {
		alert("O campo 'endereco' é de preenchimento obrigatório");
	}else if(document.getElementById("codPostal").value == "") {
		alert("O campo 'código postal' é de preenchimento obrigatório");
	}else if(document.getElementById("localidade").value == "") {
		alert("O campo 'localidade' é de preenchimento obrigatório");
	}else if(document.getElementById("contribuinte").value == "") {
		alert("O campo 'contribuinte' é de preenchimento obrigatório");
	}else if(document.getElementById("usernameRegisto").value == "") {
		alert("O campo 'utilizador' é de preenchimento obrigatório");
	}else if(document.getElementById("passwordRegisto").value == "") {
		alert("O campo 'palavra-passe' é de preenchimento obrigatório");
	}else if((document.getElementById("email").value == "") || (document.getElementById("email").value.search("@") == -1) || (document.getElementById("email").value.search("[.*]") == -1 )) {
		alert("O e-mail introduzido não é válido");	
	}else if((document.getElementById("email").value.search(";") != -1) || (document.getElementById("email").value.search(",") != -1) || ( document.getElementById("email").value.search(" ") != -1)) {
		alert("Não pode especificar mais de um e-mail.");
	}else {	
		document.getElementById("registar").submit();
	}
}

function validarNovoAdmin() {
	if(document.getElementById("utilizadorAdmin").value == "") {
		alert("O campo 'Utilizador' é de preenchimento obrigatório");
	}else if(document.getElementById("passwordAdmin").value == "") {
		alert("O campo 'Palavra-passe' é de preenchimento obrigatório");
	}else if((document.getElementById("emailAdmin").value == "") || (document.getElementById("emailAdmin").value.search("@") == -1) || (document.getElementById("emailAdmin").value.search("[.*]") == -1 )) {
		alert("O e-mail introduzido não é válido");	
	}else if((document.getElementById("emailAdmin").value.search(";") != -1) || (document.getElementById("emailAdmin").value.search(",") != -1) || ( document.getElementById("emailAdmin").value.search(" ") != -1)) {
		alert("Não pode especificar mais de um e-mail.");
	}else {	
		document.getElementById("formNovoAdministrador").submit()
	}
}


function getCurrentYear(){
	$date = new Date();
	return $date.getFullYear();
}

function getCurrentDay(){
	$date = new Date();
	return $date.getDay();
}  

function getCurrentMonth(){
	$date = new Date();
	return $date.getMonth() + 1;
} 

function validarNovoProduto() {
	document.getElementById("escondido").value = 1;
	document.getElementById("formNovoProduto").submit();
}

function changeRPP(who, superCat, categoria){
	var newLocation = "./produtos.php?super=" + superCat + "&categoria=" + categoria + "&rpp=" + document.getElementById(who).value;
	window.location = newLocation;
}
