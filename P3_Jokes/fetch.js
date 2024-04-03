const options = {
	method: 'GET',
	headers: {
		'X-RapidAPI-Key': 'ce9834b9d2msh35b73155c38ea24p17cb8ajsn01dd3df894a4',
		'X-RapidAPI-Host': 'dad-jokes.p.rapidapi.com'
	}
};

fetch('https://dad-jokes.p.rapidapi.com/random/joke', options)
	.then(response => response.json())
	.then(response => console.log(response))
	.catch(err => console.error(err));