<select name="user_symbol">
    <?php foreach ( $users as $user ) : ?>
    <option value='<?php echo $user['user_symbol'] ?>'><?php echo $user['username'] ?> </option>
    <?php endforeach; ?>
</select>

