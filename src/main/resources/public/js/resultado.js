const form = document.querySelector("form");



form.addEventListener('submit', (e) => {
	e.preventDefault(); // Para que no se actualice la pagina
	const numeros = e.target.elements.lista.value;	
	this.validateNumbers(numeros);
	
	
});

function validateNumbers(numeros){
	let band=true;
	for(var i=0;i<numeros.length;i++){
		if(isNaN(numeros[i]) && band){
			if(numeros[i]!='-' && numeros[i]!='.'){
				band=false;				
				alert("El elemento: "+numeros[i]+" no es válido.");
			}
		}
	}
	if(band){
		location.replace("results?lista="+numeros);    
	}
	
}

