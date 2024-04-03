<?php
//database server type, location, database name
$data_source_name = 'mysql:host=localhost;dbname=stocks';
//feels bad no time - do not usually put in source code 
$username = 'stockuser';
$password = 'test';
$database = new PDO($data_source_name, $username, $password);

