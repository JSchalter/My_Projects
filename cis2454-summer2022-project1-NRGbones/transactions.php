<?php
try {
require_once 'models/database.php';
require_once 'models/transactions.php';
require_once 'models/users.php';
require_once 'models/stocks.php';


$action = htmlspecialchars(filter_input(INPUT_POST, "action"));

$user_id = htmlspecialchars(filter_input(INPUT_POST, "user_id", FILTER_VALIDATE_INT));
$stock_id = htmlspecialchars(filter_input(INPUT_POST, "stock_id", FILTER_VALIDATE_INT));
$quantity = (filter_input(INPUT_POST, "quantity", FILTER_VALIDATE_INT));
$price = htmlspecialchars(filter_input(INPUT_POST, "price"));
$transaction_id = htmlspecialchars(filter_input(INPUT_POST, "transaction_id", FILTER_VALIDATE_INT));



if ($action == "add" && $user_id != 0 && $stock_id != 0 && $quantity != 0) {
        
        $users = list_users();
        $name  = "";
        $email_address = "";        
        $cash_balance = 0;
      
        foreach ( $users as $user ) {
                if ( $user['id'] == $user_id ) {
                    $name = $user['name'];
                    $email_address = $user['email_address'];
                    $cash_balance = $user['cash_balance'];
                }
           }

           $stocks = list_stocks($stock_id);
           $stock_price = 0;
           foreach ( $stocks as $stock ) {
                     if ( $stock['id'] == $stock_id ) {
                           $stock_price = $stock['current_price'];
                     }
           }    

           $total_cost = $stock_price * $quantity;
           
                                if ($cash_balance >= $total_cost){
                                           insert_transaction ( $user_id, $stock_id , $quantity ,  $stock_price );
                                           $new_balance = $cash_balance - $total_cost;
                                           update_user ( $name , $email_address , $new_balance );

                                } else {
                                          $error_message = "insufficent funds to purchase stocks";
                                          include ('views/error.php');
                                }
    } 
    else if ( $action  == "update" && $user_id != 0 && $stock_id != 0 
            && $quantity != 0 && $transaction_id != 0 ) {              
        update_transaction ( $user_id, $stock_id , $quantity , $price, $transaction_id );
           header ("Location: transactions.php");
                             
    } else if ( $action == "delete" && $transaction_id != 0 ) {
           delete_transaction ($transaction_id);
         header ("Location: transactions.php");

    } 
    if ($action != " " ) {
    $error_message = "Missing stock_id, user_id, quantity, or transaction_id";
    include ('views/error.php');
}

$transaction = list_transaction ();

include ('views/transactions.php');
} catch  ( Exception $e ) {
    $error_messsage = $e->getMessage();
    include('views/error.php');
}

