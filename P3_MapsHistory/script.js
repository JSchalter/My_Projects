// I7kVLNl6gSLZjQE7wPzFzQ==YuQaNqj9Pl0Z1IAe
   
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>

$.ajax({
    Type: 'POST',
        api_url: "https://api.api-ninjas.com/v1/historicalfigures?name=johnharington",
        headers: { 'X-Api-Key': 'I7kVLNl6gSLZjQE7wPzFzQ==YuQaNqj9Pl0Z1IAe'},
        data: "john=harington",
        success: function(data) {
        console.log(data);      
       alert("Sucess: " + data);
    },   
    });

// Defining async function
async function getapi(url) {
	
	// Storing response
	const response = await fetch(url);
	
	// Storing data in form of JSON
	var data = await response.json();
	console.log(data);
	if (response) {
		hideloader();
	}
	show(data);
}
// Calling that async function
getapi(api_url);

// Function to hide the loader
function hideloader() {
	document.getElementById('loading').style.display = 'none';
}
// Function to define innerHTML for HTML table
function show(data) {
	let tab =
		`<tr>
		<th>Name</th>
		<th>Office</th>
		<th>Position</th>
		<th>Salary</th>
		</tr>`;
	
	// Loop to access all rows
	for (let r of data.list) {
		tab += `<tr>
	<td>${r.name} </td>
	<td>${r.office}</td>
	<td>${r.position}</td>
	<td>${r.salary}</td>		
</tr>`;
	}
	// Setting innerHTML as tab variable
	document.getElementById("john harington").innerHTML = tab;
}

