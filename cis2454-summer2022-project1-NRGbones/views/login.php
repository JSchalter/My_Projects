<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">

<html>
    <head>
         <?php include ('topNavigation.php'); ?>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
    <h2>Login</h2>
        <form action="login.php" method="post">        
            <label>Email Address:</label>
            <input type="text" name="email_address"/><br />
             <label>Password:</label>
            <input type="password" name="password"/><br />
            <label>&nbsp;</label>
            <input type="submit" value="Login"/>


        </form>
            </body>
</html>
