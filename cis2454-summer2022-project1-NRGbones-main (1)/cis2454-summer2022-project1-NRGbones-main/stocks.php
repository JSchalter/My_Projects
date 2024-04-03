<?php

try {
    require_once 'models/database.php';
    require_once 'models/stocks.php';
    require_once 'models/users.php';
    
    $action = htmlspecialchars(filter_input(INPUT_POST, "action"));

    $symbol = htmlspecialchars(filter_input(INPUT_POST, "symbol"));
    $name = htmlspecialchars(filter_input(INPUT_POST, "name"));
    $current_price = (filter_input(INPUT_POST, "current_price", FILTER_VALIDATE_FLOAT));

    
    if ($action == "insert_or_update" && $symbol != "" && $name != "" && $current_price != 0) {
        $insert_or_update = filter_input(INPUT_POST, 'insert_or_update');
        
        if ( $insert_or_update == "insert"){
            
        insert_stock($symbol, $name, $current_price);
        } else if ($insert_or_update == "update"){
            update_stock($symbol, $name, $current_price);
        }
            header("location: stocks.php");
    
    } else if ($action == "delete" && $symbol != "") {
        delete_stock($symbol);
        header("location: stocks.php");
    } else if ($action != "") {
        $error_messsage = "Missing symbol, name, current_price";
        include('views/error.php');
    }

    $stocks = list_stocks();
    include ('views/stocks.php');
} catch (Exception $e) {
    $error_messsage = $e->getMessage();
    include('views/error.php');
}


