const img = document.getElementsByClassName('img');   
const h1 = document.getElementById('heading');

for (var i = 0; i < img.length; i++) {

    img[i].addEventListener('mouseover', getMap);
    img[i].addEventListener('mouseout', getFlag);

}
 
function getMap(e) {

    // change the h1 heading to country name

    h1.innerHTML = e.target.name;

    // change the image to map of this country

    e.target.src = "images/"+e.target.name+"Map.jpg";

}

function getFlag(e) {

    // restore to default
    h1.innerHTML = "Countries and Flags";

    e.target.src = "images/"+e.target.name+"Flag.jpg";

}
