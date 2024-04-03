<?php

try {
require_once 'models/database.php';
require_once 'models/users.php';
require_once 'models/stocks.php';
require_once 'models/transaction.php';

$action = htmlspecialchars(filter_input(INPUT_POST, "action"));
$transaction_id = htmlspecialchars(filter_input(INPUT_POST, "transaction_id"));
$user_id = htmlspecialchars(filter_input(INPUT_POST, "user_id"));
$stock_id = htmlspecialchars(filter_input(INPUT_POST, "stock_id"));
$quantity = (filter_input(INPUT_POST, "quantity", FILTER_VALIDATE_FLOAT));

if ($action == "buy" && $user_id != "" && $stock_id != "" && $quantity != 0) {
$buy = filter_input(INPUT_POST, 'buy');

$user = list_one_user ($user_id);

foreach ($user as $user) {
$username = $user['username'];
$user_symbol = $user['user_symbol'];
$cash_balance = $user['cash_balance'];
}

$stocks = list_one_stock ($stock_id);
foreach ($stocks as $stock) {
$current_price = $stock['current_price'];
}

$current_price = $current_price * $quantity;
if ($cash_balance != NULL && $current_price != NULL) {
if ($cash_balance > $current_price) {
insert_transaction($user_id, $stock_id, $quantity, $current_price);
$cash_balance = $cash_balance - $current_price;
update_users ($username, $user_symbol, $cash_balance);
}
}
}

if ($action == "update" && $transaction_id != "" && $stock_id != "" && $quantity != 0){
    $stocks = list_one_stock ($stock_id);
    foreach ($stocks as $stock) {
    $current_price = $stock['current_price'];
}
    $price = $current_price * $quantity;
    
    update_transaction ($transaction_id, $stock_id, $quantity, $price);
    
}

if ($action == "delete" && $transaction_id != "" && $stock_id != ""){
echo $transaction_id;
   $transaction = list_one_transaction($transaction_id);
   echo 'mehhh';
foreach ($transaction as $transaction) {
$user_id = $transaction['user_id'];
$quantity = $transaction['quantity'];

}

$user = list_one_user($user_id);

foreach ($user as $user) {
$username = $user['username'];
$user_symbol = $user['user_symbol'];
$cash_balance = $user['cash_balance'];
}

$stocks = list_one_stock($stock_id);
foreach ($stocks as $stock) {
$current_price = $stock['current_price'];

}
    $current_price = $current_price * $quantity;
    $cash_balance = $cash_balance + $current_price;
update_users($username, $user_symbol, $cash_balance);

      delete_transaction ($transaction_id);

}

$transaction = list_transaction();
include ('views/transaction.php');
} catch (Exception $e) {
$error_messsage = $e->getMessage();
include('views/error.php');
}


