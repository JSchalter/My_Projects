<!DOCTYPE html>
<html>
    <head>
        <meta charset="UFT-8">
        <title> List</title>
    </head>
    <?php include ('topNavigation.php'); ?>
    </br>
    <body> 
        <table>    
            <tr>
            </tr>
        </table>  
        </br>
        <h2>Buy or Sell Stocks </h2>
        <form action="transaction.php" method="post">        
            <label>User ID:</label>
            <input type="text" name="user_id"/><br />
            <label>Stock ID:</label>
            <input type="text" name="stock_id"/><br />
            <label>Quantity:</label>
            <input type="text" name="quantity"/><br />
            <input type="hidden" name='action' value='buy'/>
            <label>&nbsp;</label>
            <input type="submit" value='buy'/>
            </form>
            <form action="transaction.php" method="post">        
            <label>Transaction ID:</label>
            <input type="text" name="transaction_id"/><br />
            <label>Stock ID:</label>
            <input type="text" name="stock_id"/><br />
            <label>Quantity:</label>
            <input type="text" name="quantity"/><br />
            <input type="hidden" name='action' value='update'/>
            <label>&nbsp;</label>
            <input type="submit" value='update'/>
            </form>
           <form action="transaction.php" method="post">        
            <label>Transaction ID:</label>
            <input type="text" name="transaction_id"/><br />
            <label>Stock ID:</label>
            <input type="text" name="stock_id"/><br />
            <input type="hidden" name='action' value='delete'/>
            <label>&nbsp;</label>
            <input type="submit" value='delete'/>
            </form>
        <br>
    <?php include ('footer.php'); ?>
        </html>
