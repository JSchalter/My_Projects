<?php
include 'navigation.php';

$data_source_name = 'mysql:host=localhost;dbname=stock';
$username = 'stockuser';
$password = 'test';

$transactions = []; // Initialize $transactions as an empty array

try {
    $database = new PDO($data_source_name, $username, $password);

    $action = htmlspecialchars(filter_input(INPUT_POST, "action"));

    $user_id = filter_input(INPUT_POST, "user_id", FILTER_VALIDATE_INT);
    $symbol = htmlspecialchars(filter_input(INPUT_POST, "symbol"));
    $quantity = filter_input(INPUT_POST, "quantity", FILTER_VALIDATE_INT);

    if ($action == "insert" && $user_id !== false && $symbol != "" && $quantity !== false && $quantity > 0) {

        // Query to get the current price from the stock table
        $stock_query = "SELECT current_price FROM stocks WHERE symbol = :symbol";
        $stock_statement = $database->prepare($stock_query);
        $stock_statement->bindValue(":symbol", $symbol);
        $stock_statement->execute();
        $stock_result = $stock_statement->fetch();
        $current_price = $stock_result['current_price'];

        // Query to check if the user has enough cash_balance
        $user_query = "SELECT cash_balance FROM users WHERE user_id = :user_id";
        $user_statement = $database->prepare($user_query);
        $user_statement->bindValue(":user_id", $user_id);
        $user_statement->execute();
        $user_result = $user_statement->fetch();
        $user_cash_balance = $user_result['cash_balance'];

        // Calculate total purchase price
        $total_price = $current_price * $quantity;

        if ($user_cash_balance < $total_price) {
            echo "<p>Error: Insufficient funds to make the purchase.</p>";
        } else {
            // Insert the transaction row
            $transaction_query = "INSERT INTO transactions (user_id, symbol, quantity, total_price) "
                . "VALUES (:user_id, :symbol, :quantity, :total_price)";
            $transaction_statement = $database->prepare($transaction_query);
            $transaction_statement->bindValue(":user_id", $user_id);
            $transaction_statement->bindValue(":symbol", $symbol);
            $transaction_statement->bindValue(":quantity", $quantity);
            $transaction_statement->bindValue(":total_price", $total_price);
            $transaction_statement->execute();

            // Update the user's cash_balance
            $new_cash_balance = $user_cash_balance - $total_price;
            $update_user_query = "UPDATE users SET cash_balance = :new_cash_balance WHERE user_id = :user_id";
            $update_user_statement = $database->prepare($update_user_query);
            $update_user_statement->bindValue(":new_cash_balance", $new_cash_balance);
            $update_user_statement->bindValue(":user_id", $user_id);
            $update_user_statement->execute();

            $update_user_statement->closeCursor();
            $transaction_statement->closeCursor();
        }

        $user_statement->closeCursor();
        $stock_statement->closeCursor();
    } else if ($action != "") {
        echo "<p> Missing or invalid user_id, symbol, or quantity.</p> ";
    }

    // Output the navigation links
    generateNavigation();

    // Output the rest of your HTML content
    echo '<table>';
    echo '<tr>';
    echo '<th>Symbol</th>';
    echo '<th>User ID</th>';
    echo '<th>Price</th>';
    echo '<th>Quantity</th>';
    echo '<th>ID</th>';
    echo '</tr>';
    foreach ($transactions as $transaction) {
        echo '<tr>';
        echo '<td>' . $transaction['symbol'] . '</td>';
        echo '<td>' . $transaction['user_id'] . '</td>';
        echo '<td>' . $current_price . '</td>'; // Fixed column name
        echo '<td>' . $transaction['id'] . '</td>';
        echo '<td>' . $transaction['quantity'] . '</td>';
        echo '</tr>';
    }
    echo '</table>';

    echo '<h2>Purchase Stock</h2>';
    echo '<form action="index.php" method="post">';
    echo '<label>User ID</label>';
    echo '<input type="text"  name="user_id"><br>';
    echo '<label> Symbol</label>';
    echo '<input type="text"  name="symbol" ><br>';
    echo '<label>Quantity</label>';
    echo '<input type="text" name="quantity"><br>';
    echo '<input type ="hidden" name="action" value="insert">';
    echo '<label>&nbsp;</label><br>';
    echo '<input type="submit" value="Purchase Stock">';
    echo '</form>';

    echo '<br>';
    echo '<h2>Update Stock</h2>';
    echo '<form action="index.php" method="post">';
    echo '<label>User ID</label>';
    echo '<input type="text"  name="user_id"><br>';
    echo '<label> Symbol</label>';
    echo '<input type="text"  name="symbol" ><br>';
    echo '<label>Quantity</label>';
    echo '<input type="text" name="quantity"><br>';
    echo '<input type ="hidden" name="action" value="update">';
    echo '<label>&nbsp;</label><br>';
    echo '<input type="submit" value="Update Stock">';
    echo '</form>';

    echo '<h2>Delete Stock</h2>';
    echo '<form action="index.php" method="post">';
    echo '<label>Symbol:</label>';
    echo '<input type="text"  name="symbol"><br>';
    echo '<input type ="hidden" name="action" value="delete">';
    echo '<label>&nbsp;</label><br>';
    echo '<input type="submit" value="Delete Stock">';
    echo '</form>';

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
</body>
</html>

