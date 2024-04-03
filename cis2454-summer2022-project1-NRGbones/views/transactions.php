<!DOCTYPE html>
<html>
    <head>
        <title>Transaction list</title>
    </head>
    <?php include ('topNavigation.php'); ?>
    </br>
    <body> 
        <table>               
            <tr>
                <th> User ID </th>
                <th> Stock ID </th>
                <th> Quantity </th>
                 <th>  Price </th>
                <th> Timestamp </th>
                <th> ID </th>
            </tr>
            <?php foreach($transaction as $transaction): ?>
                <tr>
                    <td><?php echo $transaction['user_id']; ?></td>
                    <td><?php echo $transaction['stock_id']; ?></td>
                    <td><?php echo $transaction['quantity']; ?></td>
                    <td><?php echo $transaction['price']; ?></td>
                     <td><?php echo $transaction['timestamp']; ?></td>
                      <td><?php echo $transaction['id']; ?></td>
                </tr>        
            <?php endforeach ?>      
        </table>  
        <h2> Add Transaction </h2>
        <form action="transactions.php" method="post">        
            <label> User ID: </label>
            <input type="text" name="user_id"/><br />
            <label> Stock ID: </label>
            <input type="text" name="stock_id"/><br />
            <label> Quantity :</label>
            <input type="text" name="quantity"/><br />
            <input type="hidden" name="action" value="add"/>
            <input type="submit" value="Submit" >
            
          </form>
        <h2>Update Transaction: </h2>
        <form action="transactions.php" method="post">        
            <label> Transaction ID: </label>
            <input type="text" name="transaction_id"/><br />
            <label> Stock ID: </label>
            <input type="text" name="stock_id"/><br />
            <label> Quantity :</label>
            <input type="text" name="quantity"/><br />
            <label>  User ID: </label>
            <input type="text" name="user_id"/><br />
            <label>  Price : </label>
            <input type="text" name="price"/><br />
            <input type="hidden" name="action" value="update"/>  
            <input type="submit" value="Submit" >
            
        </form>
        <h2>Delete transaction</h2>
        <form action="transactions.php" method="post"> 
            <label> Transaction ID: </label>
            <input type="text" name="transaction_id"/><br />
            <input type="hidden" name="action" value="delete"/>
            <input type="submit" value="Delete transaction" >
        </form>        
    </body>
    <?php include ('footer.php'); ?>
</html>