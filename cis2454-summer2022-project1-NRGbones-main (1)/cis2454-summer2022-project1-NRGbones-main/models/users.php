<?php

function list_users() {

    global $database;

    $query = 'SELECT username, user_symbol, cash_balance, id FROM users';

    //prepare query
    $statement = $database ->prepare($query);

    //run query
    $statement->execute();

    //might be risky with loads of data
    $users = $statement->fetchALL();

    $statement->closeCursor();

    return $users;
}

function list_one_user ($user_id) {

    global $database;

    $query = 'SELECT username, user_symbol, cash_balance, id FROM users WHERE id = :user_id';

    //prepare query
    $statement = $database ->prepare($query);

    $statement->bindValue(":user_id", $user_id);
    
    //run query
    $statement->execute();

    //might be risky with loads of data
    $users = $statement->fetchALL();

    $statement->closeCursor();

    return $users;
}

function insert_users ($username, $user_symbol, $cash_balance) {

    global $database;

    //substitutions
    $query = "INSERT INTO users (username, user_symbol, cash_balance) "
            . "VALUES (:username, :user_symbol, :cash_balance)";

    //value binding in PDO protects against SQL INJECTION
    $statement = $database->prepare($query);
    $statement->bindValue(":username", $username);
    $statement->bindValue(":user_symbol", $user_symbol);
    $statement->bindValue(":cash_balance", $cash_balance);

    $statement->execute();

    $statement->closeCursor();
}

function update_users ($username, $user_symbol, $cash_balance) {

    global $database;

    $query = "update users set username = :username, cash_balance = :cash_balance "
            . " where user_symbol = :user_symbol";

    //value binding in PDO protects against SQL INJECTION
    $statement = $database->prepare($query);
    $statement->bindValue(":username", $username);
    $statement->bindValue(":user_symbol", $user_symbol);
    $statement->bindValue(":cash_balance", $cash_balance);

    $statement->execute();
    $statement->closeCursor();
}

function delete_user ($user_symbol) {

    global $database;

    $query = " delete from users "
            . " where user_symbol = :user_symbol";

    //value binding in PDO protects against SQL INJECTION
    $statement = $database->prepare($query);
    $statement->bindValue(":user_symbol", $user_symbol);

    $statement->execute();

    $statement->closeCursor();
}