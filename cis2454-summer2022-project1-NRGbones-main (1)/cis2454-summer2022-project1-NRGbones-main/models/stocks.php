<?php

function list_stocks() {

    global $database;

    $query = 'SELECT symbol, name, current_price, id FROM stocks';

    //prepare query
    $statement = $database->prepare($query);

    //run query
    $statement->execute();

    //might be risky with loads of data
    $stocks = $statement->fetchALL();

    $statement->closeCursor();

    return $stocks;
}
function list_one_stock ($stock_id) {

    global $database;

    //substitutions
    $query = 'SELECT symbol, name, current_price, id FROM stocks WHERE id = :stock_id';

    //value binding in PDO protects against SQL INJECTION
    $statement = $database->prepare($query);
    $statement->bindValue(":stock_id", $stock_id);
    $statement->execute();
    $stocks = $statement->fetchALL();
    $statement->closeCursor();
    
    return $stocks;
} 
    
function insert_stock($symbol, $name, $current_price) {

    global $database;

    //substitutions
    $query = "INSERT INTO stocks (symbol, name, current_price) "
            . "VALUES (:symbol, :name, :current_price)";

    //value binding in PDO protects against SQL INJECTION
    $statement = $database->prepare($query);
    $statement->bindValue(":symbol", $symbol);
    $statement->bindValue(":name", $name);
    $statement->bindValue(":current_price", $current_price);

    $statement->execute();

    $statement->closeCursor();
}

function update_stock($symbol, $name, $current_price) {

    global $database;

    $query = "update stocks set name = :name, current_price = :current_price "
            . " where symbol = :symbol";

    //value binding in PDO protects against SQL INJECTION
    $statement = $database->prepare($query);
    $statement->bindValue(":symbol", $symbol);
    $statement->bindValue(":name", $name);
    $statement->bindValue(":current_price", $current_price);

    $statement->execute();
    $statement->closeCursor();
}

function delete_stock($symbol) {

    global $database;

    $query = " delete from stocks "
            . " where symbol = :symbol";

    //value binding in PDO protects against SQL INJECTION
    $statement = $database->prepare($query);
    $statement->bindValue(":symbol", $symbol);

    $statement->execute();

    $statement->closeCursor();
}
