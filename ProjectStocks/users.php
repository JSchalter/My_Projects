<?php

$data_source_name = 'mysql:host=localhost;dbname=stock';

$username = 'stockuser';
$password = 'test';

$users = []; // Initialize $users as an empty array

try {
    $database = new PDO($data_source_name, $username, $password);

    $action = htmlspecialchars(filter_input(INPUT_POST, "action"));

    $name = htmlspecialchars(filter_input(INPUT_POST, "name"));
    $email_address = filter_input(INPUT_POST, "email_address");
    $cash_balance = filter_input(INPUT_POST, "cash_balance", FILTER_VALIDATE_FLOAT);

    if ($action == "insert" && $name != "" && $email_address != "" && $cash_balance !== false && $cash_balance > 0) {

        $query = "INSERT INTO users (name, email_address, cash_balance) "
            . "VALUES (:name, :email_address, :cash_balance)";
        // value binding in PDO protects against SQL injection
        $statement = $database->prepare($query);
        $statement->bindValue(":name", $name);
        $statement->bindValue(":email_address", $email_address);
        $statement->bindValue(":cash_balance", $cash_balance);

        $statement->execute();

        $statement->closeCursor();
    } else if ($action == "update" && $email_address != "" && $name != "" && $cash_balance !== false && $cash_balance > 0) {

        $query = "UPDATE users SET name = :name, email_address = :email_address, cash_balance = :cash_balance "
            . "WHERE email_address = :email_address";
        // value binding in PDO protects against SQL injection
        $statement = $database->prepare($query);
        $statement->bindValue(":name", $name);
        $statement->bindValue(":email_address", $email_address);
        $statement->bindValue(":cash_balance", $cash_balance);

        $statement->execute();

        $statement->closeCursor();
    } else if ($action == "delete" && $email_address != "") {

        $query = "DELETE FROM users "
            . "WHERE email_address = :email_address";
        // value binding in PDO protects against SQL injection
        $statement = $database->prepare($query);
        $statement->bindValue(":email_address", $email_address);

        $statement->execute();

        $statement->closeCursor();
    } else if ($action != "") {
        echo "<p> Missing, name, email address, or cash balance.</p> ";
    }

    $query = 'SELECT name, email_address, cash_balance, id FROM users';

    $statement = $database->prepare($query);

    $statement->execute();

    $users = $statement->fetchAll();

    $statement->closeCursor();
} catch (Exception $e) {
    $error_message = $e->getMessage();
    echo "<p>Error message: $error_message </p>";
}
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Email Address</th>
        <th>Cash Balance</th>
        <th>ID</th>
    </tr>
    <?php foreach ($users as $user) : ?>
        <tr>
            <td><?php echo $user['name']; ?></td>
            <td><?php echo $user['email_address']; ?></td>
            <td><?php echo $user['cash_balance']; ?></td>
            <td><?php echo $user['id']; ?></td>
        </tr>
    <?php endforeach; ?>
</table>

<h2>Add user</h2>
<form action="users.php" method="post">
    <label>Name:</label>
    <input type="text" name="name"><br>
    <label>Email:</label>
    <input type="text" name="email_address"><br>
    <label>Cash Balance:</label>
    <input type="text" name="cash_balance"><br>
    <input type="hidden" name="action" value="insert">
    <label>ID</label><br>
    <input type="text" name="id">
    <input type="submit" value="Add User">
</form>

<br>
<h2>Update user</h2>
<form action="users.php" method="post">
    <label>Name:</label>
    <input type="text" name="name"><br>
    <label>Email:</label>
    <input type="text" name="email_address"><br>
    <label>Cash Balance:</label>
    <input type="text" name="cash_balance"><br>
    <input type="hidden" name="action" value="update">
    <label>&nbsp;</label><br>
    <input type="submit" value="Update User Information">
</form>

<h2>Delete user</h2>
<form action="users.php" method="post">
    <label>Email:</label>
    <input type="text" name="email_address"><br>
    <input type="hidden" name="action" value="delete">
    <label>&nbsp;</label><br>
    <input type="submit" value="Delete User's Information">
</form>
</body>
</html>
