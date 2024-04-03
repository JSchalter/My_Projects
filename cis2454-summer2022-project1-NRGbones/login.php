<?php
try {
require_once 'models/database.php';
require_once 'models/login.php';

$email_address = htmlspecialchars(filter_input(INPUT_POST, "email_address")); 
$password = htmlspecialchars(filter_input(INPUT_POST, "password"));       
$password_hash = password_hash($password, PASSWORD_DEFAULT);

$is_logged_in = login($email_address, $password);

if ($is_logged_in) {
    echo "logged in successfully";
}
else { 
    echo "Invalid username or password";

}

include('views/login.php');
} catch ( Exception $e) {
    $error_messsage = $e->getMessage();
    include('views/error.php');
}


