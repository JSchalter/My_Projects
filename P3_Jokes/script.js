
function getList(){
	//get reference to div and clear the div
	var myTableDiv = document.getElementById("myTable"); 
	myTableDiv.innerHTML="";
	
	//create dynamic table	
	var table = document.createElement('table');	
    var tableBody = document.createElement('tbody');
    table.appendChild(tableBody);	
    
	//create the header row
	var tr = document.createElement('tr');
    tableBody.appendChild(tr);
	var tableHeader= ['Joke Setup','The Punchline'];
	for (var i=0; i<2; i++){
		var th = document.createElement('th');
		th.innerText=tableHeader[i];
        tr.appendChild(th);		
	}  
	
	
	//fetch from the api and display the recipe by category response in table row
	var URLjoke='https://dad-jokes.p.rapidapi.com/random/joke';	
	const options = {
		method: 'GET',
		headers: {
		'X-RapidAPI-Key': 'ce9834b9d2msh35b73155c38ea24p17cb8ajsn01dd3df894a4',
		'X-RapidAPI-Host': 'dad-jokes.p.rapidapi.com'
		}
	};
    
	fetch(URLjoke, options)
		.then(response => response.json())
		.then(json => {
		
		for(let i=0; i<json.body.length;i++){
				
				var tr = document.createElement('tr');
				tableBody.appendChild(tr);

				var td = document.createElement('td');
				td.appendChild(document.createTextNode(json.body[i].setup));
				tr.appendChild(td);
			   
				var td = document.createElement('td');
				td.appendChild(document.createTextNode(json.body[i].punchline));
				tr.appendChild(td);
			   			
			}
		})
		.catch(err => console.error(err));
		
	//create paragraph and put the table into the div	
	//var p = document.createElement('p');
	//p.innerHTML="Click on the image for more information";
	//myTableDiv.appendChild(p);
	
	//put the table into the div
    myTableDiv.appendChild(table);

	
}	


