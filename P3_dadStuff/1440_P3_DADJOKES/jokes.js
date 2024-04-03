var limit = 1
$.ajax({
    method: 'GET',
    url: 'https://api.api-ninjas.com/v1/dadjokes?limit=' + limit,
    headers: { 'X-Api-Key': 'I7kVLNl6gSLZjQE7wPzFzQ==YuQaNqj9Pl0Z1IAe'},
    contentType: 'application/json',
    success: function(result) {
        console.log(result);
    },
    error: function ajaxError(jqXHR) {
        console.error('Error: ', jqXHR.responseText);
    }
});