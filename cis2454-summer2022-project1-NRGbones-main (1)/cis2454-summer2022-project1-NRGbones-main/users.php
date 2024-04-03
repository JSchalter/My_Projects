<?php

try {
    require_once 'models/database.php';
    require_once 'models/users.php';
    require_once 'models/stocks.php';
    
    $action = htmlspecialchars(filter_input(INPUT_POST, "action"));

    $username = htmlspecialchars(filter_input(INPUT_POST, "username"));
    $user_symbol = htmlspecialchars(filter_input(INPUT_POST, "user_symbol"));
    $cash_balance = (filter_input(INPUT_POST, "cash_balance", FILTER_VALIDATE_FLOAT));

    if ($action == "insert_or_update" && $username != "" && $user_symbol != "" && $cash_balance != 0) {
        $insert_or_update = filter_input(INPUT_POST, 'insert_or_update');
     
        if ( $insert_or_update == "insert"){
     
        insert_users($username, $user_symbol, $cash_balance);
        } else if ($insert_or_update == "update"){
            update_users($username, $user_symbol, $cash_balance);
        }
            header("location: users.php");
    
    } else if ($action == "delete" && $user_symbol != "") {
        delete_user($user_symbol);
        header("location: users.php");
    } else if ($action != "") {
        $error_messsage = "Missing username, user_symbol, cash_balance";
        include('views/error.php');
    }

    $users = list_users();
    include ('views/users.php');
} catch (Exception $e) {
    $error_messsage = $e->getMessage();
    include('views/error.php');
}
