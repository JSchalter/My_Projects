<!DOCTYPE html>
<html>
    <head>
        <meta charset="UFT-8">
        <title>User List</title>
    </head>
    <?php include ('topNavigation.php'); ?>
    </br>
    <body> 
        <table>    
            <tr>
                <th>Username</th>
                <th>User Symbol</th>
                <th>Cash Balance</th>
                <th>ID</th>
            </tr>
            <?php foreach ($users as $user) : ?>
                <tr>
                    <td><?php echo $user['username']; ?></td>
                    <td><?php echo $user['user_symbol']; ?></td>
                    <td><?php echo $user['cash_balance']; ?></td>
                    <td><?php echo $user['id']; ?></td>

                </tr>        

            <?php endforeach; ?>      
        </table>  
        </br>
        <h2>Add or Update User</h2>
        <form action="users.php" method="post">        
            <label>Username:</label>
            <input type="text" name="username"/><br />
            <label>User Symbol:</label>
            <input type="text" name="user_symbol"/><br />
            <label>Cash Balance:</label>
            <input type="text" name="cash_balance"/><br />
            <input type="hidden" name='action' value='insert_or_update'/>
            <input type="radio" name="insert_or_update" value="insert" checked>Add</br>
            <input type="radio" name="insert_or_update" value="update" >Update</br>

            <label>&nbsp;</label>
            <input type="submit" value="Submit"/>
        </form>
        </br>

        </br>
        <h2>Delete User</h2>
        <form action="users.php" method="post">        
            <?php include("userDropDown.php") ?>
            <input type="hidden" name='action' value='delete'/>
            <label>&nbsp;</label>
            <input type="submit" value="Delete User"/>
        </form>        
    </body>
    </br>
    <?php include ('footer.php'); ?>
</html>
