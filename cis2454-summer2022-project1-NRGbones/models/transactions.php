<?php

function list_transaction() {
    global $database;

    $query = 'SELECT user_id, stock_id, quantity, price, timestamp, id '
            . 'FROM transaction';

    //prepare query
    $statement = $database->prepare($query);

    $statement->execute();

    //might be risky with loads of data
    $transaction = $statement->fetchALL();

    $statement->closeCursor();

    return $transaction;
}

function insert_transaction ( $user_id, $stock_id, $quantity, $price) {
    global $database;

    //substitutions
    $query = "INSERT INTO transaction ( user_id, stock_id, quantity, price ) "
            . "VALUES (:user_id, :stock_id, :quantity, :price ) ";

    //value binding in PDO protects against SQL INJECTION
    $statement = $database->prepare ($query);
    $statement->bindValue(":user_id", $user_id);
    $statement->bindValue(":stock_id", $stock_id);
    $statement->bindValue(":quantity", $quantity);
    $statement->bindValue(":price", $price);
   
    
    $statement->execute();

    $statement->closeCursor();
}

function update_transaction ( $user_id, $stock_id, $quantity, $price, $transaction_id) {

    global $database;

    $query = "update transaction set  user_id = :user_id, "
            . " stock_id = :stock_id, "
            . " quantity = :quantity, "
            . " price = :price "
            . " where id = :transaction_id";

    //value binding in PDO protects against SQL INJECTION
    $statement = $database->prepare($query);
    $statement->bindValue(":user_id", $user_id);
    $statement->bindValue(":stock_id", $stock_id);
    $statement->bindValue(":quantity", $quantity);
    $statement->bindValue(":price", $price);
    $statement->bindValue(":transaction_id", $transaction_id);

    $statement->execute();
    $statement->closeCursor();
}

function delete_transaction ($transaction_id) {

    global $database;

    $query = " delete from transaction "
            . " where id = :transaction_id";

    //value binding in PDO protects against SQL INJECTION
    $statement = $database->prepare($query);
    $statement->bindValue(":transaction_id", $transaction_id);

    $statement->execute();

    $statement->closeCursor();
}
