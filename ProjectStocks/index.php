<?php
include 'navigation.php';

$data_source_name = 'mysql:host=localhost;dbname=stock';
$username = 'stockuser';
$password = 'test';

try {
    $database = new PDO($data_source_name, $username, $password);

    $action = htmlspecialchars(filter_input(INPUT_POST, "action"));

    $symbol = htmlspecialchars(filter_input(INPUT_POST, "symbol"));
    $name = htmlspecialchars(filter_input(INPUT_POST, "name"));
    $current_price = filter_input(INPUT_POST, "current_price", FILTER_VALIDATE_FLOAT);

    if ($action == "insert" && $symbol != "" && $name != "" && $current_price !== false && $current_price > 0) {

        $query = "INSERT INTO stocks (symbol, name, current_price) "
                . "VALUES (:symbol, :name, :current_price)";
        //value binding in PDO protects against sql injection
        $statement = $database->prepare($query);
        $statement->bindValue(":symbol", $symbol);
        $statement->bindValue(":name", $name);
        $statement->bindValue(":current_price", $current_price);

        $statement->execute();

        $statement->closeCursor();
    }

    // Output the navigation links
    generateNavigation();

    // Output the rest of your HTML content
    echo '<table>';
    echo '<tr>';
    echo '<th>Symbol</th>';
    echo '<th>Name</th>';
    echo '<th>Current Price</th>';
    echo '<th>ID</th>';
    echo '</tr>';
    // Fetch stocks for display
    $query = 'SELECT * FROM stocks';
    $statement = $database->prepare($query);
    $statement->execute();
    $stocks = $statement->fetchAll();
    $statement->closeCursor();

    foreach ($stocks as $stock) {
        echo '<tr>';
        echo '<td>' . $stock['symbol'] . '</td>';
        echo '<td>' . $stock['name'] . '</td>';
        echo '<td>' . $stock['current_price'] . '</td>';
        echo '<td>' . $stock['id'] . '</td>';
        echo '</tr>';
    }
    echo '</table>';

    echo '<h2>Add Stock</h2>';
    echo '<form action="index.php" method="post">';
    echo '<label>Symbol:</label>';
    echo '<input type="text"  name="symbol"><br>';
    echo '<label>Name:</label>';
    echo '<input type="text"  name="name" ><br>';
    echo '<label>Current Price:</label>';
    echo '<input type="text" name="current_price"><br>';
    echo '<input type ="hidden" name="action" value="insert">';
    echo '<label>&nbsp;</label><br>';
    echo '<input type="submit" value="Add Stock">';
    echo '</form>';

    echo '<br>';
    echo '<h2>Update Stock</h2>';
    echo '<form action="index.php" method="post">';
    echo '<label>Symbol:</label>';
    echo '<input type="text"  name="symbol"><br>';
    echo '<label>Name:</label>';
    echo '<input type="text"  name="name" ><br>';
    echo '<label>Current Price:</label>';
    echo '<input type="text" name="current_price"><br>';
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

